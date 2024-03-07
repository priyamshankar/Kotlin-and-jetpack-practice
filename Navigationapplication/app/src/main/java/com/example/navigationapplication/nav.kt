package com.example.navigationapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                defaultValue = "default value here"
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
                defaultValue = "Defalut Value"
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
    Box() {


        var inputText by remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Enter Your Name",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )

            Spacer(modifier = Modifier.padding(10.dp))
            TextField(value = inputText, onValueChange = {
                inputText = it
            })
            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
//                    .background(Color.Blue)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

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
    }
}


@Composable
fun MidPage(navController: NavController, inputText: String?) {
    var text by remember {
        mutableStateOf("ending is explained")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "hi $inputText",
            fontWeight = FontWeight.Bold,
//            fontSize = "32sp"
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.padding(10.dp))

        TextField(value = text, onValueChange = {
            text = it
        })
        Spacer(modifier = Modifier.padding(10.dp))

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
//                    .background(Color.Blue)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
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
}

@Composable
fun Endpage(navController: NavController, text: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "This is the end page : $text",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = {
            navController.popBackStack(nav.Start.name, false)
        }) {
            Text(text = "Home")
        }
    }
}

@Preview
@Composable
private fun prev() {
    Endpage(navController = rememberNavController(), "priyam")
}