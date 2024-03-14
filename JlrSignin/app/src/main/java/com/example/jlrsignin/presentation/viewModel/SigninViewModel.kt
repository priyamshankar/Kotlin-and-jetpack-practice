package com.example.jlrsignin.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.jlrsignin.di.DependencyProvider
import com.example.jlrsignin.domain.usecase.GetDataUsercase
import com.example.jlrsignin.domain.usecase.VerificationUserCase
import com.example.jlrsignin.domain.model.User
import com.example.jlrsignin.domain.usecase.UpdateUsecase
import com.example.jlrsignin.presentation.view.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SigninViewModel @Inject constructor(): ViewModel() {

//    private val updateUsecase = DependencyProvider.provideUpdateUseCase() //di for updateusercase

    @Inject
    lateinit var updateUsecase: UpdateUsecase

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _uiState = MutableStateFlow<UiStateResponse>(UiStateResponse.SuccessButNoName)

    val uiState: StateFlow<UiStateResponse> = _uiState.asStateFlow()

    private val _pin = MutableStateFlow(0)
    val pin: StateFlow<Int> = _pin.asStateFlow()

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()


    private var _nameP = mutableStateOf<Boolean>(true)
    private val nameP: State<Boolean> = _nameP

    private var _pinP = mutableStateOf<Boolean>(true)
    private val pinp: State<Boolean> = _pinP


    fun onUserNameChange(newUserName: String) {
        _username.value = newUserName
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun onNameChangeVal(newName: String) {
        _name.value = newName
    }

//    private var verificationSuccess: Boolean = false

    suspend fun onSigninButtonClicked(
        userIdData: String,
        passwordData: String,
        navController: NavController
    ) {

        _uiState.value = UiStateResponse.Loading

        viewModelScope.launch {
            var verificationSuccess = async {
                VerificationUserCase().verifyUser(
                    User(
                        userIdData, passwordData,
                        null, null
                    )
                )
            }

            if (verificationSuccess.await()) {
                _uiState.value = UiStateResponse.Success
                CheckPinAndName(
                    User(
                        userIdData, passwordData,
                        null, null
                    )
                )
                _uiState.value = UiStateResponse.SuccessButNoName

                nextPageLogic(navController,userIdData)
            } else {
                _uiState.value = UiStateResponse.verification_Failed
            }
        }

    }

    suspend private fun CheckPinAndName(user: User) {

        val hasName = withContext(Dispatchers.IO) {
            async {
                GetDataUsercase().checkName(user)
            }
        }
        val hasPin = withContext(Dispatchers.IO) {
            async {
                GetDataUsercase().checkPin(user)
            }
        }
        _nameP.value = hasName.await()
        _pinP.value = hasPin.await()
    }

    private fun nextPageLogic(navController: NavController, userNamePassed: String) {

        if (!nameP.value) {
//            println("inside name p ${pinp.value}")
            navController.navigate(Screen.name_page.route + "?userNamePassed=${userNamePassed}")
//            println("inside name p ${pinp.value}")
            return
        } else if (!pinp.value) {
//            println("inside pin ${pinp.value}")
            navController.navigate(Screen.pin_page.route + "?userNamePassed=${userNamePassed}")
            return
        } else {
            navController.navigate(Screen.welcomePage.route + "?userNamePassed=${userNamePassed}")
        }
    }

    fun onPinChangeVal(changedPin: String) {
        _pin.value = changedPin.toIntOrNull() ?: 0
    }

    fun onPinNextButtonClicked(navController: NavController, userName: String) {
        _uiState.value = UiStateResponse.Loading
        viewModelScope.launch {
            updateUsecase.updatePin(user = User(userName, "", "", ""))
            _uiState.value = UiStateResponse.SuccessButNoName
            nextPageLogic(navController, userName)
        }
    }

    suspend fun onNameNextButtonClicked(
        navController: NavController,
        Name: String,
        userName: String
    ) {
        _uiState.value = UiStateResponse.Loading
        _name.value = Name
        viewModelScope.launch {
            updateUsecase.updateName(user = User(userName, "", "", ""))
            _uiState.value = UiStateResponse.SuccessButNoName
            nextPageLogic(navController, userName)
        }
    }

    suspend fun getUserName(userName: String) {
        viewModelScope.launch {
            val user: User = GetDataUsercase().getUserdata(user = User(userName, "", "", ""))
            _name.value = user.name.toString()
        }
    }
}
