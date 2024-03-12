package com.example.jlrsignin.domain.usecase

import com.example.jlrsignin.data.repository.DummyDatabase
import com.example.jlrsignin.domain.usecase.model.User

class GetDataUsercase() {
    fun checkPin(user: User): Boolean {
        var getFetchedData: User = DummyDatabase.getUser()
        return getFetchedData.pin != null
    }

    fun checkName(user: User): Boolean {
        var getFetchedData: User = DummyDatabase.getUser()
        return getFetchedData.name != null
    }
}