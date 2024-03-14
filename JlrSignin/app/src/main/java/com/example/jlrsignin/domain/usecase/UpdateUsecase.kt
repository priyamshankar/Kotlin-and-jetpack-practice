package com.example.jlrsignin.domain.usecase

import com.example.jlrsignin.domain.model.User
import com.example.jlrsignin.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUsecase @Inject constructor(private val userRepository: UserRepository){
    suspend  fun updateName (user: User) {
        userRepository.updateName(user)
    }

    suspend fun updatePin(user: User){
        userRepository.updatePin(user)
    }

}