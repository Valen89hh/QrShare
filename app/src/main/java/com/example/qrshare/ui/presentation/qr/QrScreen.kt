package com.example.qrshare.ui.presentation.qr

import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import android.Manifest
import android.graphics.Bitmap
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.qrshare.R
import com.example.qrshare.ui.components.buttons.ButtonSecondary
import com.example.qrshare.ui.components.containers.Container
import com.example.qrshare.ui.components.qr.rememberQrBitmapPainter
import com.example.qrshare.ui.theme.Gray40
import com.example.qrshare.ui.theme.Orange
import com.example.qrshare.utils.BitmapUtils
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.journeyapps.barcodescanner.ScanContract

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun QrScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val storagePermissionState = rememberPermissionState(permission = Manifest.permission.WRITE_EXTERNAL_STORAGE)
    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }
    
    val scanLauncher = rememberLauncherForActivityResult(contract = ScanContract) {
        
    }
    
    
    LaunchedEffect(Unit) {
        if(!storagePermissionState.status.isGranted){
            storagePermissionState.launchPermissionRequest()
        }
        else if (storagePermissionState.status.shouldShowRationale){
            Toast.makeText(context, "No se han otorgado permisos", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Permisos otorgados", Toast.LENGTH_SHORT).show()
        }
    }

    Container {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TopBar()

            Image(
                painter = rememberQrBitmapPainter("https://dev.to", onChangeBitmap = { bitmap = it}),
                contentDescription = "DEV Communit Code",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally),
            )
            ButtonSecondary(
                text = "Compartir",
                modifier = Modifier.fillMaxWidth()
            ) {
                if(bitmap != null){
                    val qrUri = BitmapUtils.getImageUri(context, bitmap!!)
                    if (qrUri != null){
                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_STREAM, qrUri)
                            type = "image/jpg"
                            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                        }
                        context.startActivity(Intent.createChooser(sendIntent, null))
                    }else{
                        Toast.makeText(context,"Upps, ocurrio un error intenta más tarde", Toast.LENGTH_LONG).show()
                    }

                }

            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp),
                    border = BorderStroke(1.dp, Color.White)
                ) {
                    Text(text = "Generar")
                }
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { /*TODO*/ },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White
                    ),
                    border = BorderStroke(1.dp, Color.White)

                ) {
                    Text(text = "Lector")
                }
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
                    border = BorderStroke(1.dp, Color.White)

                ) {
                    Text(text = "Registro")
                }
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