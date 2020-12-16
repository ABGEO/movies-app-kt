package dev.abgeo.movies.ui.movies

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import dev.abgeo.movies.R

import dev.abgeo.movies.model.Movie

class MovieRecyclerViewAdapter(
    private val values: List<Movie>,
    private val context: Context,
    private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = values[position]

        Glide.with(context)
            .load(item.imageUrl)
            .into(holder.ivBanner)

        holder.ivBanner.setOnClickListener {
            cellClickListener.onCellClickListener(item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivBanner: ImageView = view.findViewById(R.id.ivBanner)
    }

    interface CellClickListener {
        fun onCellClickListener(movie: Movie)
    }

}
