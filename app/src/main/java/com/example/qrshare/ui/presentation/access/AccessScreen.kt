package com.example.qrshare.ui.presentation.access

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qrshare.ui.components.buttons.ButtonPrimary
import com.example.qrshare.ui.components.containers.ContainerImage
import com.example.qrshare.ui.theme.Orange

@Composable
fun AccessScreen(onNavToLogin: (param: String)->Unit) {
    ContainerImage {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ButtonPrimary(
                modifier = Modifier.weight(1f), // Puedes ajustar el peso aquí
                text = "Acceder"
            ) {
                onNavToLogin("access")
            }
            Spacer(modifier = Modifier.width(16.dp)) // Añade un espacio entre los botones
            ButtonPrimary(
                modifier = Modifier.weight(1f), // Puedes ajustar el peso aquí
                text = "Registro"
            ) {
                onNavToLogin("register")
            }
        }

    }
}