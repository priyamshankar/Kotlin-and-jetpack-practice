package com.example.jlrsignin.di

import com.example.jlrsignin.data.repository.userRepositoryImpl
import com.example.jlrsignin.domain.usecase.UpdateUsecase
import com.example.jlrsignin.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//object DependencyProvider {
//    private val userRepositoryImpl = userRepositoryImpl()
//    private val updateUsecase = UpdateUsecase(userRepositoryImpl)
//
//    fun provideUserRepository(): UserRepository = userRepositoryImpl
//    fun provideUpdateUseCase(): UpdateUsecase = updateUsecase
//}

@Module
@InstallIn(SingletonComponent::class)
object DependencyProvider {

    @Provides
    fun provideUserRepoImpl():userRepositoryImpl = userRepositoryImpl()

    @Provides
    fun provideUserRepository(userRepositoryImpl: userRepositoryImpl): UserRepository {
        return userRepositoryImpl
    }
//    @Singleton
    @Provides
    fun provideUpdateUseCase(userRepository: UserRepository): UpdateUsecase {
        return UpdateUsecase(userRepository)
    }
}