package com.portugal1576.weathereasycode.data.api

import com.portugal1576.weathereasycode.data.model.DataWeather
import com.portugal1576.weathereasycode.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//http://api.weatherapi.com
// /v1/current.json?key=3dfc034a5dac49d9977161358220507&q=Kiev&aqi=no

interface ApiClient {
    @GET("v1/current.json")
    suspend fun getWeather(@Query("key") key: String,
                           @Query("q") q: String = "Kiev",
                           @Query("aqi") aqi: String): Response<DataWeather>
}


