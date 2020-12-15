package dev.abgeo.movies.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.abgeo.movies.model.Movie
import dev.abgeo.movies.service.MovieService
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieViewModel : ViewModel() {

    private val _moviesLiveData = MutableLiveData<List<Movie>>()
    val personLiveData: LiveData<List<Movie>>
        get() = _moviesLiveData

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/nikoloz14/movies-db/")
        .client(
            OkHttpClient.Builder()
                .build()
        )
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()

    private val movieService = retrofit.create(MovieService::class.java)

    fun getMovies() {
        movieService.getMovies().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _moviesLiveData.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {}
        })
    }

}
