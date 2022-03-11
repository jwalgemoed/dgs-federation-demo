package nl.sourcelabs.graphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GraphqlAlbumAppApplication

fun main(args: Array<String>) {
	runApplication<GraphqlAlbumAppApplication>(*args)
}
