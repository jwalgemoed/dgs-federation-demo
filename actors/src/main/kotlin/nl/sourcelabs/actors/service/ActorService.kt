package nl.sourcelabs.actors.service

import com.netflix.dgs.codgen.generated.types.Actor
import org.springframework.stereotype.Service

@Service
class ActorService {
    private val actors = listOf(Actor(actorId = "1", name = "Brad Pitt", hasWonAnOscar = true, id = "tt0137523"), Actor("2","Fatih", false, ""))

    fun getActors() = actors
    fun getActorWithMovieId(movieId: String) = actors.firstOrNull{it.id == movieId}
}