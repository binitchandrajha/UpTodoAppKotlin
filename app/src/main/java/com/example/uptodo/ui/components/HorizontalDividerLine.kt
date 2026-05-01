package com.example.uptodo.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uptodo.ui.theme.Gray500

@Composable
fun HorizontalDividerLine(
    thickness: Dp = 1.dp,
    color: Color = Gray500,
    modifier: Modifier,
){
    HorizontalDivider(
        modifier = modifier,
        thickness = thickness,
        color = color
    )
}

@Preview
@Composable
fun HorizontalDividerLinePreview(){
    Row(modifier = Modifier.fillMaxWidth()){
        HorizontalDividerLine(
            thickness = 2.dp,
            color = Color.Red,
            modifier = Modifier.weight(1f)
        )
    }
}
