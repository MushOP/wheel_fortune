package com.example.wheel_fortune.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wheel_fortune.ViewModel.GlobalViewModel
import com.example.wheel_fortune.ui.theme.bgLost

@Composable
fun LostView(navController: NavController, viewModel: GlobalViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val word = uiState.word.item
    val score = uiState.score

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgLost)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "You Lost!",
            color = Color.Red,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(80.dp))

        Text(
            text = "The word was",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = word,
            color = Color.Green,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(10.dp))
        Divider(color = Color.DarkGray, thickness = 5.dp)
        Spacer(modifier = Modifier.size(30.dp))
        Text(
            text = "You had ${score} points",
            color = Color.Yellow,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(40.dp))
        Button(
            onClick = { navController.navigate("play"); viewModel.resetGame() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            modifier = Modifier.size(250.dp, 50.dp),
        )
        {
            Text(
                text = "Play again",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LostPreview() {
    LostView(rememberNavController(), GlobalViewModel())
}