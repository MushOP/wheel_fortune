package com.example.wheel_fortune.Nav

open class NavViews(val navroute : String) {
    object Home : NavViews("home")
    object Play : NavViews("play")
    object Win : NavViews("win")
    object Lost : NavViews("lost")
}