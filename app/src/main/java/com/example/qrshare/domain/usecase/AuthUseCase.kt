package com.example.qrshare.domain.usecase

data class AuthUseCase(
    val getCurrentUser: GetCurrentUser,
    val loginUseCase: LoginUseCase,
    val registerUserCase: RegisterUserCase,
    val logout: Logout
)
