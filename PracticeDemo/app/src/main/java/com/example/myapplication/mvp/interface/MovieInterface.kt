package com.example.myapplication.mvp.`interface`

import android.view.View
import com.example.myapplication.mvp.model.modelclass.MovieDetails

class  MovieInterface {

    interface MovieView {
        fun updateViewData(movieDetails: MovieDetails)
    }
    interface MoviePresenter {
        fun showMovie()
        fun attachView(view: MovieInterface.MovieView)
    }
}