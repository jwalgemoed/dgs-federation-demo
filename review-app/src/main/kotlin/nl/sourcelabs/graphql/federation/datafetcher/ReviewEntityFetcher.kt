package nl.sourcelabs.graphql.federation.datafetcher

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import nl.sourcelabs.graphql.federation.model.Review

@DgsComponent
class ReviewEntityFetcher {

    @DgsQuery
    fun reviews() = listOf(
        Review(id = 1, albumId = 1, score = 1, text = "It's really bad."),
        Review(id = 2, albumId = 2, score = 3, text = "I've heard better.")
    )
}