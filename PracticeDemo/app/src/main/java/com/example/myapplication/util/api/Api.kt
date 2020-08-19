package com.example.myapplication.util.api

import com.example.myapplication.feature.movies.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/v1/movies/movie_name")
    fun fetchMovieDetails(@Query("tagged") tags: String): Call<MovieDetails>
}

