package com.portugal1576.weathereasycode.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portugal1576.weathereasycode.R
import com.portugal1576.weathereasycode.data.model.WeatherCloud
import com.portugal1576.weathereasycode.ui.MainWeatherFragment
import kotlinx.android.synthetic.main.item_city_weather.view.*

@Suppress("DEPRECATION")
class WeatherAdapter: RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private var listCityWeather = emptyList<WeatherCloud>()

    class WeatherViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city_weather, parent, false)
        return WeatherViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.itemView.tv_city.text = listCityWeather[position].location.name
        holder.itemView.tv_temperature.text = listCityWeather[position].current.temp_c.toString()+" ℃"
    }

    override fun getItemCount(): Int {
        return  listCityWeather.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<WeatherCloud>){
        listCityWeather = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: WeatherViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            MainWeatherFragment.clickCity(listCityWeather[holder.absoluteAdapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: WeatherViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}