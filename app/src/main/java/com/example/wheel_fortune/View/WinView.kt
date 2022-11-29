package com.example.wheel_fortune.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import com.example.wheel_fortune.ui.theme.bgColor

@Composable
fun WinView(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .size(size = 300.dp)
            .background(bgColor)
    )
}