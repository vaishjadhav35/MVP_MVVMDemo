package com.example.myapplication.mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.mvp.`interface`.MovieInterface
import com.example.myapplication.mvp.model.adapter.MovieGenreListAdapter
import com.example.myapplication.mvp.model.modelclass.MovieDetails
import com.example.myapplication.mvp.presenter.MoviePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, MovieFragment()).commit()

    }
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

}