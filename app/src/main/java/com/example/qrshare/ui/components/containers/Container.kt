package com.example.qrshare.ui.components.containers

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun Container(modifier: Modifier = Modifier, content: @Composable() (BoxScope.()-> Unit)) {
    val systemUiController = rememberSystemUiController()


    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.White,
            darkIcons = true
        )
    }

    Scaffold {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 16.dp),
            content = content
        )
    }


}