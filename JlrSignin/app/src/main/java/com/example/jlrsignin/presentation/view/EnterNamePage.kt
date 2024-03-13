package com.example.jlrsignin.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jlrsignin.presentation.viewModel.SigninViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun EnterNameComposable(
    modifier: Modifier,
    viewModel: SigninViewModel = viewModel(),
    navController: NavController
) {
    val nameVar1 = viewModel.name.collectAsState().value
    val scope = rememberCoroutineScope()

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
                    viewModel.onNameNextButtonClicked(navController)
                }
            },
            modifier = modifier.padding(5.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview
@Composable
private fun Enternameprev() {
//    EnterNameComposable(modifier = Modifier)
}