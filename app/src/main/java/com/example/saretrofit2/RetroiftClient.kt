package com.example.saretrofit2

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiInterface{

    @GET ("contacts")
    fun getUsers() : Call<UsersData>
}


class RetroiftClient {
companion object{
    var myretrofit = Retrofit.Builder()
        .baseUrl("https://api.androidhive.info/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiInterface::class.java)
}


}