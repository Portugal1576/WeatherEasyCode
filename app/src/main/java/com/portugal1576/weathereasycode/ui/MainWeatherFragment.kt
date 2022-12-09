package com.portugal1576.weathereasycode.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.portugal1576.weathereasycode.R
import com.portugal1576.weathereasycode.adapters.WeatherAdapter
import com.portugal1576.weathereasycode.data.api.Service
import com.portugal1576.weathereasycode.data.api.WeatherService
import com.portugal1576.weathereasycode.data.model.WeatherCloud
import com.portugal1576.weathereasycode.data.repository.WeatherRepository
import com.portugal1576.weathereasycode.databinding.FragmentMainWeatherBinding
import com.portugal1576.weathereasycode.utils.APP


class MainWeatherFragment : Fragment() {

    private lateinit var binding: FragmentMainWeatherBinding
    private var adapter: WeatherAdapter = WeatherAdapter()

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
        binding = FragmentMainWeatherBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val rv = view.findViewById<RecyclerView>(R.id.rv_list_city)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout)

        super.onViewCreated(view, savedInstanceState)

        viewModel.weatherResult.observe(viewLifecycleOwner, Observer {
            val weather = it

            if (weather != null) {
                progressBar.visibility = View.GONE
                contentLayout.visibility = View.VISIBLE
                rv.adapter = adapter
                adapter.setList(it)
            }

        })

        viewModel.map("")

    }

    companion object {

        fun clickCity(city: WeatherCloud) {
            val bundle = Bundle()
            bundle.putSerializable("city", city)
            APP.navController.navigate(
                R.id.action_mainWeatherFragment_to_detailWeatherFragment,
                bundle)
        }
    }
}
