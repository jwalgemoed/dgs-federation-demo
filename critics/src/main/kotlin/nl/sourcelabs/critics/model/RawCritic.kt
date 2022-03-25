package nl.sourcelabs.critics.model

import com.fasterxml.jackson.annotation.JsonProperty

public data class RawCritic(
    @JsonProperty("status") val status: String?,
    @JsonProperty("copyright") val copyright: String?,
    @JsonProperty("has_more") val hasMore: Boolean = false,
    @JsonProperty("num_results") val numResults: Int,
    @JsonProperty("results") val results: Array<Result>?
) {
    companion object
}

public data class Result(
    @JsonProperty("display_title") val movieTitle: String?,
    @JsonProperty("mpaa_rating") val rating: String?,
    @JsonProperty("critics_pick") val criticsPick: Int?,
    @JsonProperty("byline") val author: String?,
    @JsonProperty("headline") val title: String?,
    @JsonProperty("summary_short") val content: String?,
    @JsonProperty("publication_date") val pubDate: String?,
    @JsonProperty("opening_date") val openDate: String?,
    @JsonProperty("date_updated") val updateDate: String?,
    @JsonProperty("link") val link: Link?,
    @JsonProperty("multimedia") val multimedia: Multimedia?
) {
    public companion object
}

public data class Link(
    @JsonProperty("type") val type: String?,
    @JsonProperty("url") val url: String?,
    @JsonProperty("suggested_link_text") val linkText: String?,
    ) {
    public companion object

}

public data class Multimedia(
    @JsonProperty("type") val type: String?,
    @JsonProperty("src") val src: String?,
    @JsonProperty("height") val height: Int?,
    @JsonProperty("width") val width: Int?
) {
    public companion object

}