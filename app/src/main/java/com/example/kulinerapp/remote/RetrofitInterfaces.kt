package com.example.kulinerapp.remote

import com.example.kulinerapp.remote.POJO.ResponseKuliner
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterfaces {

    @GET("api/purwakarta/kuliner")
    suspend fun topHeadlines(

    ) : Response<ResponseKuliner>
}