package com.example.wheel_fortune.Nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wheel_fortune.Views.*
import com.example.wheel_fortune.ViewModel.GlobalViewModel

// pretty simple navcontroller, self explanatory
@Composable
fun Nav(controller: NavHostController) {
    val viewModel = GlobalViewModel()
    NavHost(navController = controller, startDestination = NavViews.Home.navroute){
        composable(NavViews.Home.navroute){
            HomeView(navController = controller)
        }
        composable(NavViews.Play.navroute){
            PlayView(navController = controller, viewModel = viewModel)
        }
        composable(NavViews.Win.navroute){
            WinView(navController = controller, viewModel = viewModel)
        }
        composable(NavViews.Lost.navroute){
            LostView(navController = controller, viewModel = viewModel)
        }
    }
}