package com.example.qrshare.ui.presentation.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Dimension
import com.example.qrshare.R
import com.example.qrshare.ui.components.buttons.ButtonPrimary
import com.example.qrshare.ui.components.containers.Container
import com.example.qrshare.ui.components.containers.ContainerConstraint
import com.example.qrshare.ui.components.containers.ContainerImage

@Composable
fun OnBoardingScreen(onNavTo: ()->Unit) {
    ContainerImage {
        ButtonPrimary(
            text = "Inciar", modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth(),
            onClick = onNavTo
        )
    }
}