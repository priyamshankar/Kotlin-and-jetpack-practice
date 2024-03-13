package com.example.jlrsignin.domain.usecase

import com.example.jlrsignin.data.DummyDatabase
import com.example.jlrsignin.domain.model.User

class VerificationUserCase {
    fun verifyUser(userData: User): Boolean {
        val fetchedUserData: User = DummyDatabase.getUser()
//        println(fetchedUserData.userName)

        return (userData.userName == fetchedUserData.userName && userData.password == fetchedUserData.password
                )
//        return false
    }
}