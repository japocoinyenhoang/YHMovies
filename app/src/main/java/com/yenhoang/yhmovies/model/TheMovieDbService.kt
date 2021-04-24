package com.yenhoang.yhmovies.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDBService {

    //el endpoint con el que quieremos comunicarnos
    @GET("movie/popular")
    fun listPopularMovies (@Query("api_key")apiKey: String): Call<MovieDbResult>
}