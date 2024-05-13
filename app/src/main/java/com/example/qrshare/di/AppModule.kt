package com.example.qrshare.di

import com.example.qrshare.data.AuthRepositoryImpl
import com.example.qrshare.domain.repository.AuthRepository
import com.example.qrshare.domain.usecase.AuthUseCase
import com.example.qrshare.domain.usecase.GetCurrentUser
import com.example.qrshare.domain.usecase.LoginUseCase
import com.example.qrshare.domain.usecase.Logout
import com.example.qrshare.domain.usecase.RegisterUserCase
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    fun providesAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun providesAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        getCurrentUser = GetCurrentUser(authRepository),
        loginUseCase = LoginUseCase(authRepository),
        registerUserCase = RegisterUserCase(authRepository),
        logout = Logout(authRepository)
    )
}