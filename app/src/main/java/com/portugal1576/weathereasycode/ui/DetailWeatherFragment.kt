package com.portugal1576.weathereasycode.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.portugal1576.weathereasycode.R
import com.portugal1576.weathereasycode.data.model.WeatherCloud
import com.portugal1576.weathereasycode.databinding.FragmentDetailWeatherBinding
import com.portugal1576.weathereasycode.utils.APP
import kotlinx.android.synthetic.main.fragment_detail_weather.*

class DetailWeatherFragment : Fragment() {

    private lateinit var binding: FragmentDetailWeatherBinding
    private lateinit var currentCity: WeatherCloud


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailWeatherBinding.inflate(layoutInflater)

        currentCity = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("city", WeatherCloud::class.java)!!

        } else {
            arguments?.getSerializable("city") as WeatherCloud
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init(){
        val pressure = (currentCity.current.pressure_mb).toInt()
        val url = "http:${currentCity.current.condition.icon}"
        binding.tvLocation.text = currentCity.location.name
        binding.tvTemp.text = currentCity.current.temp_c.toString()+" ℃"
        binding.tvWind.text = currentCity.current.wind_mph.toString()+" m/s"
        binding.tvPressure.text = (pressure*0.75).toString()+" mm.Hg"
        binding.tvHumidity.text = currentCity.current.humidity.toString()+" %"

        //Image
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.ic_baseline_mood_24)
            .error(R.drawable.ic_baseline_mood_24)
            .into(binding.imageIcon)

        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_detailWeatherFragment_to_mainWeatherFragment)
        }
    }
}