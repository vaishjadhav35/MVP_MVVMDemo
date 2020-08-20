package com.example.myapplication.mvp.`interface`

import com.example.myapplication.mvp.model.modelclass.MovieDetails

class  MovieInterface {

    interface MovieView {
        fun updateViewData(movieDetails: MovieDetails)

    }

    interface MoviePresenter {
        fun showMovie()
        fun attachView(view: MovieView)
    }

    interface GetRetrofitResponse{
        fun response(any: Any)
        fun failure(any: Any)
    }
}