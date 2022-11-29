package com.example.wheel_fortune.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wheel_fortune.ui.theme.bgColor

@Composable
fun HomeView(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .size(size = 300.dp)
            .background(bgColor)
    )
    // Add the text in the corner, made this before column so it doesn't allign wrong
    Text(text = "Made by - s205430",
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Left,
    )

    // Create a column that will fill the entire screen
    Column(
        modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
    // Create a text within the column that will fill the entire screen
       Text(
            text = "Wheel of Fortune",
            color = Color.White,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.size(50.dp))

        Button(
            onClick = { navController.navigate("play") },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF008000)),
            modifier = Modifier.size(250.dp, 50.dp),
        )
        {
            Text(
                text = "Play",
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
fun HomePreview() {
    HomeView(rememberNavController())
}
