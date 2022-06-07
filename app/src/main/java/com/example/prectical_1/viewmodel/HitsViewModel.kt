package com.example.prectical_1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.prectical_1.model.HitsItem
import com.example.prectical_1.paging_source.HitsItemPagingSource
import com.example.prectical_1.repository.HitsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HitsViewModel @Inject constructor(private val hitsRepo: HitsRepo) : ViewModel() {
    var hitsList : Flow<PagingData<HitsItem>> = Pager(PagingConfig(pageSize = 20)){
        hitsRepo.getPagingSource()
    }.flow.cachedIn(viewModelScope)             //data flow for paging

}