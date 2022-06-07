package com.example.prectical_1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.prectical_1.model.HitsItem
import com.example.prectical_1.paging_source.HitsItemPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HitsViewModel @Inject constructor(private val hitsItemPagingSource: HitsItemPagingSource) : ViewModel() {
    var hitsList : Flow<PagingData<HitsItem>> = Pager(PagingConfig(pageSize = 20)){
        hitsItemPagingSource
    }.flow.cachedIn(viewModelScope)
}