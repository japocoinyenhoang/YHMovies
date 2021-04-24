package com.yenhoang.yhmovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yenhoang.yhmovies.databinding.ViewMovieItemBinding

interface MovieClickedListener {
    fun onMovieClicked(movie :Movie)   // Labda =>  (Movie) -> Unit y sustituirlo tanto aqui como en la minaActivity con {}
}
// teien que extender de una clase especifica que se llama RecicletView.Adapter y a su vez necesita un viewHolder ya que nos pide el tipo en <>
// despues de crear la clase Movie le decimos que va a recibir  "(private val movies: List<Movie>)"
// tb hay que crear un nuevo layout que represente cada elemento de la lista  yque va a inflar la vista el moviesAdapter
class MoviesAdapter(private val movies: List<Movie>,
                    private val MovieClickedListener: MovieClickedListener): RecyclerView.Adapter<MoviesAdapter.ViewHolder> () {

    // x otro lado el ViewHolder recibe una vista "(view: View)"
    //el ViewHolder es el componente dentro del adapter que va a contener la vista
    //class ViewHolder( view: View) : RecyclerView.ViewHolder(view)
    class ViewHolder( private val binding: ViewMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie){
            binding.movieTitle.text = movie.title
            Glide.with(binding.root.context)
                    .load(movie.cover)
                    .into(binding.cover)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //este crea una nueva vista cuadno el reciclerView se lo pida
        // val view = LayoutInflater.from(parent.context).inflate(R.layout.view_movie_item, parent, false)
        //return ViewHolder(view)


        //con viewBinding
        val binding = ViewMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // este va a actualizar una vista cuando el adapter se lo pida
        val movie =(movies[position])
        holder.bind(movie)
        holder.itemView.setOnClickListener{ MovieClickedListener.onMovieClicked(movie)}

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
        // en funcion de la posicion que viewType necesitamos
    }

    override fun getItemCount(): Int {
        // este va a devolver el numero de elementos del adapter
        return movies.size
    }
}


// Para traernos la informacion, previamente tenemos que crearnos una clase, en nuestro caso, la clase Movie