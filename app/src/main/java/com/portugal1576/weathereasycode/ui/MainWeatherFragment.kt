package com.portugal1576.weathereasycode.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.portugal1576.weathereasycode.R
import com.portugal1576.weathereasycode.WeatherViewModel
import com.portugal1576.weathereasycode.adapters.CustomRecyclerAdapter
import com.portugal1576.weathereasycode.databinding.ActivityMainBinding
import com.portugal1576.weathereasycode.databinding.FragmentMainWeatherBinding


class MainWeatherFragment : Fragment() {

    private var _binding: FragmentMainWeatherBinding? = null
    private val binding: FragmentMainWeatherBinding get() = _binding!!

    private lateinit var adapter: CustomRecyclerAdapter

    private lateinit var  viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

//private lateinit var binding: ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//    }