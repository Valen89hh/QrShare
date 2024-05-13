package com.example.qrshare.ui.components.containers

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope

@Composable
inline fun ContainerConstraint(
    modifier: Modifier = Modifier,
    crossinline content: @Composable() (ConstraintLayoutScope.() -> Unit)
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        ConstraintLayout(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize(),
            content = content
        )
    }
}