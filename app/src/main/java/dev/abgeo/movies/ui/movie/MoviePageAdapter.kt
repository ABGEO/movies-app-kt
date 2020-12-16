package dev.abgeo.movies.ui.movie

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import dev.abgeo.movies.R
import java.util.*

class MoviePageAdapter(
    fragmentManager: FragmentManager,
    var context: Context
) : FragmentStatePagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getCount(): Int = 2

    override fun getItem(i: Int): Fragment = when(i) {
        0 -> MovieInfoFragment()
        else -> MovieCastFragment()
    }

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> context.resources.getString(R.string.info).toUpperCase(Locale.ROOT)
        else -> context.resources.getString(R.string.cast).toUpperCase(Locale.ROOT)
    }

}
