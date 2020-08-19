package com.example.myapplication.mvp.presenter

import android.util.Log
import android.view.View
import com.example.myapplication.mvp.`interface`.MovieInterface
import com.example.myapplication.mvp.model.modelclass.MovieDetails
import com.example.myapplication.mvp.model.util.Api
import com.example.myapplication.mvp.model.util.RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter : MovieInterface.MoviePresenter {

    private var api: Api? = null
    private var movieView: MovieInterface.MovieView?=null


    override fun showMovie(){
        api = RestApi.client.create(
            Api::class.java)
        val call = api!!.fetchMovieDetails("tagged");
            call.enqueue(object : Callback<MovieDetails> {
                override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {

                    var movieDetails: MovieDetails =response.body()!!
                    movieView!!.updateViewData(movieDetails)
                    Log.d("response",movieDetails.toString())
                }

                override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

    override fun attachView(view: MovieInterface.MovieView) {
         this.movieView=view
    }




}