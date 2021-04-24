package com.yenhoang.yhmovies.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieDbClient {
    //objeto de tipo retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //este es nuestro service para poder hacer peticiones al endpoint y lo usaremos en el mainActivity
    val service = retrofit.create(TheMovieDBService::class.java)
}