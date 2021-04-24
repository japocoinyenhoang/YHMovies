package com.yenhoang.yhmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.yenhoang.yhmovies.databinding.ActivityMainBinding
import com.yenhoang.yhmovies.model.MovieDbClient
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        /*//forma clasica
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // cuando llamamos a setContentView lo que se produce es un proceso de inflado (convertir nuestro xml en clases java o kotlin para poder usarlas desde aqui)

        // y con findViewById accedemos a ellas
        val message = findViewById<TextView>(R.id.message)
        message.text = "Hello Androoid"*/

        //con viewBinding
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)  //generamos un objeto que puede acceder a todas las vistas
        setContentView(binding.root)  // el root es la raiz del componente que hemos inflado.

        //binding.message.text = "Hello Androoid"

        /* // con el apply
         super.onCreate(savedInstanceState)
         ActivityMainBinding.inflate(layoutInflater).apply {
             setContentView(root)
             message.text = "Hello Android"*/

        //el adapter es el qie identifica como se va a pintar dentro del reciclerView
        //tenemos que crear una clase que en este caso llamaremos MoviesAdapter


        val moviesAdapter = MoviesAdapter(emptyList()) { movie ->
            Toast.makeText(this@MainActivity, movie.title, Toast.LENGTH_LONG).show()
        }
        binding.recycler.adapter = moviesAdapter
        thread {
            //val apiKey = this.resources.getString(R.string.api_key) pero mejoor:
            val apiKey = getString(R.string.api_key)
            val popularMovies = MovieDbClient.service.listPopularMovies(apiKey)
            val body = popularMovies.execute().body()

            runOnUiThread {
                if (body != null)
                    //Log.d("MainActivity", "Movie count: ${body.results.size}")
                        moviesAdapter.movies = body.results
                    moviesAdapter.notifyDataSetChanged()
            }
        }

    }
}