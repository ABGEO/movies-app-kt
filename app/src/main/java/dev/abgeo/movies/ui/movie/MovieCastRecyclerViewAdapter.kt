package dev.abgeo.movies.ui.movie

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import dev.abgeo.movies.R
import dev.abgeo.movies.model.Actor

class MovieCastRecyclerViewAdapter(
    private val values: List<Actor>,
    private val context: Context
) : RecyclerView.Adapter<MovieCastRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_cast_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        Glide.with(context)
            .load(item.imageUrl)
            .into(holder.ivAvatar)

        holder.tvActorName.text = item.fullName
        holder.tvActorRole.text = item.role
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivAvatar: ImageView = view.findViewById(R.id.ivAvatar)
        val tvActorName: TextView = view.findViewById(R.id.tvActorName)
        val tvActorRole: TextView = view.findViewById(R.id.tvActorRole)
    }

}
