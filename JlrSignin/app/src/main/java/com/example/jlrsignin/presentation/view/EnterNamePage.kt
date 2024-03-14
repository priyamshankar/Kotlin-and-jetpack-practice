package com.example.jlrsignin.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
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
fun EnterNameComposable(
    modifier: Modifier,
    viewModel: SigninViewModel = viewModel(),
    navController: NavController,
    userNamePassed : String?
) {
    val nameVar1 = viewModel.name.collectAsState().value
    val scope = rememberCoroutineScope()
    val uiState = viewModel.uiState.collectAsState().value

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
                    text = "Enter Your Name",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    textAlign = TextAlign.Center
                )
                TextField(
                    value = nameVar1, onValueChange =
                    { viewModel.onNameChangeVal(it) },
                    singleLine = true
                )
                Button(
                    onClick = {
                        scope.launch {
                            if (userNamePassed != null) {
                                viewModel.onNameNextButtonClicked(navController, nameVar1, userNamePassed)
                            }
                        }
                    },
                    modifier = modifier.padding(5.dp)
                ) {
                    Text(text = "Next")
                }
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
private fun Enternameprev() {
//    EnterNameComposable(modifier = Modifier)
}