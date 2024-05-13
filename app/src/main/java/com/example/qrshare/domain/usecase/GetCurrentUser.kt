package com.example.qrshare.domain.usecase

import com.example.qrshare.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(
    private val authRepository: AuthRepository
) {

    operator fun invoke()=authRepository.currentUser
}