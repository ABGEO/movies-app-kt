package dev.abgeo.movies.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import dev.abgeo.movies.R

class MovieFragment : Fragment() {

    private lateinit var pagerAdapter: MoviePageAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        context?.let {
            pagerAdapter = MoviePageAdapter(childFragmentManager, it)
            viewPager = view.findViewById(R.id.pager)
            tabLayout = view.findViewById(R.id.tab_layout)

            viewPager.adapter = pagerAdapter
            tabLayout.setupWithViewPager(viewPager)
        }
    }

}
