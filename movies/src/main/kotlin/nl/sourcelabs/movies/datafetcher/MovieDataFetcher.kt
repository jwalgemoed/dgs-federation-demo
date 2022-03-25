package nl.sourcelabs.movies.datafetcher

import com.netflix.dgs.codgen.generated.types.Movie
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import nl.sourcelabs.movies.service.MovieService

@DgsComponent
class MovieDataFetcher(private val movieService: MovieService) {
    @DgsQuery
    fun movies(@InputArgument titleFilter : String?): List<Movie> {
        return if(titleFilter.isNullOrBlank()) {
            movieService.getAllMovies()
        } else {
            movieService.searchMovies(titleFilter)
        }
    }
}