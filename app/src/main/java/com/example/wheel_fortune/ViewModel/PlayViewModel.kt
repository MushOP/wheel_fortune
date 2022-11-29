package com.example.wheel_fortune.ViewModel

import androidx.lifecycle.ViewModel
import com.example.wheel_fortune.Model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PlayViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PlayUIState())
    val uiState: StateFlow<PlayUIState> = _uiState.asStateFlow()

    fun startGame() {
        _uiState.update {it.copy(word = Data.getWord(), letters = uiState.value.letters)}
    }

    fun endGame() {
        _uiState.update {it.copy(won = false, lost = false, letters = uiState.value.letters)}
    }

    fun onGuess(letter: Char) {
        if(uiState.value.word.item.lowercase().contains(letter.lowercase())) {
            var counter = 0
            for (char in uiState.value.word.item) {
                if(char.lowercase() == letter.lowercase()) {
                    counter++
                }
            }

            _uiState.update {it.copy(amtOfLetters = uiState.value.amtOfLetters + counter, score = uiState.value.score + (counter * uiState.value.spinPoints))}
        } else {
            _uiState.update {it.copy(health = uiState.value.health - 1)}
        }
        _uiState.value.letters.forEach {
            if(it.letter == letter) {
                it.isGuessed = true
            }
        }
        _uiState.update {it.copy(hasSpun = false, letters = uiState.value.letters)}
    }

    fun onSpin() {
        val point = points().getPointsList().shuffled().random()

        if(point == 0) {
            _uiState.update {it.copy(score = 0)}
        }

        _uiState.update {it.copy(spinPoints = point, hasSpun = true)}
    }

    init {
        startGame()
    }
}