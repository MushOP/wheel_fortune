package com.example.wheel_fortune.Model

data class Item(
    var category: String = "",
    var item: String = "",
)

class KeyboardGuessLetters(char: Char) {
    var letter: Char = char
    var isGuessed: Boolean = false
}

class WordInletters(var letter: Char) {
    var isGuessed: Boolean = false
}

object Data {
    val listOfWords = listOf(
        Item("Animals", "cat"),
        Item("Animals", "dog"),
        Item("Animals", "bird"),
        Item("Animals", "fish"),
        Item("Animals", "snake"),
        Item("Animals", "horse"),
        Item("Animals", "cow"),
        Item("Animals", "pig"),
        Item("Animals", "sheep"),
        Item("Animals", "goat"),
        Item("Animals", "chicken"),
        Item("Animals", "duck"),
        Item("Animals", "rabbit"),
        Item("Animals", "deer"),
        Item("Animals", "bear"),
        Item("Animals", "wolf"),
        Item("Animals", "fox"),
        Item("Animals", "lion"),
        Item("Animals", "tiger"),
        Item("Animals", "elephant"),
        Item("Animals", "giraffe"),
        Item("Animals", "zebra"),
        Item("Animals", "monkey"),
        Item("Animals", "gorilla"),
        Item("Animals", "panda"),
        Item("Animals", "kangaroo"),
        Item("Animals", "koala"),
        Item("Animals", "hippopotamus"),
        Item("Animals", "rhinoceros"),
        Item("Animals", "crocodile"),
        Item("Animals", "alligator"),
        Item("Animals", "dolphin"),
        Item("Animals", "whale"),
        Item("Animals", "shark"),
        Item("Animals", "octopus"),
        Item("Animals", "seal"),
        Item("Animals", "penguin"),
        Item("Animals", "owl"),
        Item("Animals", "eagle"),
        Item("Animals", "sparrow"),
        Item("Animals", "parrot"),
        Item("Animals", "frog"),
        Item("Animals", "beetle"),
        Item("Animals", "butterfly"),
        Item("Animals", "spider"),
        Item("Animals", "ant"),
        Item("Animals", "bee"),
        Item("Animals", "mosquito"),
        Item("Animals", "fly"),
        Item("Animals", "ladybug"),
        Item("Countries", "spain"),
        Item("Countries", "denmark"),
        Item("Countries", "ecuador"),
        Item("Countries", "sweden"),
        Item("Countries", "theunitedstatesofamerica"),
        Item("Countries", "ecuador"),
        Item("Countries", "algeria"),
        Item("Countries", "argentina"),
        Item("Countries", "australia"),
        Item("Countries", "austria"),
        Item("Countries", "belgium"),
        Item("Countries", "brazil"),
        Item("Countries", "bulgaria"),
        Item("Countries", "canada"),
        Item("Countries", "chile"),
        Item("Countries", "china"),
        Item("Countries", "colombia"),
        Item("Countries", "croatia"),
        Item("Countries", "cuba"),
        Item("Countries", "cyprus"),
        Item("Countries", "czechrepublic"),
        Item("Countries", "denmark"),
        Item("Countries", "egypt"),
        Item("Countries", "estonia"),
        Item("Countries", "finland"),
        Item("Countries", "france"),
        Item("Countries", "germany"),
        Item("Countries", "greece"),
        Item("Countries", "hungary"),
        Item("Countries", "iceland"),
        Item("Countries", "india"),
        Item("Countries", "indonesia"),
        Item("Countries", "iran"),
        Item("Countries", "iraq"),
        Item("Countries", "ireland"),
    )

    fun getWord(): Item {
        return listOfWords.random()
    }
}