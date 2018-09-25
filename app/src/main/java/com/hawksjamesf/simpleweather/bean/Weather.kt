package com.hawksjamesf.simpleweather.bean

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawskjamesf
 * @since: Sep/25/2018  Tue
 */
data class Weather(
        var id:Int,
        var main:String,
        var description:String,
        var icon:String
) {
}