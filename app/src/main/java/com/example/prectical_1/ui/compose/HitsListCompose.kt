package com.example.prectical_1.ui.compose

import android.content.Context
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.prectical_1.model.HitsItem
import com.example.prectical_1.viewmodel.HitsViewModel


@Composable
fun HitsListCompose(
    modifier: Modifier = Modifier,
    viewModel: HitsViewModel,
    context: Context
){

    val hitsItemList : LazyPagingItems<HitsItem> = viewModel.hitsList.collectAsLazyPagingItems()

    LazyColumn{
        items(hitsItemList){item: HitsItem? ->
            if (item != null) {
                HitsRowItemCompose(
                    hitsItem = item,
                    onCardClick = { /*TODO*/ },
                    onSwitchCheckChange = {}
                )
            }
        }
    }

}
