package com.example.myapplication.mvp.model.util

import com.example.myapplication.mvp.`interface`.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestApi {
    private var mRetrofit: Retrofit? = null

    val client: Retrofit
        get() {
            if (mRetrofit == null) {
                mRetrofit = Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return mRetrofit!!

        }
}