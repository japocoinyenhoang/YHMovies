package com.yenhoang.yhmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yenhoang.yhmovies.databinding.ActivityMainBinding

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
        binding.recycler.adapter = MoviesAdapter(
                listOf(
                        Movie("Title 1", "https://loremflickr.com/320/240?lock=1"),
                        Movie("Title 2", "https://loremflickr.com/320/240?lock=2"),
                        Movie("Title 3", "https://loremflickr.com/320/240?lock=3"),
                        Movie("Title 4", "https://loremflickr.com/320/240?lock=4"),
                        Movie("Title 6", "https://loremflickr.com/320/240?lock=6"),
                        Movie("Title 7", "https://loremflickr.com/320/240?lock=7"),
                        Movie("Title 8", "https://loremflickr.com/320/240?lock=8")
                )
        )
    }
}