package nl.sourcelabs.graphql.federation.model

data class Review(
    val id: Long,
    val albumId: Long,
    val text: String,
    val score: Int,
)