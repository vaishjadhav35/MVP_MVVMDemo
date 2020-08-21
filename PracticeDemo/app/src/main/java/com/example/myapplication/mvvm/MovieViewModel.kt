package com.example.myapplication.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.mvp.`interface`.NetworkApi
import com.example.myapplication.mvp.model.modelclass.MovieDetails
import com.example.myapplication.mvp.model.util.Api
import com.example.myapplication.mvp.model.util.RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel: ViewModel() {
    var  movieData:MutableLiveData<MovieDetails> = MutableLiveData()
    fun getMovieDataObserver():MutableLiveData<MovieDetails>{
        return movieData
    }

    fun getApiCall(){
       var api = RestApi.client.create(Api::class.java)
       var call=api!!.getMovieDetails("tagged")
        call.enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                movieData.postValue(response.body())
            }

            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                movieData.postValue(null)

            }

        })

    }

    }

