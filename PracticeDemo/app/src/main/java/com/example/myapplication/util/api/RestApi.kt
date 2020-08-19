package com.example.myapplication.util.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestApi {
    private val BASE_URL = "https://5f3aa1662300b100169a8f87.mockapi.io"
    private var mRetrofit: Retrofit? = null

    val client: Retrofit
        get() {
            if (mRetrofit == null) {
                mRetrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return this.mRetrofit!!

        }
}