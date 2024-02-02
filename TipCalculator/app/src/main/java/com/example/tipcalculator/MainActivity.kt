package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculateTip()
                }
            }
        }
    }
}

// sri udupi, ambedkar chowk
@Composable
fun CalculateTip() {
    var amountInput by remember {
        mutableStateOf("")
    }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    var tipPercentages by remember {
        mutableStateOf("")
    }
    val tipDouble = tipPercentages.toDoubleOrNull() ?:0.0
    val tips = calculateTip(amount,tipDouble)
    TipCalculatorTheme {
        Surface {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = 8.dp,
                        shape = RoundedCornerShape(1.dp),
                        color = Color.Gray
                    ),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Calculate Tip",
                    modifier = Modifier
                        .padding(50.dp, 2.dp, 4.dp, 8.dp),
                    fontSize = 15.sp, color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
                TextFieldFnc(value = amountInput, onValueChange = {amountInput=it},"Enter the Bill Amount",
                    modifier = Modifier
                        .padding(30.dp, 0.dp, 30.dp, 0.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextFieldFnc(value = tipPercentages, onValueChange = {tipPercentages=it},
                    "Enter the tip percentage",modifier = Modifier
                        .padding(30.dp, 0.dp, 30.dp, 0.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(0.dp, 100.dp, 0.dp, 0.dp))
                Text(
                    text = "Tip Amount: $tips",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 33.sp,
                    fontWeight = FontWeight.Medium,
                    color=Color.DarkGray
                )
            }
        }
    }
}

@Composable
fun TextFieldFnc(value: String, onValueChange: (String) -> Unit, label : String ,modifier: Modifier) {
//    var amountInput by remember {
//        mutableStateOf("")
//    }

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Preview
@Composable
fun CalculateTipPreview() {
    CalculateTip()
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0): Double {
    val tip = tipPercent * amount / 100
    return tip
}