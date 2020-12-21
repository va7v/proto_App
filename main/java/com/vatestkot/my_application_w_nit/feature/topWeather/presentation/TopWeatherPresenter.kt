package com.vatestkot.my_application_w_nit.feature.topWeather.presentation

import com.vatestkot.my_application_w_nit.Weather
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy

class TopWeatherPresenter : MvpPresenter<TopWeatherView>() {

    private val weather : List<Weather> = listOf(
        Weather("Челябинск", "-7", "Ясно","Снег"),
        Weather("Миасс", "-8", "Ясно","Снег"),
        Weather("Сочи", "-1", "Ясно","Снег"),
        Weather("Уфа", "-6", "Ясно","Снег")
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setWeather(weather)
    }
}

interface TopWeatherView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setWeather(weather: List<Weather>)

}
