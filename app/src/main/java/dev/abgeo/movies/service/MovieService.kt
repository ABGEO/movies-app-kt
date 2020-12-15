package dev.abgeo.movies.service

import dev.abgeo.movies.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET("movies")
    fun getMovies(): Call<List<Movie>>

}
