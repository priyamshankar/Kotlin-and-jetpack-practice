package com.example.jlrsignin.data.repository

import com.example.jlrsignin.domain.usecase.model.User

object DummyDatabase {
    private var user: User? = null

    fun getUser(): User {
        return user ?: User("abcd", "abcd", null, null)
    }

    fun updateName(newUser: User): Int {
        return dbResponse.Update_Successfull
    }

    fun updatePin(newUser: User): Int {
        return dbResponse.Update_Successfull
    }
}