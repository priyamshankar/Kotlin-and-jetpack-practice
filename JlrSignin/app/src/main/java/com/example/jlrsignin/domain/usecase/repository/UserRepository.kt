package com.example.jlrsignin.domain.usecase.repository

import com.example.jlrsignin.domain.usecase.model.User

interface UserRepository {
    fun getUser(): User
    fun updateName(user: User): Int
    fun updatePin(user: User): Int
}