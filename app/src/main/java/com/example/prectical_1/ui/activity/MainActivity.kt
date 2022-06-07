package com.example.prectical_1.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.prectical_1.ui.compose.HitsListCompose
import com.example.prectical_1.ui.theme.Prectical_1Theme
import com.example.prectical_1.viewmodel.HitsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : HitsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Prectical_1Theme {
                HitsListCompose(viewModel = viewModel, context = this)

            }
        }
    }
}
