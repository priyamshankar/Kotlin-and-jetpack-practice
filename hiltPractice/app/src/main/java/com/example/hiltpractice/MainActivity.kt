package com.example.hiltpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import com.example.hiltpractice.ui.theme.HiltPracticeTheme
import com.example.hiltpractice.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    val viewModel : MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//                    val viewModel = ViewModelProvider(LocalContext.current).get(MainViewModel::class.java)
//                    val viewModel = MainViewModel()
                    val viewModel : MainViewModel by viewModels()
                    Greeting("Android", viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, viewModel: MainViewModel, modifier: Modifier = Modifier) {

    Text(
        text = "${viewModel.getContextText()}",
        modifier = modifier
    )

}