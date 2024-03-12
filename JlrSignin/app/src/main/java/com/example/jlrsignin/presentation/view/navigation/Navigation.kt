package com.example.jlrsignin.presentation.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jlrsignin.presentation.view.signinComposable
import com.example.jlrsignin.presentation.viewModel.SigninViewModel

@Composable
fun Navigation() {
//    val viewModel: SigninViewModel by viewModels()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SignIn_Screen.route) {
        composable(route = Screen.SignIn_Screen.route) {
            signinComposable()
        }
    }
}