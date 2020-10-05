package com.example.kulinerapp.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private fun interceptor() : Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    //client bertugas sebagai alat penghubung ke server
    //di sini tempat kita memasukkan Interceptor
    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor())
        .build()


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dev.farizdotid.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}
