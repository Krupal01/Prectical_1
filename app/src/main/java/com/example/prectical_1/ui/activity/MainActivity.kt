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
import com.example.prectical_1.ui.compose.HitsListCompose
import com.example.prectical_1.ui.theme.Prectical_1Theme
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
                SwipeToRefreshCompose(viewModel = viewModel, context = this)
            }
        }
    }
}

@Composable
fun SwipeToRefreshCompose(
    viewModel: HitsViewModel,
    context: Context
){
    Scaffold(
        topBar = {
            TopAppBar(                                              //TopAppBar
                title = {Text("Practical 1")},
                backgroundColor = MaterialTheme.colors.primary)
        }

    ) {
        HitsListCompose(viewModel = viewModel, context = context)       //paging with pull to refresh
    }
}