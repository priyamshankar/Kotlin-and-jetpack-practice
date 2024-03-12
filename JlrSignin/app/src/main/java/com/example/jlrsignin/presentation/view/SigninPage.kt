package com.example.jlrsignin.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jlrsignin.presentation.viewModel.UiStateResponse

@Composable
fun signinComposable(
    modifier: Modifier = Modifier,
    viewModel: SigninViewModel = viewModel() //To check if it is good practice or not
) {
    val userId = viewModel.username.collectAsState().value
    val password = viewModel.password.collectAsState().value
    val uiState = viewModel.uiState.collectAsState().value
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SignIn User",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            textAlign = TextAlign.Center
        )
        TextField(
            value = userId,
            onValueChange = { viewModel.onUserNameChange(it) },
            label = { Text(text = "user Name") },
            singleLine = true
        )
        TextField(
            value = password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text(text = "Password") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = { viewModel.onSigninButtonClicked(userId, password) },
            modifier = modifier.padding(5.dp)
        ) {
            Text(text = "SignIn")
        }

        Spacer(modifier = Modifier.padding(20.dp))

        when (uiState) {
            is UiStateResponse.Error -> {
                Text(text = "Error Occurred")
            }

            is UiStateResponse.Loading -> {
                Text(text = "Loading")
            }

            is UiStateResponse.Success -> {
                Text(text = "Login Success")
            }

            is UiStateResponse.SuccessButNoName -> {
                Text(text = "Success But no Name")
            }

            is UiStateResponse.SuccessButNoPin -> {
                Text(text = "Success but no Pin")
            }

            is UiStateResponse.verification_Failed -> {
                Text(text = "Verification Failed")
            }
        }
    }
}


@Preview
@Composable
private fun signinComposablePreview() {
//    signinComposable()
}