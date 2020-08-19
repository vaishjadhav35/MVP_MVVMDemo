package com.example.myapplication.feature.movies

import com.google.gson.annotations.SerializedName

 class MovieDetails () {
    @SerializedName("Title")
    val title: String=""

    @SerializedName("Year")
    val year: String=""

    @SerializedName("Rated")
    val rated: String=""

    @SerializedName("Runtime")
    val runtime: String=""

    @SerializedName("Genre")
    val genre=ArrayList<String>()


 }

