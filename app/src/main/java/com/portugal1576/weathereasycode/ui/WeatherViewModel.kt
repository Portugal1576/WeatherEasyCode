package com.portugal1576.weathereasycode.ui

import androidx.lifecycle.ViewModel
import com.portugal1576.weathereasycode.data.repository.MainRepository

class WeatherViewModel(): ViewModel() {
    private val repository = MainRepository()
    fun loadWeather(){
         repository.getWeather()
    }
}