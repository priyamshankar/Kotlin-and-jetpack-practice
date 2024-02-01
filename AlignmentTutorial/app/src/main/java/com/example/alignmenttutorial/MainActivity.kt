package com.example.alignmenttutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alignmenttutorial.ui.theme.AlignmentTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlignmentTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AlignFn(textToWrite = "Adam")
                }
            }
        }
    }
}

@Composable
fun AlignFn(textToWrite: String) {
    AlignmentTutorialTheme {
        Surface {
            Row {
                Column {

                    for (x in 1..5) {
                        Text(text = "$x : $textToWrite")
                    }
                }
                Text(text = "hello $textToWrite", modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Preview
@Composable
fun AlignFnPreview() {
    AlignFn(textToWrite = "here")
}
