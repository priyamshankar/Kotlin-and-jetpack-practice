package com.example.jlrsignin.data

import com.example.jlrsignin.domain.model.User

object DummyDatabase {
    private var user: User? = null

    suspend fun getUser(): User {
        return user ?: User("abcd", "abcd", null, null)
    }

    suspend fun updateName(newUser: User): Int {
        return dbResponse.Update_Successfull
    }

    suspend fun updatePin(newUser: User): Int {
        return dbResponse.Update_Successfull
    }
}