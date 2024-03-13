package com.example.jlrsignin.domain.usecase

import com.example.jlrsignin.domain.model.User
import com.example.jlrsignin.domain.repository.UserRepository

class UpdateUsecase (private val userRepository: UserRepository){
    fun updateName (user: User) {
        userRepository.updateName(user)
    }

    fun updatePin(user: User){
        userRepository.updatePin(user)
    }

}