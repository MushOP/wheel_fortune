package com.example.wheel_fortune.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
import com.example.wheel_fortune.Model.PlayUIState
import com.example.wheel_fortune.ViewModel.PlayViewModel

@Composable
fun PlayView(viewModel: PlayViewModel){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF232F34))
    )

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BuildHealthAndStats(hp = uiState.health, score = uiState.score)
        Spacer(modifier = Modifier.size(75.dp))
        BuildLetterBox()
        Spacer(modifier = Modifier.size(75.dp))
        StartSpinButton(hasSpun = uiState.hasSpun, guess = { viewModel.onSpin() })
    }

}

@Composable
fun BuildHealthAndStats(hp : Int, score : Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .border(BorderStroke(2.dp, Color.Red))
                .fillMaxWidth(0.3f)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Health",
                color = Color.Red,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$hp",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .border(BorderStroke(2.dp, Color.Yellow))
                .fillMaxWidth(0.4f)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Points",
                color = Color.Yellow,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$score",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun BuildLetterBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .fillMaxHeight(0.3f)
            //.background(Color(0xFF2d3d43))
            .padding(5.dp),

    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            backgroundColor = Color(0xFF2d3d43),
            elevation = 20.dp
        ) {
            BuildLetters()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuildLetters() {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(45.dp),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f),

    ) {
        items(26) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                backgroundColor = Color(0xFF43332d),
                elevation = 20.dp
            ) {
                Text(
                    text = "L",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun StartSpinButton(hasSpun: Boolean, guess: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.2f),
        contentAlignment = Alignment.Center
    ) {
        Button(
            enabled = !hasSpun,
            onClick = {guess()},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF008000)),
            modifier = Modifier.size(250.dp, 50.dp),
        )
        {
            Text(
                text = "Spin",
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
fun PlayPreview() {
    PlayView(PlayViewModel())
}