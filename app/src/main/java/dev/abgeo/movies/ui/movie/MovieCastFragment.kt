package dev.abgeo.movies.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.abgeo.movies.R
import dev.abgeo.movies.ui.movies.MovieViewModel

class MovieCastFragment : Fragment() {

    private val movieViewModel: MovieViewModel by navGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_cast, container, false)

        movieViewModel.movieLiveData.observe(viewLifecycleOwner, {
            if (view is RecyclerView) {
                with(view) {
                    layoutManager = LinearLayoutManager(context)
                    adapter = MovieCastRecyclerViewAdapter(it.cast, context)
                }
            }
        })

        return view
    }

}
