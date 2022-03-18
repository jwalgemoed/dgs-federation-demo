package nl.sourcelabs.graphql.review.model

data class Review(
    val id: Long?,
    val albumId: Long?,
    val text: String?,
    val score: Int?,
)