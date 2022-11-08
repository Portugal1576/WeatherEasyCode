package com.portugal1576.weathereasycode.ui

import androidx.lifecycle.*
import com.portugal1576.weathereasycode.data.model.WeatherCloud
import com.portugal1576.weathereasycode.data.repository.CityRepository
import com.portugal1576.weathereasycode.data.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherRepository: WeatherRepository,
    private val communication: Communication
) : ViewModel(), Communication {
    private val cityRepository = CityRepository.Base()

 
    val weatherResult = MutableLiveData<ArrayList<WeatherCloud>>()
    override fun map(text: String) {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = arrayListOf<WeatherCloud>()
                for (city in cityRepository.cities) {
                    result.add(weatherRepository.weather(city))
                }
                weatherResult.postValue(result)

            } catch (e: Exception) {
                communication.map(e.stackTraceToString())
            }

        }

    }

}

interface Communication {

    //    fun observe(owner: LifecycleOwner, observer: Observer<String>)
    fun map(text: String)

    class Base(private val liveData: MutableLiveData<String>) : Communication {
//        override fun observe(owner: LifecycleOwner, observer: Observer<String>) {
//            liveData.observe(owner, observer)
//        }

        override fun map(text: String) {
            liveData.postValue(text)
        }
    }
}






