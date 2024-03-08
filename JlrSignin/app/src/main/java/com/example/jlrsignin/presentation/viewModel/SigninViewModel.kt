package com.example.jlrsignin.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.example.jlrsignin.domain.usecase.VerificationUserCase
import com.example.jlrsignin.domain.usecase.model.User

class SigninViewModel : ViewModel() {
    //    val nameTrigger by remember {
//        mutableStateOf(null)
//    }

    var namePresent: Boolean = false
    var pinPresent: Boolean = true

    val verificationSuccess: Boolean =
        VerificationUserCase().verifyUser(User("priyamshankar.5", "priyam", "1234"))


}