package com.example.uptodo.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uptodo.R
import com.example.uptodo.ui.components.AppHeader
import com.example.uptodo.ui.components.AuthFooter
import com.example.uptodo.ui.components.CustomTextField
import com.example.uptodo.ui.components.Divider
import com.example.uptodo.ui.components.PrimaryButton
import com.example.uptodo.ui.components.SocialLoginButton
import com.example.uptodo.ui.theme.AppBackground

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Scaffold(
        containerColor = AppBackground
    ) { innerPadding ->
        Column(
          modifier = Modifier.systemBarsPadding().fillMaxWidth()
        ) {
            AppHeader(

            )
            Column(
                modifier = Modifier.padding(horizontal = 24.dp).fillMaxWidth().weight(1f)
            ) {
                Spacer(modifier = Modifier.size(40.dp))
                Text(
                    "Login Screen",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.size((50.dp)))
                CustomTextField(
                    value = username,
                    onValueChange = {username = it},
                    label = "Username",
                    placeholder = "Enter your username"
                )
                Spacer(modifier = Modifier.size(24.dp))
                CustomTextField(
                    value = password,
                    onValueChange = {password = it},
                    label = "Password",
                    placeholder = "Enter your password",
                    isPassword = true
                )
                Spacer(modifier = Modifier.size(70.dp))

                PrimaryButton(
                    title = "Login",
                    onClick = {
                      onLoginClick()
                    },
                    enabled = if (username.isNotEmpty() && password.isNotEmpty()) true else false
                )

                Spacer(modifier = Modifier.size(45.dp))

                Divider()

                Spacer(modifier = Modifier.size(39.dp))

                SocialLoginButton(
                    icon = R.drawable.google,
                    title = "Login with Google"
                )

                Spacer(modifier = Modifier.size(20.dp))

                SocialLoginButton(
                    icon = R.drawable.apple,
                    title = "Login with Apple"
                )

                Spacer(modifier = Modifier.size(46.dp))
            }
            AuthFooter(
                title = "Don't have an account?",
                actionText = "Register",
                onClick = {
                    onRegisterClick()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen(
        onLoginClick = {},
        onRegisterClick = {}
    )
}