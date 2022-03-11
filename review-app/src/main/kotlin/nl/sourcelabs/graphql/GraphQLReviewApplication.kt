package nl.sourcelabs.graphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GraphQLReviewApplication

fun main(args: Array<String>) {
	runApplication<GraphQLReviewApplication>(*args)
}
