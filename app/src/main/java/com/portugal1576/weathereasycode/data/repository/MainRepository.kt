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
interface  CityRepository{
    suspend fun getCity(): String
    class Base: CityRepository{
        override suspend fun getCity(): String {
            return "London"

        }
        val cities = arrayListOf<String>().apply {
            add("London")
            add("Lisbon")
            add("Kiev")
            add("Rome")
            add("Vienna")
            add("Porto")
            add("Berlin")
            add("Minsk")
            add("Paris")
            add("Bern")
            add("Prague")
        }

    }
}



