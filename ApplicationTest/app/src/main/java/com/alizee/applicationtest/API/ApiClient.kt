package com.alizee.applicationtest.API

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object
    {
        val BASE_URL: String = "https://gist.githubusercontent.com/NizarETH/4bdd464f3e5d026057fbcac960b85a5c/raw/40485eceefc6f938ec1558d4512d2f301f42f306/"
    }

    private val gson : Gson = GsonBuilder().setLenient().create()

    private val httpClient : OkHttpClient =  OkHttpClient.Builder().build()

    private val retrofit : Retrofit =   Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    val apiService :  ApiService = retrofit.create(ApiService::class.java)
}