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
import dev.abgeo.movies.R

class MoviesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        val list = view.findViewById<RecyclerView>(R.id.rvMovies)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        val viewModel = MovieViewModel()

        viewModel.personLiveData.observe(this, {
            with(list) {
                layoutManager = LinearLayoutManager(context)
                adapter = MovieRecyclerViewAdapter(it, context)
            }
        })

        viewModel.errorLiveData.observe(this, {
            Toast.makeText(context, it, Toast.LENGTH_SHORT)
                .show()
        })

        viewModel.loaderLiveData.observe(this, {
            progressBar.visibility = if (it) VISIBLE else GONE
        })

        viewModel.getMovies()

        return view
    }

}
