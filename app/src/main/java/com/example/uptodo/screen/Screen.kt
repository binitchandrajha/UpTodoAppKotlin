package com.example.uptodo.screen

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable object  Onboarding : Screen()

    @Serializable object  Start: Screen()
    @Serializable object  Home: Screen()
}
