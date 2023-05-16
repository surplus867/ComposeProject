package com.example.composeProject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.rememberDrawerState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeProject.navigation.SetupNavigation
import com.example.composeProject.ui.theme.MyApplication34Theme
import com.example.composeProject.ui.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val shareViewModel: SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication34Theme {
                navController = rememberNavController()
                SetupNavigation(
                    navController = navController,
                    sharedViewModel = shareViewModel
                )
            }
        }
    }
}