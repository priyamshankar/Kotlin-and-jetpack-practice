package com.example.jlrsignin.data

import com.example.jlrsignin.data.repository.userRepositoryImpl
import com.example.jlrsignin.domain.usecase.UpdateUsecase
import com.example.jlrsignin.domain.repository.UserRepository

object DependencyProvider {
    private val userRepositoryImpl = userRepositoryImpl()
    private val updateUsecase = UpdateUsecase(userRepositoryImpl)

    fun provideUserRepository(): UserRepository = userRepositoryImpl
    fun provideUpdateUseCase(): UpdateUsecase = updateUsecase
}