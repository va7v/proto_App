package com.vatestkot.my_application_w_nit.feature.topWeather.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.vatestkot.my_application_w_nit.R
import com.vatestkot.my_application_w_nit.Weather
import com.vatestkot.my_application_w_nit.feature.search.SearchFragment
import com.vatestkot.my_application_w_nit.feature.topWeather.presentation.TopWeatherPresenter
import com.vatestkot.my_application_w_nit.feature.topWeather.presentation.TopWeatherView
import com.vatestkot.my_application_w_nit.ui.FavoritiesFragment
import com.vatestkot.my_application_w_nit.ui.WeatherDetailsFragment
import kotlinx.android.synthetic.main.fragment_top_weather.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class TopWeatherFragment : MvpAppCompatFragment(R.layout.fragment_top_weather), TopWeatherView {

    private var weatherAdapter: TopWeatherAdapter? = null
    private val presenter : TopWeatherPresenter by moxyPresenter {
        TopWeatherPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(rvTopWeather) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = TopWeatherAdapter().also {
                weatherAdapter = it

            }
        }

        //val weather = Weather("Челябинск", "-7", "Ясно","Снег")
        /* btnGoToDetails.setOnClickListener {
            presenter.onDetailClick()
        }
        btnGoToSearch.setOnClickListener {
            requireFragmentManager().beginTransaction()
                    .replace(R.id.container, SearchFragment())
                    .addToBackStack("SearchFragment")
                    .commit()
        }

        btnGoToFavorities.setOnClickListener {
            requireFragmentManager().beginTransaction()
                    .replace(R.id.container, FavoritiesFragment.newInstance(weather))
                    .addToBackStack("FavoritiesFragment")
                    .commit()
        }

         */
    }

    override fun onDestroyView() {
        super.onDestroyView()
        weatherAdapter = null
    }

    override fun setWeather(weather: List<Weather>) {
        weatherAdapter?.setData(weather)
    }

    private fun openWeatherDetail(weather: Weather) {
        requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeatherDetailsFragment.newInstance(weather))
                .addToBackStack("WeatherDetailsFragment")
                .commit()

    }
}

