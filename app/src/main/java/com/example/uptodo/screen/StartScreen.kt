package com.example.uptodo.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StartScreen(){
    Scaffold(
        containerColor = Color(color = 0xFF121212)
    ) { innerPaading ->
        Column(
            modifier = Modifier.fillMaxWidth().systemBarsPadding()
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White)
            }
            Spacer(modifier = Modifier.size(58.dp))

           Column(
               modifier = Modifier.weight(1f).padding(24.dp)
           ) {
               Text(
                   "Welcome to Uptodo!",
                   modifier = Modifier.fillMaxWidth(),
                   color = Color.White,
                   textAlign = TextAlign.Center,
                   fontSize = 32.sp,
                   fontWeight = FontWeight.Bold,
               )

               Spacer(modifier = Modifier.size(26.dp))


               Text(
                   "Please login to account or create a new account to continue",
                   modifier = Modifier.fillMaxWidth(),
                   color = Color.White.copy(0.67F),
                   textAlign = TextAlign.Center,
                   fontSize = 16.sp,
                   fontWeight = FontWeight.Normal,
               )
           }

            Column(modifier = Modifier.padding(24.dp)) {
                Button(onClick = {},
                    modifier = Modifier.fillMaxWidth().height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF8875FF)
                    ),
                    shape = RoundedCornerShape(4.dp)
                    ){
                    Text("Login")
                }
                Spacer(modifier = Modifier.size(28.dp))
                Button(onClick = {},
                    modifier = Modifier.fillMaxWidth().height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    border = BorderStroke(2.dp, Color(0xFF8875FF)),
                    shape = RoundedCornerShape(4.dp)
                ){
                    Text("CREATE ACCOUNT")
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview(){
    StartScreen()
}
