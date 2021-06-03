package com.example.myapplication.mvp.model.modelclass

import com.google.gson.annotations.SerializedName


data class MovieDetails(

    @SerializedName("Title")
    val title: String,

    @SerializedName("Year")
    val year: String,

    @SerializedName("Rated")
    val rated: String,

    @SerializedName("Runtime")
    val runtime: String,

    @SerializedName("Genre")
    val genre: ArrayList<String>


)

