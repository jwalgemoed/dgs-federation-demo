package nl.sourcelabs.critics.datafetcher

import com.netflix.dgs.codgen.generated.types.Critic
import com.netflix.dgs.codgen.generated.types.Movie
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.DgsEntityFetcher
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import nl.sourcelabs.critics.service.CriticService

@DgsComponent
class CriticDataFetcher(private val criticService: CriticService) {

    @DgsEntityFetcher(name= "Movie")
    fun movie(values: Map<String?, Any?>): Movie? {
        return Movie(values["id"] as String?, null)
    }

    @DgsData(parentType = "Movie", field = "critics")
    fun reviewsFetcher(dataFetchingEnvironment: DgsDataFetchingEnvironment): MutableList<Critic?>? {
        val movie: Movie = dataFetchingEnvironment.getSource()
        return criticService.getAllCriticsById(movie.id!!).toMutableList()
    }
    @DgsQuery
    fun critics(@InputArgument idFilter : String?): List<Critic> =
        if(idFilter.isNullOrBlank()) criticService.getAllCritics()
        else criticService.getAllCriticsById(idFilter)

}