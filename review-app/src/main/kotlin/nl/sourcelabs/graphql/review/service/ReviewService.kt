package nl.sourcelabs.graphql.review.service

import nl.sourcelabs.graphql.review.model.Review
import org.springframework.stereotype.Service

@Service
class ReviewService {

    private val reviews = mutableListOf(
        Review(id = 1, albumId = 1, score = 1, text = "It's really bad."),
        Review(id = 2, albumId = 2, score = 3, text = "I've heard better."),
        Review(id = 3, albumId = 3, score = 5, text = "Awesome stuff.")
    )

    fun all(): List<Review> {
        return reviews.toList()
    }
}