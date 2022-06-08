package com.example.prectical_1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.prectical_1.model.HitsItem
import com.example.prectical_1.repository.HitsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HitsViewModel @Inject constructor(private val hitsRepo: HitsRepo) : ViewModel() {
    var hitsList : Flow<PagingData<HitsItem>> = Pager(PagingConfig(pageSize = 20)){
        hitsRepo.getPagingSource()
    }.flow.cachedIn(viewModelScope)             //data flow for paging

    var selected = MutableLiveData<MutableList<HitsItem>>()
    var _selected = mutableListOf<HitsItem>()

    fun setSelected(hitsItem: HitsItem){
        _selected.add(hitsItem)
        selected.value = _selected
    }

    fun setDeselected(hitsItem: HitsItem){
        _selected = selected.value!!
        _selected.remove(hitsItem)
        selected.value = _selected
    }

    fun clearSelection(){
        _selected.clear()
        selected.value = _selected
    }

    fun isSelected(hitsItem: HitsItem): Boolean {
        return selected.value?.contains(hitsItem) ?: false
    }


}