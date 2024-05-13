package com.example.qrshare.data

import android.provider.ContactsContract.Data
import com.example.qrshare.domain.model.DataResponse
import com.example.qrshare.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.resumeWithException

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {
    override val currentUser: FirebaseUser?
        get() {
            return auth.currentUser
        }

    override suspend fun login(email: String, password: String): DataResponse<FirebaseUser> {
        return try {
            val res = auth.signInWithEmailAndPassword(email, password).await()
            DataResponse.Success(res.user!!)
        }catch (e: Exception){
            DataResponse.Error(e)
        }
    }

    override suspend fun register(email: String, password: String): DataResponse<FirebaseUser> {
        return try {
            val res = auth.createUserWithEmailAndPassword(email, password).await()
            DataResponse.Success(res.user!!)
        }catch (e: Exception){
            DataResponse.Error(e)
        }
    }

    override fun logout() {
        auth.signOut()
    }
}