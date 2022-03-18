package nl.sourcelabs.graphql.review.datafetcher

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import nl.sourcelabs.graphql.review.service.ReviewService

@DgsComponent
class ReviewEntityFetcher(
    private val reviewService: ReviewService,
) {

    @DgsQuery
    fun reviews() = reviewService.all()
}