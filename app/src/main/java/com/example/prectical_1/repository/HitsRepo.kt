package com.example.prectical_1.repository

import com.example.prectical_1.network.HitsService
import com.example.prectical_1.paging_source.HitsItemPagingSource
import javax.inject.Inject

class HitsRepo @Inject constructor(private val hitsService: HitsService) {
    fun getPagingSource(): HitsItemPagingSource {
        return HitsItemPagingSource(hitsService)            //unique paging source object for every refresh
    }
}