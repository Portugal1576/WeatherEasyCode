package com.portugal1576.weathereasycode.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.portugal1576.weathereasycode.R
import com.portugal1576.weathereasycode.adapters.MyAdapter
import com.portugal1576.weathereasycode.data.api.Service
import com.portugal1576.weathereasycode.data.api.WeatherService
import com.portugal1576.weathereasycode.data.repository.CityRepository
import com.portugal1576.weathereasycode.data.repository.WeatherRepository


class MainWeatherFragment : Fragment() {


    private lateinit var adapter: MyAdapter

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

        val rv = view.findViewById<RecyclerView>(R.id.rv_list_city)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout)


        super.onViewCreated(view, savedInstanceState)
        viewModel.weatherResult.observe(viewLifecycleOwner, Observer {
            val weather = it
            if (weather != null) {
                rv.adapter = MyAdapter(weather)
                progressBar.visibility = View.GONE
                contentLayout.visibility = View.VISIBLE
            }

        })
        viewModel.map("")

    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
