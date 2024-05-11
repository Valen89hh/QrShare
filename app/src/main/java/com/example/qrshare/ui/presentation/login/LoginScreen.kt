package com.example.qrshare.ui.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.qrshare.ui.components.buttons.ButtonPrimary
import com.example.qrshare.ui.components.containers.ContainerImage
import com.example.qrshare.ui.components.inputs.TextInput

@Composable
fun LoginScreen(mode: String, viewModel: LoginViewModel, onNavToQr: ()-> Unit) {

    ContainerImage {
        Column(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomStart),
            verticalArrangement = Arrangement.spacedBy(60.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TextInput(
                    value = viewModel.email,
                    onValueChange = { viewModel.updateEmail(it)},
                    type = KeyboardType.Email,
                    placeHolder = "E-mail"
                )
                TextInput(
                    value = viewModel.password,
                    onValueChange = { viewModel.updatePassword(it)},
                    type = KeyboardType.Password,
                    placeHolder = "Contraseña",
                    visualTransformation = PasswordVisualTransformation()
                )
            }
            ButtonPrimary(text = if(mode == "register") "Registro" else "Iniciar", modifier = Modifier.fillMaxWidth()) {
                onNavToQr()
            }
        }
        
    }
}