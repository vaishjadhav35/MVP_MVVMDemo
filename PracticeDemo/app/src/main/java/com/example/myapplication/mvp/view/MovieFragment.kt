package com.example.myapplication.mvp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.mvp.model.adapter.MovieGenreListAdapter
import com.example.myapplication.mvvm.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment()/*, MovieInterface.MovieView*/ {
    private var genreListAdapter: MovieGenreListAdapter? = null
   // private var presenter: MoviePresenter? = null
    private lateinit var viewModel: MovieViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // getMovieDetails()
        viewModel=ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel.getMovieDataObserver().observe(this, Observer {
            movieTitle.text = "Title: ${it.title}"
            movieYear.text = "Year: ${it.year}"
            movieRating.text = "Rated: ${it.rated}"
            movieRuntime.text = "Runtime: ${it.runtime}"

            genreListAdapter =
                MovieGenreListAdapter(it)
            listRecyclerView!!.adapter = genreListAdapter
            genreListAdapter!!.notifyDataSetChanged()
        })
        viewModel.getApiCall()
        listRecyclerView!!.layoutManager = LinearLayoutManager(activity)

    }



  /*  private fun getMovieDetails() {
        presenter = MoviePresenter()
        presenter!!.attachView(this)
        presenter!!.showMovie()

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
    }*/
    }


