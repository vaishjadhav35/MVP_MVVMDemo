package com.example.myapplication.mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.mvp.`interface`.MovieInterface
import com.example.myapplication.mvp.model.adapter.MovieGenreListAdapter
import com.example.myapplication.mvp.model.modelclass.MovieDetails
import com.example.myapplication.mvp.presenter.MoviePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieInterface.MovieView {
    private var genreListAdapter: MovieGenreListAdapter? = null
    private var presenter: MoviePresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

        getMovieDetails()
        listRecyclerView!!.layoutManager = LinearLayoutManager(this)

    }

    private fun getMovieDetails() {
        presenter = MoviePresenter()
        presenter!!.attachView(this)
        presenter!!.showMovie()

    }
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun updateViewData(movieDetails: MovieDetails) {
        movieTitle.text = "Title: ${movieDetails.title}"
        movieYear.text = "Year: ${movieDetails.year}"
        movieRating.text = "Rated: ${movieDetails.rated}"
        movieRuntime.text = "Runtime: ${movieDetails.runtime}"

        genreListAdapter =
            MovieGenreListAdapter(
                movieDetails
            )
        listRecyclerView!!.adapter = genreListAdapter
        genreListAdapter!!.notifyDataSetChanged()
    }
}