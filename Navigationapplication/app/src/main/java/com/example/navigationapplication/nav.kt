package com.example.navigationapplication

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
        composable(route = nav.Mid.name + "?inputText={inputText}", arguments = listOf(
            navArgument("inputText") {
                type = NavType.StringType
                defaultValue = "priyam"
                nullable = true
            }
        )) { backStackEntry ->
            MidPage(
                navController = navController,
                inputText = backStackEntry.arguments?.getString("inputText")
            )

        }
        composable(route = nav.End.name + "?text={text}", arguments = listOf(
            navArgument("text") {
                type = NavType.StringType
                defaultValue = "EndPage"
                nullable = true
            }
        )) { backStackEntry ->
            Endpage(
                navController = navController,
                text = backStackEntry.arguments?.getString("text")
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
//            navController.navigate(nav.Mid.name)
            navController.navigate("${nav.Mid.name}?inputText=$inputText")
        }) {
            Text(text = "Next")
        }
        Button(onClick = { navController.navigate("${nav.End.name}?inputText=$inputText") }) {
            Text(text = "Go to the Last Page")
        }
    }
}


@Composable
fun MidPage(navController: NavController, inputText: String?) {
    var text by remember {
        mutableStateOf("ending is explained")
    }
    Column {
        Text(text = "hi $inputText")
        TextField(value = text, onValueChange = {
            text = it
        })
        Button(onClick = {
//            navController.navigate("${nav.End.name}?text=$text")
            navController.navigate("${nav.End.name}?text=$text")

        }) {
            Text(text = "Go to final page")
        }
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }
    }
}

@Composable
fun Endpage(navController: NavController, text: String?) {
    Column {
        Text(text = "This is the end page : $text")
        Button(onClick = {
            navController.popBackStack(nav.Start.name,false)
        }) {
            Text(text = "Back")
        }
    }
}