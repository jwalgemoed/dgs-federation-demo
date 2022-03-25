package nl.sourcelabs.reviews.model

import com.fasterxml.jackson.annotation.JsonProperty

public data class RawReview(
    @JsonProperty("imDbId") val imDbId: String?,
    @JsonProperty("title") val title: String?,
    @JsonProperty("fullTitle") val fullTitle: String?,
    @JsonProperty("type") val type: String?,
    @JsonProperty("year") val year: String?,
    @JsonProperty("errorMessage") val errorMessage: String?,
    @JsonProperty("items") val items: Array<Item>?
) {
    companion object
}

public data class Item(
    @JsonProperty("username") val username: String?,
    @JsonProperty("userUrl") val userUrl: String?,
    @JsonProperty("reviewLink") val reviewLink: String?,
    @JsonProperty("warningSpoilers") val warningSpoilers: Boolean = false,
    @JsonProperty("date") val date: String?,
    @JsonProperty("rate") val rate: String?,
    @JsonProperty("helpful") val helpful: String?,
    @JsonProperty("title") val title: String?,
    @JsonProperty("content") val content: String?
) {
    public companion object
}