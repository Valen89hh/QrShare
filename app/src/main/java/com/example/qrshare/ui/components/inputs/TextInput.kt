package com.example.qrshare.ui.components.inputs

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.qrshare.ui.theme.OrangeAlpha50

@Composable
fun TextInput(
    value: String,
    onValueChange: (value: String)-> Unit,
    type: KeyboardType,
    placeHolder: String,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(12.dp)
            ),
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeHolder, style = MaterialTheme.typography.bodyMedium)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = type
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = OrangeAlpha50,
            unfocusedContainerColor = OrangeAlpha50,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.White
        ),
        textStyle = MaterialTheme.typography.bodyLarge,
        visualTransformation = visualTransformation,
        maxLines = 1,
    )
}