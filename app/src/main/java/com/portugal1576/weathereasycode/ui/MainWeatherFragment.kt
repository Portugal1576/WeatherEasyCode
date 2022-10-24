package com.portugal1576.weathereasycode.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.portugal1576.weathereasycode.R
import com.portugal1576.weathereasycode.adapters.CustomRecyclerAdapter
import com.portugal1576.weathereasycode.data.api.Service
import com.portugal1576.weathereasycode.data.api.WeatherService
import com.portugal1576.weathereasycode.data.repository.WeatherRepository


class MainWeatherFragment : Fragment() {


    private lateinit var adapter: CustomRecyclerAdapter

    private val viewModel =
        WeatherViewModel(
            WeatherRepository.Base(
                Service.Base("http://api.weatherapi.com").service(WeatherService::class.java)
            ),
            Communication.Base(MutableLiveData<String>())
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_main_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val input = view.findViewById<EditText>(R.id.input)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.map(input.text.toString())
        }
        val text = view.findViewById<TextView>(R.id.text)
        viewModel.observe(this) {
            text.text = it
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
