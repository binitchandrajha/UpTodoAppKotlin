package com.example.uptodo.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.uptodo.R

@Composable
fun SocialLoginButton(
    @DrawableRes icon: Int,
    title: String,
    onClick: () -> Unit
){
    OutlineButton(
        icon = icon,
        title = title,
        onClick = onClick
    )
}

@Preview
@Composable
fun SocialLoginButtonPreview(){
    SocialLoginButton(
        icon = R.drawable.google,
        title = "Login with Google",
        onClick = {}
    )
}
