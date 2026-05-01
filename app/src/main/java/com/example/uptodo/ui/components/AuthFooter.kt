package com.example.uptodo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AuthFooter(
    title: String = "Don't have an account?",
    actionText: String,
    onClick: () -> Unit = {}
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            color = Color.White.copy(alpha = 0.8f)
        )
        Text(
            text = actionText,
            color = Color.White,
            modifier = Modifier.padding(start = 4.dp).clickable(enabled = true, onClick = onClick),
        )
    }
}

@Preview
@Composable
fun AuthFooterPreview(){
    AuthFooter(
        actionText = "Register"
    )
}

