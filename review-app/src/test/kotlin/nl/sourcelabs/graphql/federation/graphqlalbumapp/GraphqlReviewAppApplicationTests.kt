package nl.sourcelabs.graphql.federation.graphqlalbumapp

import com.jayway.jsonpath.TypeRef
import com.netflix.graphql.dgs.client.MonoGraphQLClient
import nl.sourcelabs.graphql.review.model.Review
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.web.reactive.function.client.WebClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GraphqlReviewAppApplicationTests(
    @LocalServerPort
    private val port: Int,
) {
    @Test
    fun contextLoads() {
        val client = MonoGraphQLClient.createWithWebClient(WebClient.create("http://localhost:$port/graphql"))

        val query = client.reactiveExecuteQuery("{ reviews { id } }").map {
                it.extractValueAsObject("reviews", object : TypeRef<List<Review>>() {})
        }

        val result = query.block()!!

        assertEquals(3, result.size)
    }
}
