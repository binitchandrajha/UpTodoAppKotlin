package com.example.uptodo.screen

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RegisterScreen(){
    Scaffold(
        modifier = Modifier.systemBarsPadding()
    ) { innerPadding ->
        Text("Register Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen(){
    RegisterScreen()
}