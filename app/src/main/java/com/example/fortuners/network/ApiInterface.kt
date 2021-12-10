package com.example.fortuners.network

import com.example.fortuners.models.MyDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("pois")
    fun getData(): Call<List<MyDataItem>>
}