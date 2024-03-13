package com.example.jlrsignin.presentation.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jlrsignin.presentation.view.EnterNameComposable
import com.example.jlrsignin.presentation.view.EnterPinComposable
import com.example.jlrsignin.presentation.view.WelcomePage
import com.example.jlrsignin.presentation.view.signinComposable
import com.example.jlrsignin.presentation.viewModel.SigninViewModel

@Composable
fun Navigation() {
//    val viewModel: SigninViewModel by viewModels()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SignIn_Screen.route) {
        composable(route = Screen.SignIn_Screen.route) {
            signinComposable(navController = navController)
        }
        composable(route = Screen.name_page.route + "?userNamePassed={userNamePassed}",
            arguments = listOf(
                navArgument("userNamePassed") {
                    type = NavType.StringType
                }
            )) { backStactEntry ->
            EnterNameComposable(
                modifier = Modifier,
                navController = navController,
                userNamePassed = backStactEntry.arguments?.getString("userNamePassed")
            )
        }
        composable(route = Screen.pin_page.route + "?userNamePassed={userNamePassed}",
            arguments = listOf(
                navArgument("userNamePassed") {
                    type = NavType.StringType
                }
            )) { backStackEntry ->
            EnterPinComposable(
                modifier = Modifier,
                navController = navController,
                userNamePassed = backStackEntry.arguments?.getString("userNamePassed")
            )
        }
        composable(route = Screen.welcomePage.route+"?userNamePassed={userNamePassed}",
            arguments = listOf(
                navArgument("userNamePassed") {
                    type = NavType.StringType
                }
            )) { backStackEntry ->
            WelcomePage(userNamePassed = backStackEntry.arguments?.getString("userNamePassed"))
        }
    }
}