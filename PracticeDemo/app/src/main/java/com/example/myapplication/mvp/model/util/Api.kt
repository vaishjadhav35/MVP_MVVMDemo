package com.example.myapplication.mvp.model.util

import com.example.myapplication.mvp.`interface`.Constant
import com.example.myapplication.mvp.model.modelclass.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(Constant.MOVIE)
    fun fetchMovieDetails(@Query("tagged") tags: String): Call<Any>
}

