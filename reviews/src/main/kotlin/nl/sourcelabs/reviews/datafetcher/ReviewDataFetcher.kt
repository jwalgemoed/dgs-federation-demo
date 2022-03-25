package nl.sourcelabs.reviews.datafetcher

import com.netflix.dgs.codgen.generated.types.Movie
import com.netflix.dgs.codgen.generated.types.Review
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.DgsEntityFetcher
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import nl.sourcelabs.reviews.service.ReviewService

@DgsComponent
class ReviewDataFetcher(private val reviewService: ReviewService) {

    @DgsEntityFetcher(name= "Movie")
    fun movie(values: Map<String?, Any?>): Movie? {
        return Movie(values["id"] as String?, null)
    }

    @DgsData(parentType = "Movie", field = "reviews")
    fun reviewsFetcher(dataFetchingEnvironment: DgsDataFetchingEnvironment): MutableList<Review?>? {
        val movie: Movie = dataFetchingEnvironment.getSource()
        return reviewService.getAllReviewsForId(movie.id!!).toMutableList()
    }

    @DgsQuery
    fun reviews(@InputArgument idFilter : String?): List<Review> =
        if(idFilter.isNullOrBlank()) reviewService.getAllReviews()
        else reviewService.getAllReviewsForId(idFilter)

}