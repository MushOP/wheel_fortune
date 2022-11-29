package com.example.wheel_fortune.Nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wheel_fortune.View.*

@Composable
fun Nav(controller: NavHostController) {
    NavHost(navController = controller, startDestination = NavViews.Home.navroute){
        composable(NavViews.Home.navroute){
            HomeView(navController = controller)
        }
        composable(NavViews.Play.navroute){
            PlayView(navController = controller)
        }
        composable(NavViews.Win.navroute){
            WinView(navController = controller)
        }
        composable(NavViews.Lost.navroute){
            LostView(navController = controller)
        }
    }
}