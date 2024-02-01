package com.example.diceroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroll.ui.theme.DiceRollTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRoll()
                }
            }
        }
    }
}

@Composable
fun DiceRoll() {
    DiceRollTheme {
        Surface {
            DiceRollImage(modifier = Modifier)
        }
    }
}

@Composable
fun DiceRollImage(modifier: Modifier) {
    var rollNumber by remember { mutableStateOf(1) }
    var imageforDice = R.drawable.dice_1
    imageforDice = when (rollNumber){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3-> R.drawable.dice_3
        4-> R.drawable.dice_4
        5->R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = imageforDice), contentDescription = "dice")
        Button(onClick = { /*TODO*/
             rollNumber = (1..6).random()

        }) {
            Text(stringResource(R.string.roll))
        }
    }
}

@Composable
fun AnimationTime(){

}

@Preview
@Composable
fun DiceRollPreview() {
    DiceRoll()
}

