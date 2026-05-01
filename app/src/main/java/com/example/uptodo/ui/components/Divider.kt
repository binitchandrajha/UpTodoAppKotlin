package com.example.uptodo.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uptodo.ui.theme.GrayColor

@Composable
fun Divider(
    oneDivider: Boolean = false
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
      HorizontalDividerLine(
          modifier = Modifier.weight(1f)
      )
        if (!oneDivider){
            Text(
                text = "Or",
                color = GrayColor,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
            HorizontalDividerLine(
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DividerPreview(){
    Divider()
}