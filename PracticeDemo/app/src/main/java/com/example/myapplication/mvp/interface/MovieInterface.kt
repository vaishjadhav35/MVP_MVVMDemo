package com.example.myapplication.mvp.`interface`

interface MovieInterface {

    interface movieModel {
        fun getMovie()
    }

    interface movieView {
        fun updateViewData()

    }

    interface moviePresenter {
        fun showMovie()

    }
}