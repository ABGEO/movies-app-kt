package dev.abgeo.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.abgeo.movies.ui.movies.MoviesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
