package com.portugal1576.weathereasycode

import androidx.lifecycle.ViewModel
import com.portugal1576.weathereasycode.model.CitiesService

class WeatherViewModel: ViewModel() {

    val cities = CitiesService().loadCities()
}