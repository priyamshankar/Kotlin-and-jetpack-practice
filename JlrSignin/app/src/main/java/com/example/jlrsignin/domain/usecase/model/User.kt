package com.example.jlrsignin.domain.usecase.model

data class User(
    val userName: String,
    val password : String,
    val name: String?,
    val pin: String?
)
