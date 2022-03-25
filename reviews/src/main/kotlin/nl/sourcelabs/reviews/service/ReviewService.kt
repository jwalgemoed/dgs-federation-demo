package nl.sourcelabs.reviews.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.netflix.dgs.codgen.generated.types.Review
import nl.sourcelabs.reviews.model.RawReview
import org.springframework.stereotype.Service
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.io.path.name

@Service
class ReviewService {
    private val reviews: MutableList<Review> = mutableListOf()
    init {
        val mapper = ObjectMapper()
        try {
            Files.walk(Paths.get("/Users/fatihdemirhan/Desktop/dev_p/dgs-federation-demo/reviews/src/main/resources/static/")).use { paths ->
                paths
                    .filter(Files::isRegularFile)
                    .forEach {
                        val rawReview = mapper.readValue(it.toFile(), RawReview::class.java)
                        if (rawReview.items!!.isNotEmpty()) {
                            val id = rawReview.imDbId
                            val movieTitle = rawReview.title
                            reviews.addAll(rawReview.items.map { item ->
                                Review(
                                    id,
                                    movieTitle,
                                    id + item.username,
                                    item.username,
                                    item.warningSpoilers,
                                    item.date,
                                    if(item.rate.isNullOrBlank()) 0.toDouble() else item.rate.toDouble(),
                                    item.title,
                                    item.content
                                )
                            })
                        }
                    }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getAllReviews(): List<Review> = reviews
    fun getAllReviewsForId(id: String): List<Review> = reviews.filter { it.id == id }

}

