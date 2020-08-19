package com.example.myapplication.mvp.model.api.modelclass

import com.google.gson.annotations.SerializedName


data class MovieDetails(

    @SerializedName("Title")
    val title: String? = null,

    @SerializedName("Year")
    val year: String? = null,

    @SerializedName("Rated")
    val rated: String? = null,

    @SerializedName("Runtime")
    val runtime: String? = null,

    @field:SerializedName("Genre")
    val genre: ArrayList<String>
)

