package com.example.prectical_1.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.prectical_1.ui.compose.HitsListCompose
import com.example.prectical_1.ui.theme.Prectical_1Theme
import com.example.prectical_1.utils.Utils
import com.example.prectical_1.viewmodel.HitsViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : HitsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Prectical_1Theme {
                SwipeToRefreshCompose(viewModel = viewModel, context = this,lifecycleOwner = this)
            }
        }
    }
}

@Composable
fun SwipeToRefreshCompose(
    viewModel: HitsViewModel,
    context: Context,
    lifecycleOwner: LifecycleOwner
){

    val numberOfSelected = remember { mutableStateOf(Utils.APP_NAME) }

    viewModel.selected.observe(lifecycleOwner, Observer {
        numberOfSelected.value = if(it.size ==0) Utils.APP_NAME else it.size.toString()
    })


    Scaffold(
        topBar = {
            TopAppBar(                                              //TopAppBar
                title = {Text(numberOfSelected.value)},
                backgroundColor = MaterialTheme.colors.primary)
        }

    ) {
        HitsListCompose(viewModel = viewModel, context = context)       //paging with pull to refresh
    }
}