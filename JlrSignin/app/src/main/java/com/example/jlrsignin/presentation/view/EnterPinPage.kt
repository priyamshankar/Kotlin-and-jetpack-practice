package com.example.jlrsignin.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jlrsignin.presentation.viewModel.SigninViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun EnterPinComposable(
    modifier: Modifier, viewModel: SigninViewModel = viewModel(),
    navController: NavController
) {
    var userPin1 by remember {
        mutableStateOf("")
    }
    var userPin2: Int = 0
    val userPin = viewModel.pin.collectAsState().value

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .wrapContentSize(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enter Your Pin",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            textAlign = TextAlign.Center
        )
        TextField(
            value = userPin.toString(),
            onValueChange = { viewModel.onPinChangeVal(it) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                viewModel.onPinNextButtonClicked(navController = navController)
            }, modifier = modifier.padding(5.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview
@Composable
private fun EnterPinPrev() {
//    EnterPinComposable(modifier = Modifier)
}