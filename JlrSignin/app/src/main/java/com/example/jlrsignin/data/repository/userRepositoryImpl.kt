package com.example.jlrsignin.data.repository

import com.example.jlrsignin.data.DummyDatabase
import com.example.jlrsignin.domain.model.User
import com.example.jlrsignin.domain.repository.UserRepository

class userRepositoryImpl : UserRepository {
    override suspend fun getUser(): User {
        return DummyDatabase.getUser()
    }

    override suspend fun updateName(user: User): Int {
        return DummyDatabase.updateName(user)
    }

    override suspend fun updatePin(user: User): Int {
        return DummyDatabase.updatePin(user)
    }
}