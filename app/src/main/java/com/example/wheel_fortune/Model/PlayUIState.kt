package com.example.wheel_fortune.Model

data class PlayUIState(
    var health: Int = 5,
    var score: Int = 0,
    var won: Boolean = false,
    var lost: Boolean = false,
    var word: Item = Item(),
    var amtOfLetters: Int = 0,
    var hasSpun: Boolean = false,
    var spinPoints: Int = 0,
    var WordInletters: List<WordInletters> = mutableListOf(),
    var letters: List<KeyboardGuessLetters> = listOf(
        KeyboardGuessLetters('A'),
        KeyboardGuessLetters('B'),
        KeyboardGuessLetters('C'),
        KeyboardGuessLetters('D'),
        KeyboardGuessLetters('E'),
        KeyboardGuessLetters('F'),
        KeyboardGuessLetters('G'),
        KeyboardGuessLetters('H'),
        KeyboardGuessLetters('I'),
        KeyboardGuessLetters('J'),
        KeyboardGuessLetters('K'),
        KeyboardGuessLetters('L'),
        KeyboardGuessLetters('M'),
        KeyboardGuessLetters('N'),
        KeyboardGuessLetters('O'),
        KeyboardGuessLetters('P'),
        KeyboardGuessLetters('Q'),
        KeyboardGuessLetters('R'),
        KeyboardGuessLetters('S'),
        KeyboardGuessLetters('T'),
        KeyboardGuessLetters('U'),
        KeyboardGuessLetters('V'),
        KeyboardGuessLetters('W'),
        KeyboardGuessLetters('X'),
        KeyboardGuessLetters('Y'),
        KeyboardGuessLetters('Z'),
    ),
    var firstSpin: Boolean = true,
)

class points {
    fun getPointsList(): List<Int> {
        return listOf(0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000)
    }
}