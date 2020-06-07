package com.hawksjamesf.uicomponent.repository

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.hawksjamesf.uicomponent.model.Item

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Nov/24/2019  Sun
 */
class PhotoDataSourceFactory(
        private val region: CacheRegion,
        private val api: NetworkApi
) : DataSource.Factory<String, Item>() {

    val sourceLiveData = MutableLiveData<DataSource<String, Item>>()
    override fun create(): DataSource<String, Item> {
        val datasource:DataSource<String, Item> = when (region) {
            CacheRegion.IN_MEMORY_BY_ITEM -> {
                PhotoItemKeyedDataSource(api)
            }
            CacheRegion.IN_MEMORY_BY_PAGE -> {
                PhotoPageKeyedDataSource(api)
            }
            else -> {
                PhotoPageKeyedDataSource(api)
            }
        }
        sourceLiveData.postValue(datasource)
        return datasource
    }
}