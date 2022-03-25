package nl.sourcelabs.critics.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.netflix.dgs.codgen.generated.types.Critic
import nl.sourcelabs.critics.model.RawCritic
import org.springframework.stereotype.Service
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.name

@Service
class CriticService {
    private val critics: MutableList<Critic> = mutableListOf()
    init {
        val mapper = ObjectMapper()
        try {
            Files.walk(Paths.get("/Users/fatihdemirhan/Desktop/dev_p/dgs-federation-demo/critics/src/main/resources/static/")).use { paths ->
                paths
                    .filter(Files::isRegularFile)
                    .forEach {
                        val rawCritic = mapper.readValue(it.toFile(), RawCritic::class.java)
                        if (!rawCritic.results.isNullOrEmpty()) {
                            val id = it.name.substring(0, it.name.indexOf('.'))
                            critics.addAll(rawCritic.results.map { result ->
                                Critic(
                                    id,
                                    result.movieTitle,
                                    result.rating,
                                    id+result.author,
                                    result.author,
                                    result.title,
                                    result.content,
                                    result.link?.url?:"https://www.nytimes.com"
                                )
                            })
                        }
                    }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getAllCritics(): List<Critic> = critics
    fun getAllCriticsById(id: String): List<Critic> = critics.filter { it.id == id }

}