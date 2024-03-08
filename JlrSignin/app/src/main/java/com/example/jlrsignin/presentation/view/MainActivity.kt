package com.example.jlrsignin.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jlrsignin.domain.usecase.SigninUsecase
import com.example.jlrsignin.ui.theme.JlrSigninTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JlrSigninTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    EnterPinComposable(modifier = Modifier)
//                    signinComposable(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var t by remember {
        mutableStateOf("response code 420")
    }
    LaunchedEffect(Unit) {
        launch {
            val newText = SigninUsecase().invoke()
            withContext(Dispatchers.Main) {

                t = newText
            }
        }
    }
//    coroutineScope {
//        val text = async { SigninUsecase().invoke() }
//        t = text.await()
//    }

    Text(
        text = "Hello $t!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JlrSigninTheme {
        Greeting("Android")
    }
}