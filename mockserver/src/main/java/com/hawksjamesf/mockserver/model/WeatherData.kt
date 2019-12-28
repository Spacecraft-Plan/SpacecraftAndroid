package com.hawksjamesf.mockserver.model

import com.hawksjamesf.mockserver.model.factor.Clouds
import com.hawksjamesf.mockserver.model.factor.Wind
import com.hawksjamesf.mockserver.model.weather.Coordinate
import com.hawksjamesf.mockserver.model.weather.Main
import com.hawksjamesf.mockserver.model.weather.Weather

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawskjamesf
 * @since: Sep/25/2018  Tue
 */
data class WeatherData(
        var id: Int,
        var name: String,
        var coord: Coordinate,

        var dt: Int,//Time of data calculation, unix, UTC
        var dt_txt:String,


        var weather: List<Weather>,
        var base: String,

        var main: Main,
        var visibility: Int,

        var wind: Wind,
        var clouds: Clouds,
        var sys: Sys,

        var code: Int
) {

}