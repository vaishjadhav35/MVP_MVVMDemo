package com.example.myapplication.mvp.presenter

import com.example.myapplication.mvp.`interface`.MovieInterface
import com.example.myapplication.mvp.`interface`.NetworkApi
import com.example.myapplication.mvp.model.modelclass.MovieDetails
import com.example.myapplication.mvp.model.util.Api
import com.example.myapplication.mvp.model.util.RestApi


class MoviePresenter(): MovieInterface.MoviePresenter,NetworkApi(), MovieInterface.GetRetrofitResponse {

    private var api: Api? = null
    private var movieView: MovieInterface.MovieView?=null


    override fun showMovie(){
        api = RestApi.client.create(Api::class.java)
       this.networkCall(this,api!!.fetchMovieDetails("tagged"),MovieDetails::class.java)
    }

    override fun response(any: Any) {
        movieView!!.updateViewData(any as MovieDetails)
    }

    override fun failure(any: Any) {

    }
    override fun attachView(view: MovieInterface.MovieView) {
        this.movieView=view
    }

  /*  override fun responseApi(response: Any) {
        TODO("Not yet implemented")
    }
*/
}