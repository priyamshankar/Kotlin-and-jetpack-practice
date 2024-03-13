package com.example.jlrsignin.domain.repository

import com.example.jlrsignin.domain.model.User

interface UserRepository {
    suspend fun getUser(): User
    suspend fun updateName(user: User): Int
    suspend fun updatePin(user: User): Int
}