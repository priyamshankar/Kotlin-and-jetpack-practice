package com.example.alignmenttutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Surface (
            modifier = Modifier.fillMaxSize()
        ) {
            Row(modifier = Modifier.background(color=Color.Gray).padding(15.dp).background(color= Color.Yellow).padding(19.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                Column (modifier = Modifier.background(color = Color.White).padding(8.dp)) {

                    for (x in 1..5) {
                        Text(text = "$x : $textToWrite")
                    }
                }
                Text(text = "hello $textToWrite", modifier = Modifier.background(color = Color.Gray))
            }
        }
    }
}

@Preview
@Composable
fun AlignFnPreview() {
    AlignFn(textToWrite = "dibyendu")
}
