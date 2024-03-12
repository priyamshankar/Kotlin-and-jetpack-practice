package com.example.jlrsignin.presentation.view.navigation

sealed class Screen(val route: String) {
    object SignIn_Screen : Screen("signin")
    object name_page : Screen("namepage")
    object pin_page : Screen("pinpage")
    object welcomePage : Screen("welcomepage")
}