package com.example.jlrsignin.domain.usecase

import com.example.jlrsignin.data.repository.DummyDatabase
import com.example.jlrsignin.domain.usecase.model.User

class VerificationUserCase {
    fun verifyUser(userData: User): Boolean {
        val fetchedUserData: User
        fetchedUserData = DummyDatabase.getUser()
        if (userData.name == fetchedUserData.name) {
            return true
        } else return false

    }
}