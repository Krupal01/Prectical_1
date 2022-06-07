package com.example.prectical_1.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.prectical_1.model.HitsItem
import com.example.prectical_1.network.HitsService
import com.example.prectical_1.utils.Utils
import javax.inject.Inject

class HitsItemPagingSource @Inject constructor(private val hitsService: HitsService) : PagingSource<Int,HitsItem>() {
    override fun getRefreshKey(state: PagingState<Int, HitsItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HitsItem> {

        return try{
            val page = params.key ?: 1
            val data = hitsService.getHits(Utils.URL_TAG,page)

            LoadResult.Page(
                data = data.hits,
                prevKey = if (page == 1) null else page-1,
                nextKey = if (page >= data.nbPages!!) null else page+1
            )
        }catch (e : Exception){
            LoadResult.Error(e)
        }

    }
}