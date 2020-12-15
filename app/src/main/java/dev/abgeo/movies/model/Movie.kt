package dev.abgeo.movies.model

data class Movie(
        var id: Long,
        var title: String,
        var date: String,
        var language: String,
        var seasons: Int,
        var imageUrl: String,
        var cast: List<Actor>
)
