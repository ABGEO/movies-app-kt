package dev.abgeo.movies.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import dev.abgeo.movies.R
import dev.abgeo.movies.model.Movie

class MoviesFragment : Fragment(), MovieRecyclerViewAdapter.CellClickListener {

    private val movieViewModel: MovieViewModel by navGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        val list = view.findViewById<RecyclerView>(R.id.rvMovies)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)

        movieViewModel.moviesLiveData.observe(viewLifecycleOwner, {
            with(list) {
                layoutManager = LinearLayoutManager(context)
                adapter = MovieRecyclerViewAdapter(it, context, this@MoviesFragment)
            }
        })

        movieViewModel.errorLiveData.observe(viewLifecycleOwner, {
            Toast.makeText(context, it, Toast.LENGTH_SHORT)
                .show()
        })

        movieViewModel.loaderLiveData.observe(viewLifecycleOwner, {
            progressBar.visibility = if (it) VISIBLE else GONE
        })

        movieViewModel.getMovies()

        return view
    }

    override fun onCellClickListener(movie: Movie) {
        movieViewModel.postMovie(movie)

        findNavController().navigate(R.id.action_moviesFragment_to_movieFragment)
    }

}
