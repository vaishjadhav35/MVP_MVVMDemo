package com.example.myapplication.feature.movies.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.feature.movies.adapter.MovieGenreListAdapter
import com.example.myapplication.feature.movies.MovieDetails
import com.example.myapplication.util.api.Api
import com.example.myapplication.util.api.RestApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var mApi: Api? = null
    private var mAdapter:MovieGenreListAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApi = RestApi.client.create(Api::class.java)

        listRecyclerView!!.layoutManager = LinearLayoutManager(this)

        GetMovieDetails()
    }
    private fun GetMovieDetails() {
        val call = mApi!!.fetchMovieDetails("tagged");
        call.enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {

                var movieDetails: MovieDetails =response.body()!!
                Log.d("response",movieDetails.toString())

                movieTitle.text = "Title: ${movieDetails.title}"
                movieYear.text ="Year: ${movieDetails.year}"
                movieRating.text ="Rated: ${movieDetails.rated}"
                movieRuntime.text ="Runtime: ${movieDetails.runtime}"


                mAdapter = MovieGenreListAdapter(movieDetails)
                listRecyclerView!!.adapter = mAdapter
                mAdapter!!.notifyDataSetChanged()

        }


            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

     companion object {
            private val TAG = MainActivity::class.java.simpleName
        }
}