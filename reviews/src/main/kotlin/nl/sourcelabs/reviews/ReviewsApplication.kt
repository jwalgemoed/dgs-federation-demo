package nl.sourcelabs.reviews

import graphql.scalars.ExtendedScalars
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReviewsApplication

fun main(args: Array<String>) {
    runApplication<ReviewsApplication>(*args)
    graphql.schema.idl.RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.Date)
}
