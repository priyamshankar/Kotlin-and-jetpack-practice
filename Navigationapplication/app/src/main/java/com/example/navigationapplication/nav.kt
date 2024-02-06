package com.example.navigationapplication

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

enum class nav(title: String) {
    Start(title = "Name Page"),
    Mid(title = "subPage"),
    End(title = "goodBye")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = nav.Start.name) {
        composable(route = nav.Start.name) {
            StartMain(navController = navController)
        }
        composable(route = nav.Mid.name +"/inputText" , arguments = listOf(
            navArgument("inputText") {
                type = NavType.StringType
                defaultValue = "priyam"
                nullable = true
            }
        )) { here ->
            (
                    MidPage(inputText = here.arguments?.getString("inputText"))
                    )
        }
    }

}

@Composable
fun StartMain(navController: NavController) {
    var inputText by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TextField(value = inputText, onValueChange = {
            inputText = it
        })
        Button(onClick = {
            navController.navigate(nav.Mid.name)
        }) {
            Text(text = "Next")
        }
    }
}


@Composable
fun MidPage(inputText: String?) {
    Column {
        Text(text = "hi $inputText")
    }
}