package com.example.jlrsignin.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.jlrsignin.domain.usecase.GetDataUsercase
import com.example.jlrsignin.domain.usecase.VerificationUserCase
import com.example.jlrsignin.domain.usecase.model.User
import com.example.jlrsignin.presentation.view.navigation.Screen
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
    private val _uiState = MutableStateFlow<UiStateResponse>(UiStateResponse.SuccessButNoName)
    val uiState: StateFlow<UiStateResponse> = _uiState.asStateFlow()

//    private val _loadingView = MutableStateFlow("")
//    val loadingView: StateFlow<String> = _loadingView.asStateFlow()


    var namePresent: Boolean = false
    var pinPresent: Boolean = true

    fun onUserNameChange(newUserName: String) {
        _username.value = newUserName
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    var verificationSuccess: Boolean = false

    fun onSigninButtonClicked(userIdData: String, passwordData: String,navController: NavController) {

        _uiState.value = UiStateResponse.Loading

        verificationSuccess = VerificationUserCase().verifyUser(
            User(
                userIdData, passwordData,
                null, null
            )
        )

        if(verificationSuccess){
            _uiState.value = UiStateResponse.Success
            CheckPinAndName(User(
                userIdData, passwordData,
                null, null
            ))

            nextPageLogic(navController)

        }else {
            _uiState.value = UiStateResponse.verification_Failed
        }

    }

    fun CheckPinAndName (user: User){
        namePresent = GetDataUsercase().checkName(user)
        pinPresent = GetDataUsercase().checkPin(user)
    }

    fun nextPageLogic(navController: NavController){
        println("outside if")
        if(!namePresent){
            //write the logic of name page navigator
            namePresent = true //remove this, this is mimicking database
            navController.navigate(Screen.name_page.route)
            println("inside if")
        }
        if(!pinPresent){
            pinPresent=true //remove this, this is mimicking database
            //write the logic of pin page navigator
            navController.navigate(Screen.pin_page.route)
        }
        if(namePresent && pinPresent){
            //go to the welcome page
        }
    }
}