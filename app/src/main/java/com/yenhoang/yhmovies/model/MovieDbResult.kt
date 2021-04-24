package com.yenhoang.yhmovies.model

//import com.google.gson.annotations.SerializedName

data class MovieDbResult(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
  //  @SerializedName('total_result')  // con esto podriamos cambiar el nombre por defecto que viene del json para esta propiedad
    val total_results: Int
)