package com.example.uptodo.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uptodo.R
import com.example.uptodo.ui.theme.Violet500

@Composable
fun OutlineButton(
    borderWidth: Dp = 1.dp,
    borderRadius: Dp = 4.dp,
    borderColor: Color = Violet500,
    @DrawableRes icon: Int? = null,
    height: Dp = 48.dp,
    title: String,
    iconTitleSpacing: Dp = 10.dp,
    titleFontSize: TextUnit = 16.sp,
    titleFontWeight: FontWeight = FontWeight.Normal,
    titleFontColor: Color = Color.White
){
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth().height(height),
        shape = RoundedCornerShape(borderRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(
            width = borderWidth,
            color = borderColor
        )
    ) {
        if (icon != null){
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(iconTitleSpacing))
        }

        Text(text = title,
              fontSize = titleFontSize,
            fontWeight = titleFontWeight,
            color = titleFontColor
            )
    }
}

@Preview
@Composable
fun OutlineButtonPreview(){
    OutlineButton(
        icon = R.drawable.google,
        title = "Login with Google"

    )
}