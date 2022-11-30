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

    // Split up letters after we find the word
    fun startGame() {
        val word = Data.getWord()
        // Use muteablelistof so we use .add
        val wordInletters = mutableListOf<WordInletters>()
        for (letter in word.item) {
            wordInletters.add(WordInletters(letter))
        }

        _uiState.update {it.copy(word = word, letters = uiState.value.letters, WordInletters = wordInletters)}
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
        uiState.value.WordInletters.forEach {
            if(it.letter.lowercase() == letter.lowercase()) {
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