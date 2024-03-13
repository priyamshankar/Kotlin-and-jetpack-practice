package com.example.jlrsignin.presentation.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WelcomePage(){
    Text(text = "Hello This is welcome page")
}

@Preview
@Composable
private fun welcomePagePrev() {
    WelcomePage()
}