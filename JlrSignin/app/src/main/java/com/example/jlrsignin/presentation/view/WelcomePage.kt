package com.example.jlrsignin.presentation.view

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jlrsignin.presentation.viewModel.SigninViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun WelcomePage(
    viewModel: SigninViewModel = viewModel(),
    userNamePassed : String?
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getUserName("")
    }

    var name = viewModel.name.collectAsState().value

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.border(BorderStroke(5.dp, SolidColor(Color.LightGray)))
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
                .width(300.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Text(text = "Hello ${name}")

            }
        }
    }
}

@Preview
@Composable
private fun welcomePagePrev() {
//    WelcomePage()
}