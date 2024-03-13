package com.example.jlrsignin.data.repository

import com.example.jlrsignin.data.DummyDatabase
import com.example.jlrsignin.domain.model.User
import com.example.jlrsignin.domain.repository.UserRepository

class userRepositoryImpl : UserRepository {
    override fun getUser(): User {
        return DummyDatabase.getUser()
    }

    override fun updateName(user: User): Int {
        return DummyDatabase.updateName(user)
    }

    override fun updatePin(user: User): Int {
        return DummyDatabase.updatePin(user)
    }
}