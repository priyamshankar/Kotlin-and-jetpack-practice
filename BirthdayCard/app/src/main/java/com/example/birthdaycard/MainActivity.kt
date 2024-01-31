package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.birthdaycard.ui.theme.BirthdayCardTheme
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val name = mutableListOf("Shanu","Kumar")
                    name+= listOf("priyam")
                    BirthdayCard(name[0],name[1])
                }
            }
        }
    }
}
@Composable
fun BirthdayCard (name:String, recepient : String){
    BirthdayCardTheme{
        Surface{
            Column {
                Text (text="Happy Brthday ")
                Text (text = "$name!", modifier = Modifier.align(alignment = Alignment.End))
                Spacer(modifier = Modifier.height(9.dp))
                Text (text = "- From $recepient", modifier = Modifier.align(alignment = Alignment.End))
            }
        }
    }
}

@Preview
@Composable
fun BirthdayCardPreview(){
    val name = mutableListOf("Shanu","Kumar")
    name+= listOf("priyam")
    BirthdayCard(name[0],name[1])
}