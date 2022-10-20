package com.portugal1576.weathereasycode.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portugal1576.weathereasycode.databinding.ItemCityWeatherBinding
import com.portugal1576.weathereasycode.data.model.City

class CustomRecyclerAdapter(private val cities: List<City>) : RecyclerView
.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder( val binding: ItemCityWeatherBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCityWeatherBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val city = cities[position]
        with(holder.binding){
            tvCity.text = city.city
            tvTemperature.text = city.temp.toString()
        }

    }

    override fun getItemCount() = cities.size
}