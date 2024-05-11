package com.example.qrshare.ui.presentation.qr

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.qrshare.R
import com.example.qrshare.ui.components.buttons.ButtonSecondary
import com.example.qrshare.ui.components.containers.Container
import com.example.qrshare.ui.components.qr.rememberQrBitmapPainter
import com.example.qrshare.ui.theme.Gray40
import com.example.qrshare.ui.theme.Orange

@Composable
fun QrScreen(modifier: Modifier = Modifier) {
    Container {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TopBar()

            Image(
                painter = rememberQrBitmapPainter("https://dev.to"),
                contentDescription = "DEV Communit Code",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(250.dp)
                    .align(Alignment.CenterHorizontally),
            )
            ButtonSecondary(
                text = "Compartir",
                modifier = Modifier.fillMaxWidth()
            ) {

            }
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Gray40,
                shape = RectangleShape
            )
            .padding(all = 16.dp)
        ,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painterResource(R.drawable.ic_arrow_back),
            contentDescription = null,
            tint = Orange,
            modifier = Modifier
                .clickable {

                }
        )

        Text(
            text = "ACCESS & PARKING",
            style = MaterialTheme.typography.titleMedium,
            color = Orange,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}