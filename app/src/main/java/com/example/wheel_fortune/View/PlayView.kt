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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wheel_fortune.ViewModel.PlayViewModel
import com.example.wheel_fortune.ui.theme.bgColor

@Composable
fun PlayView(viewModel: PlayViewModel = viewModel(), navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
    )
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BuildHealthAndStats(hp = uiState.health, score = uiState.score)
        Spacer(modifier = Modifier.size(20.dp))
        BuildCategory(category = uiState.word.category)
        Spacer(modifier = Modifier.size(10.dp))
        BuildLetterBox(viewModel = viewModel)
        Spacer(modifier = Modifier.size(30.dp))
        StartSpinButton(hasSpun = uiState.hasSpun, onSpin = {viewModel.onSpin()})
        ShowSpinPoints(points = uiState.spinPoints)
        Spacer(modifier = Modifier.size(70.dp))
        BuildKeyboard(viewModel = viewModel)
    }

    if(uiState.lost){
        viewModel.endGame()
        navController.navigate("lost")
    } else if(uiState.won){
        viewModel.endGame()
        navController.navigate("win")
    }
}

@Composable
fun BuildCategory(category: String){
    Text(
        text = "Category: " + category.uppercase(),
        color = Color.White,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
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
                text = "Score",
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
fun BuildLetterBox(viewModel: PlayViewModel) {
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
            BuildLetters(viewModel = viewModel)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuildLetters(viewModel: PlayViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val word = uiState.word
    val letters = uiState.WordInletters
    LazyVerticalGrid(
        cells = GridCells.Adaptive(45.dp),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f),

    ) {
        items(word.item.length) { index ->
            val txt = if(letters[index].isGuessed) letters[index].letter.uppercase() else ""
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                backgroundColor = Color(0xFF43332d),
                elevation = 20.dp
            ) {
                Text(
                    text = txt,
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
fun StartSpinButton(hasSpun: Boolean, onSpin: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.2f),
        contentAlignment = Alignment.Center
    ) {
        Button(
            enabled = !hasSpun,
            onClick = {onSpin()},
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

@Composable
fun ShowSpinPoints(points: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.1f),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Points: $points",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuildKeyboard(viewModel: PlayViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    if(uiState.hasSpun){
        val guess = uiState.letters

        LazyVerticalGrid(
            cells = GridCells.Adaptive(40.dp),
            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 2.dp),
            modifier = Modifier
                .fillMaxWidth()

        ) {
            items(guess.size) { index ->
                val btncolor = if(!guess[index].isGuessed) Color.White else bgColor
                val txtcolor = if(!guess[index].isGuessed) Color.Black else bgColor

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    backgroundColor = btncolor,
                    elevation = 20.dp
                ) {
                    Button(
                        onClick = {viewModel.onGuess(guess[index].letter)},
                        enabled = !guess[index].isGuessed,
                        colors = ButtonDefaults.buttonColors(backgroundColor = btncolor, disabledBackgroundColor = btncolor),
                        modifier = Modifier.size(250.dp, 50.dp),
                    ) {
                        Text(
                            text = guess[index].letter.toString(),
                            color = txtcolor,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayPreview() {
    PlayView(navController = rememberNavController())
}