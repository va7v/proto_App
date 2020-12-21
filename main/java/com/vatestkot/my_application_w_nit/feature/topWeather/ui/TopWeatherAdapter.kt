package com.vatestkot.my_application_w_nit.feature.topWeather.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vatestkot.my_application_w_nit.R
import com.vatestkot.my_application_w_nit.Weather
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.top_weather_item.*

class TopWeatherAdapter : RecyclerView.Adapter<TopWeatherAdapter.ViewHolder>() {

    private var weather: MutableList<Weather> = mutableListOf()

    fun setData(weather: List<Weather>) {
        this.weather.clear()
        this.weather.addAll(weather)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.top_weather_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = weather[position]
        /* holder.containerView.setOnClickListener {
            onMovieClick(item)
        } */
        holder.topWeatherName.text  = item.city
        holder.topWeatherYear.text = item.temp
    }

    override fun getItemCount(): Int = weather.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer

}