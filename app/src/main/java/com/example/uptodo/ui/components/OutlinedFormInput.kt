package com.example.uptodo.ui.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.uptodo.ui.theme.TextSecondary


@Composable
fun OutlinedFormInput(
    value: String = "",
    onValueChange: (String) -> Unit = {},
    label: String = "",
    placeholder: String = "",
    style: TextStyle = TextStyle.Default
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        textStyle = style,
        placeholder = {Text(placeholder)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.White.copy(alpha = 0.5f),
            unfocusedPlaceholderColor = TextSecondary
        )
    )
}

@Preview(showBackground = true)
@Composable
fun OutlinedFormInputPreview(){
    OutlinedFormInput()
}