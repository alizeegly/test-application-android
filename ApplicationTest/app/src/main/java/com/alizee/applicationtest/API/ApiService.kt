package com.alizee.applicationtest.API

import com.alizee.applicationtest.models.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("app_kotlin.json")
    suspend fun getUsers(): Response<MutableList<User>>
}