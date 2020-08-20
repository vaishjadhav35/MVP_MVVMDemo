package com.example.myapplication.mvp.`interface`
import android.util.Log
import com.example.myapplication.mvp.model.modelclass.MovieDetails
import com.example.myapplication.mvp.model.util.Api
import com.example.myapplication.mvp.model.util.RestApi
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


open class NetworkApi() {

fun networkCall(
                getRetrofitResponse: MovieInterface.GetRetrofitResponse,

call:Call<Any>,
                resultClass: Class<*>){

    call.enqueue(object : Callback<Any> {
        override fun onResponse(call: Call<Any>, response: Response<Any>) {

            getRetrofitResponse.response(getResultObj(response.body()!!,resultClass))
        }

        override fun onFailure(call: Call<Any>, t: Throwable) {
            getRetrofitResponse.failure(t)

        }

    })
}

    private fun getResultObj(result: Any, resultClass: Class<*>): Any {
        val gson = Gson()
        Log.e("CLASS NAME::", "" + resultClass.canonicalName)
        val str = gson.toJson(result, result.javaClass)
        if (str.startsWith("[") && str.endsWith("]")) {
            val jsonArray = JSONArray(str)
            val resultObj: Any = gson.fromJson(jsonArray.toString(), resultClass)
            return resultObj
        } else {
            val jsonObject = JSONObject(str)
            val resultObj: Any = gson.fromJson(jsonObject.toString(), resultClass)
            return resultObj
        }
    }
}