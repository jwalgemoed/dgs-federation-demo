package nl.sourcelabs.actors.datafetchers

import com.netflix.dgs.codgen.generated.types.Actor
import com.netflix.dgs.codgen.generated.types.Movie
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.DgsEntityFetcher
import com.netflix.graphql.dgs.DgsQuery
import nl.sourcelabs.actors.service.ActorService

@DgsComponent
class ActorDataFetcher(private val actorService: ActorService) {

    @DgsEntityFetcher(name= "Movie")
    fun movie(values: Map<String?, Any?>): Movie? {
        return Movie(values["id"] as String?, null)
    }

    @DgsData(parentType = "Movie", field = "actor")
    fun actorFetcher(dataFetchingEnvironment: DgsDataFetchingEnvironment): Actor? {
        val movie: Movie = dataFetchingEnvironment.getSource()
        return actorService.getActorWithMovieId(movie.id!!)
    }


    @DgsQuery
    fun actors():List<Actor> =
        actorService.getActors()



}