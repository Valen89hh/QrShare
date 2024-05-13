package com.example.qrshare.domain.repository

import com.example.qrshare.domain.model.DataResponse
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser: FirebaseUser?

    suspend fun login(email: String, password: String): DataResponse<FirebaseUser>

    suspend fun register(email: String, password: String): DataResponse<FirebaseUser>

    fun logout()
}