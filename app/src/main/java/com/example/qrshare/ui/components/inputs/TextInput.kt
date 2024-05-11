package com.example.qrshare.ui.components.inputs

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.example.qrshare.ui.theme.OrangeAlpha50

@Composable
fun TextInput(
    value: String,
    onValueChange: (value: String)-> Unit,
    type: KeyboardType,
    placeHolder: String,
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier,
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
            unfocusedContainerColor = OrangeAlpha50
        ),
        textStyle = MaterialTheme.typography.bodyLarge
    )
}