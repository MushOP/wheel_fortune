package com.example.wheel_fortune.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wheel_fortune.ViewModel.PlayViewModel
import com.example.wheel_fortune.ui.theme.bgColor

@Composable
fun LostView(navController: NavController, viewModel: PlayViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val word = uiState.word.item
    val score = uiState.score

    Box(
        modifier = Modifier
            .fillMaxSize()
            .size(size = 300.dp)
            .background(bgColor)
    )
    Column {
        Text(
            text = "You lost! The word was ${word} and you had ${score} points",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}