package com.example.jlrsignin.domain.repository

import com.example.jlrsignin.domain.model.User

interface UserRepository {
    fun getUser(): User
    fun updateName(user: User): Int
    fun updatePin(user: User): Int
}