package com.example.jlrsignin.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.navigation.NavController
import com.example.jlrsignin.presentation.viewModel.UiStateResponse
import kotlinx.coroutines.launch

@Composable
fun signinComposable(
    modifier: Modifier = Modifier,
    viewModel: SigninViewModel = viewModel(), //To check if it is good practice or not
    navController: NavController
) {
    val userId = viewModel.username.collectAsState().value
    val password = viewModel.password.collectAsState().value
    val uiState = viewModel.uiState.collectAsState().value
    val scope = rememberCoroutineScope()
    Box(
        contentAlignment = Alignment.Center
//        modifier = Modifier.border(BorderStroke(5.dp, SolidColor(Color.LightGray)))
    ) {
        Column {
            Row(
                modifier = Modifier
                    .weight(2.0f)
                    .fillMaxWidth()
                    .background(color = Color(0xFF9E1F32))
            ) {
            }

            Row(
                modifier = Modifier
                    .weight(1.0f)
                    .fillMaxWidth()
                    .background(color = Color(0xFF575355))
            ) {
            }
        }

        Box(
            modifier = Modifier
                .background(color = Color(0xFFEFE3E9))
                .height(400.dp)
                .width(350.dp)
        ) {
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


                    onClick = {
                        scope.launch {
                            viewModel.onSigninButtonClicked(
                                userId,
                                password,
                                navController = navController
                            )
                        }
                    },
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


    }

}


@Preview
@Composable
private fun signinComposablePreview() {
//    signinComposable()
}