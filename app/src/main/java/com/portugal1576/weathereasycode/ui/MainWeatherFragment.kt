package com.portugal1576.weathereasycode.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.portugal1576.weathereasycode.adapters.CustomRecyclerAdapter
import com.portugal1576.weathereasycode.databinding.FragmentMainWeatherBinding


class MainWeatherFragment : Fragment() {

    private var _binding: FragmentMainWeatherBinding? = null
    private val binding: FragmentMainWeatherBinding get() = _binding!!

    private lateinit var adapter: CustomRecyclerAdapter

    private val  viewModel = WeatherViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadWeather()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
