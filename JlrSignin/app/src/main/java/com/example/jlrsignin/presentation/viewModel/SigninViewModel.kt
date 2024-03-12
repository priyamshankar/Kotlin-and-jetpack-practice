package com.example.jlrsignin.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.example.jlrsignin.domain.usecase.VerificationUserCase
import com.example.jlrsignin.domain.usecase.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SigninViewModel : ViewModel() {
    //    val nameTrigger by remember {
//        mutableStateOf(null)
//    }
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    // UI state (optional, can represent loading, success, error)
    private val _uiState = MutableStateFlow<UiStateResponse>(UiStateResponse.Loading)
    val uiState: StateFlow<UiStateResponse> = _uiState.asStateFlow()



    var namePresent: Boolean = false
    var pinPresent: Boolean = true

    fun onUserNameChange(newUserName: String) {
        _username.value = newUserName
    }

    fun onPasswordChange (newPassword : String){
        _password.value = newPassword
    }

    val verificationSuccess: Boolean =
        VerificationUserCase().verifyUser(User("priyamshankar.5", "priyam", "1234"))


}