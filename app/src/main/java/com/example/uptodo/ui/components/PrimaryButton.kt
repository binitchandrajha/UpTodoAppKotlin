package com.example.uptodo.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uptodo.ui.theme.PrimaryButton
import com.example.uptodo.ui.theme.PrimaryButtonDisabled
import com.example.uptodo.ui.theme.PrimaryButtonDisabledText

@Composable
fun  PrimaryButton(
    title: String,
    onClick: () -> Unit,
    enabled: Boolean
){
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(48.dp),
        shape = RoundedCornerShape(4.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = PrimaryButtonDisabled,
            disabledContentColor = PrimaryButtonDisabledText,
            containerColor = PrimaryButton,
            contentColor = Color.White,
        )
        ) {
        Text(title)
    }
}


@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview(){
    PrimaryButton(
        title = "Login",
        onClick = {},
        enabled = true
    )
}