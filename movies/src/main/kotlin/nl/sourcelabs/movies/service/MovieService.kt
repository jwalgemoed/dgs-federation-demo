package nl.sourcelabs.movies.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.netflix.dgs.codgen.generated.types.Movie
import org.springframework.stereotype.Service
import java.io.File
import java.io.IOException

@Service
class MovieService {
    private var movies: List<Movie> = listOf()

    init {
        val mapper = ObjectMapper()
        try {
            val movieArray:Array<Movie> = mapper.readValue(File("/Users/fatihdemirhan/Desktop/dev_p/dgs-federation-demo/movies/src/main/resources/static/top50.json"), Array<Movie>::class.java)
            movies = movieArray.toList()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getAllMovies(): List<Movie> = movies

    fun searchMovies(titleFilter: String) = movies.filter { it.title!!.contains(titleFilter) }

}