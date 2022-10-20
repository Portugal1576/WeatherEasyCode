package com.portugal1576.weathereasycode.data.api

import com.portugal1576.weathereasycode.data.model.DataWeather
import com.portugal1576.weathereasycode.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("/v1/current.json?key=$API_KEY&q=Kiyev&aqi=no")
    suspend fun getWeather(): Response<DataWeather>
}