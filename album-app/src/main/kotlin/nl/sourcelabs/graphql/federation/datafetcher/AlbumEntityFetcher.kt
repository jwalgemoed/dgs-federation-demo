package nl.sourcelabs.graphql.federation.datafetcher

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import nl.sourcelabs.graphql.federation.model.Album

@DgsComponent
class AlbumEntityFetcher {

    @DgsQuery
    fun albums() = listOf(
        Album(1, "Superunknown"),
        Album(2, "I care because you do"),
    )
}