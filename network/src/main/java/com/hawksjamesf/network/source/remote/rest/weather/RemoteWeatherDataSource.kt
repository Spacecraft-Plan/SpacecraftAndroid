package com.hawksjamesf.network.source.remote.rest.weather

import com.hawksjamesf.network.gson.ListRes
import com.hawksjamesf.mockserver.model.WeatherData
import com.hawksjamesf.network.source.WeatherDataSource
import com.hawksjamesf.network.source.remote.rest.AbstractApi
import io.reactivex.Observable
import io.reactivex.Single
import kotlin.reflect.KClass

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Nov/10/2018  Sat
 */
class RemoteWeatherDataSource : WeatherDataSource, AbstractApi<WeatherApi>() {
    override lateinit var api: WeatherApi

    override fun getClass(): KClass<WeatherApi> = WeatherApi::class

    override fun getCurrentWeatherDate(city: String): Single<WeatherData> {
        return api.getCurrentWeatherDate(city)

    }

    override fun getFiveData(city: String): Observable<ListRes<WeatherData>> {
        return api.getFiveData(city)

    }
}