package com.example.jlrsignin.presentation.viewModel

sealed class UiStateResponse {
    object Loading : UiStateResponse()
    object Success : UiStateResponse()
    object SuccessButNoName : UiStateResponse()
    object SuccessButNoPin : UiStateResponse()
    data class Error(val message : String?) : UiStateResponse()
}