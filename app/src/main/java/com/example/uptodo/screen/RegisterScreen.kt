package com.example.uptodo.screen

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.uptodo.ui.components.AppHeader
import com.example.uptodo.ui.components.AuthFooter
import com.example.uptodo.ui.components.CustomTextField
import com.example.uptodo.ui.components.PrimaryButton
import com.example.uptodo.ui.theme.AppBackground

@Composable
fun RegisterScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var profilePic by remember { mutableStateOf(value = "") }

    val pickMedia = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        // Callback is invoked after the user selects a media item or closes the
        // photo picker.
        if (uri != null) {
            Log.d("PhotoPicker", "Selected URI: $uri")
            // You can use the Uri object instead of the string
            profilePic = uri.toString()
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

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
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    "Register Screen",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.size((23.dp)))
                Box(
                    modifier = Modifier.size(100.dp).clip(CircleShape)
                        .align(Alignment.CenterHorizontally).border(1.dp, Color.White, CircleShape)
                        .clickable(onClick = { pickMedia.launch(PickVisualMediaRequest(
                            ActivityResultContracts.PickVisualMedia.ImageOnly)) }),
                    contentAlignment = Alignment.Center,
                ){
                    if (profilePic.isEmpty()){
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(50.dp)
                        )
                    } else {
                        AsyncImage(
                            model = profilePic,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
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
                Spacer(modifier = Modifier.size(24.dp))
                CustomTextField(
                    value = confirmPassword,
                    onValueChange = {confirmPassword = it},
                    label = "Confirm Password",
                    placeholder = "Enter your confirm password",
                    isPassword = true
                )
                Spacer(modifier = Modifier.size(70.dp))

                PrimaryButton(
                    title = "Register",
                    onClick = {onRegisterClick()},
                    enabled = username.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && profilePic != ""
                )

                Spacer(modifier = Modifier.size(45.dp))
            }
            AuthFooter(
                title = "Already have an account?",
                actionText = "Login",
                onClick = {onLoginClick()}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen(){
    RegisterScreen(
        onLoginClick = {},
    ) {}
}