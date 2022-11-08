package com.portugal1576.weathereasycode.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.portugal1576.weathereasycode.R
import com.portugal1576.weathereasycode.data.model.City
import com.portugal1576.weathereasycode.data.model.WeatherCloud

//class CustomRecyclerAdapter(private val cities: List<City>) : RecyclerView
//.Adapter<CustomRecyclerAdapter.MyViewHolder>() {
//
//    class MyViewHolder( val binding: ItemCityWeatherBinding) : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = ItemCityWeatherBinding.inflate(inflater, parent, false)
//        return MyViewHolder(binding)
//
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val city = cities[position]
//        with(holder.binding){
//            tvCity.text = city.city
//            tvTemperature.text = city.temp.toString()
//        }
//
//    }
//
//    override fun getItemCount() = cities.size
//}


class MyAdapter(private val city: ArrayList<WeatherCloud>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_city_weather,
            parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = city[position]
//        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tv_city.text = currentItem.location.name
        holder.tv_temperature.text = currentItem.current.temp_c.toString()
    }

    override fun getItemCount(): Int {
        return  city.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val titleImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tv_city: TextView = itemView.findViewById(R.id.tv_city)
        val tv_temperature: TextView = itemView.findViewById(R.id.tv_temperature)
    }

}