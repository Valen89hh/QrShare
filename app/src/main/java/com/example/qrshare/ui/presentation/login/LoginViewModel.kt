package com.example.qrshare.ui.presentation.login

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.qrshare.domain.model.DataResponse
import com.example.qrshare.domain.usecase.AuthUseCase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
): ViewModel() {
    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var emailValid by mutableStateOf(false)
        private set
    var passwordValid by mutableStateOf(false)
        private set

    var enable by mutableStateOf(false)
        private set

    val currentUser = authUseCase.getCurrentUser
    var stateLogin by mutableStateOf<DataResponse<FirebaseUser>?>(null)

    fun login()=viewModelScope.launch {
        stateLogin  = DataResponse.Loading
        stateLogin = authUseCase.loginUseCase(email, password)
    }

    fun register()=viewModelScope.launch {
        stateLogin = DataResponse.Loading
        stateLogin = authUseCase.registerUserCase(email, password)
    }

    fun updateEmail(input: String){
        email = input
        validateEmail()
    }
    fun updatePassword(input: String){
        password = input
        validatePassword()
    }

    fun validateEmail(){
        emailValid = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        validateButton()
    }

    fun validatePassword(){
        passwordValid = password.isNotEmpty() && password.length > 4
        validateButton()
    }

    fun validateButton(){
        enable = emailValid && passwordValid
    }
}