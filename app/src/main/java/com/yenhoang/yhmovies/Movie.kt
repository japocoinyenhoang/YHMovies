package com.yenhoang.yhmovies

// lo ponemos como data class y le pasamos lo que quieremos que contenga
data class Movie (val title : String, val cover: String)
// despues nos volvemos al MoviesAdapter y le decimos que es lo que queremos pasarle, es decir, que va a recibir