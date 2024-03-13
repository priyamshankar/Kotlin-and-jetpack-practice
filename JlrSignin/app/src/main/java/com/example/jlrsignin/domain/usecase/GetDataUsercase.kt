package com.example.jlrsignin.domain.usecase

import com.example.jlrsignin.data.DummyDatabase
import com.example.jlrsignin.domain.model.User

class GetDataUsercase() {
    suspend fun checkPin(user: User): Boolean {
        var getFetchedData: User = DummyDatabase.getUser()
        return getFetchedData.pin != null
    }

    suspend fun checkName(user: User): Boolean {
        var getFetchedData: User = DummyDatabase.getUser()
        return getFetchedData.name != null
    }
}