package com.portugal1576.weathereasycode.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface Service {
    fun <T> service(clasz: Class<T>): T

    class Base(url: String): Service {
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        override fun <T> service(clasz: Class<T>): T {
            return retrofit.create(clasz)
        }
    }
}
