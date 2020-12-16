package dev.abgeo.movies.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.navGraphViewModels
import com.bumptech.glide.Glide
import dev.abgeo.movies.R
import dev.abgeo.movies.ui.movies.MovieViewModel

class MovieInfoFragment : Fragment() {

    private val movieViewModel: MovieViewModel by navGraphViewModels(R.id.nav_graph)

    private lateinit var ivMovieBanner: ImageView
    private lateinit var tvOriginalTitle: TextView
    private lateinit var tvReleaseDate: TextView
    private lateinit var tvLanguage: TextView
    private lateinit var tvSeasons: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ivMovieBanner = view.findViewById(R.id.ivMovieBanner)
        tvOriginalTitle = view.findViewById(R.id.tvOriginalTitle)
        tvReleaseDate = view.findViewById(R.id.tvReleaseDate)
        tvLanguage = view.findViewById(R.id.tvLanguage)
        tvSeasons = view.findViewById(R.id.tvSeasons)

        movieViewModel.movieLiveData.observe(viewLifecycleOwner, {
            with(it) {
                context?.let { it1 ->
                    Glide.with(it1)
                            .load(imageUrl)
                            .into(ivMovieBanner)
                }

                tvOriginalTitle.text = title
                tvReleaseDate.text = date
                tvLanguage.text = language
                tvSeasons.text = seasons.toString()
            }
        })
    }

}
