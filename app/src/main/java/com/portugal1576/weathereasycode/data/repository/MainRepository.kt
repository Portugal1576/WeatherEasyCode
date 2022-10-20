package com.portugal1576.weathereasycode.data.repository

import android.util.Log
import com.portugal1576.weathereasycode.data.api.ApiAdapter
import com.portugal1576.weathereasycode.data.model.DataWeather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainRepository() {

    fun loadCities(): List<String> {
        return listOf("Lisbon","Kiyiv","Madrid","Paris","Berlin","Copenhagen","Rome","London",
            "Dublin","Prague","Vienna")
    }

    fun getWeather() =  CoroutineScope(Dispatchers.Main).launch {
        try {
            val response = ApiAdapter.apiClient.getWeather()
            if (response.isSuccessful && response.body() != null) {

                val data = response.body()!!
                Log.d("TAG", data.toString())

            } else {
                Log.d("TAG", "Error Occurred: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.d("TAG", "Error Occurred: ${e.message}")
        }
    }
}