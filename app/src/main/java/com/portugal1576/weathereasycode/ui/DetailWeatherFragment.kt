package com.portugal1576.weathereasycode.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.portugal1576.weathereasycode.R
import com.portugal1576.weathereasycode.databinding.FragmentDetailWeatherBinding
import com.portugal1576.weathereasycode.databinding.FragmentMainWeatherBinding

class DetailWeatherFragment : Fragment() {

    private var _binding: FragmentDetailWeatherBinding? = null
    private val binding: FragmentDetailWeatherBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}