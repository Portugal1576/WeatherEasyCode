package com.portugal1576.weathereasycode.data.repository

import com.portugal1576.weathereasycode.data.api.WeatherService
import com.portugal1576.weathereasycode.data.model.WeatherCloud

interface WeatherRepository {
    suspend fun weather(city: String): WeatherCloud

    class Base(private val service: WeatherService) : WeatherRepository {

        override suspend fun weather(city: String): WeatherCloud {
            return  service.getWeather(API_KEY, city, "no")
        }

        companion object {
            private const val API_KEY = "3dfc034a5dac49d9977161358220507"
        }
    }
}


//class MainRepository() {


//    fun getWeather(city: String) =  CoroutineScope(Dispatchers.Main).launch {
//        try {
//            val response = ApiAdapter.apiClient.getWeather(API_KEY, city, "no")
//            if (response.isSuccessful && response.body() != null) {
//
//                val data = response.body()!!
//                Log.d("TAG", data.toString())
//
//            } else {
//                Log.d("TAG", "Error Occurred: ${response.message()}")
//            }
//        } catch (e: Exception) {
//            Log.d("TAG", "Error Occurred: ${e.message}")
//        }
//    }


