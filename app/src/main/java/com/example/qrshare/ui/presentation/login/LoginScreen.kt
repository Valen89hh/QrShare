package com.example.qrshare.ui.presentation.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.qrshare.domain.model.DataResponse
import com.example.qrshare.ui.components.buttons.ButtonPrimary
import com.example.qrshare.ui.components.containers.ContainerImage
import com.example.qrshare.ui.components.inputs.TextInput
import com.google.firebase.auth.FirebaseUser

@Composable
fun LoginScreen(mode: String, viewModel: LoginViewModel, onNavToQr: ()-> Unit) {
    val context = LocalContext.current
    ContainerImage {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart),
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
            ButtonPrimary(
                text = if(mode == "register") "Registro" else "Iniciar",
                modifier = Modifier.fillMaxWidth(),
                enable = viewModel.enable,
                loading = viewModel.stateLogin == DataResponse.Loading
            ) {
                if(mode == "register"){
                    viewModel.register()
                }
                else if (mode == "access"){
                    viewModel.login()

                }

            }
        }
        
    }

    when(viewModel.stateLogin){
        is DataResponse.Error -> Toast.makeText(context,
            (viewModel.stateLogin as DataResponse.Error<FirebaseUser>).e?.message.toString(), Toast.LENGTH_SHORT).show()
        DataResponse.Loading -> {}
        is DataResponse.Success -> {
            LaunchedEffect(Unit) {
                onNavToQr()
            }
        }
        null -> {}
    }
}