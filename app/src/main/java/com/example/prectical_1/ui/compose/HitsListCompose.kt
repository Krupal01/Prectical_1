package com.example.prectical_1.ui.compose

import android.content.Context
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.prectical_1.model.HitsItem
import com.example.prectical_1.viewmodel.HitsViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun HitsListCompose(
    modifier: Modifier = Modifier,
    viewModel: HitsViewModel,
    context: Context
){
    val rememberSwipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    val hitsItemList : LazyPagingItems<HitsItem> = viewModel.hitsList.collectAsLazyPagingItems()

    SwipeRefresh(
        state = rememberSwipeRefreshState,
        onRefresh = {
            hitsItemList.refresh()
            viewModel.clearSelection()
        }
    ) {
        rememberSwipeRefreshState.isRefreshing = hitsItemList.loadState.refresh is LoadState.Loading

        LazyColumn{
            items(hitsItemList){item: HitsItem? ->
                if (item != null) {

                    val checkedState = remember { mutableStateOf(false) }
                    checkedState.value = viewModel.isSelected(item)     // after refreshing , set switch check state
                    HitsRowItemCompose(
                        hitsItem = item,
                        onCardClick = {
                            if (viewModel.isSelected(item)){
                                viewModel.setDeselected(item)
                            }else{
                                viewModel.setSelected(item)
                            }
                            checkedState.value = viewModel.isSelected(item)
                        },
                        isSelected = checkedState.value,
                        onSwitchCheckChange = {
                            if (it){
                                viewModel.setSelected(item)
                            }else{
                                viewModel.setDeselected(item)
                            }
                            checkedState.value = viewModel.isSelected(item)
                        }
                    )
                }
            }
        }
    }
}
