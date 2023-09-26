package com.huda.palestine.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.huda.palestine.R

val Quicksand = FontFamily(
    Font(R.font.quicksand_regular, FontWeight.Normal), Font(R.font.quicksand_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Quicksand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ), displayLarge = TextStyle(
        fontFamily = Quicksand, fontWeight = FontWeight.Normal, fontSize = 30.sp
    ), displayMedium = TextStyle(
        fontFamily = Quicksand, fontWeight = FontWeight.Bold, fontSize = 20.sp
    ), displaySmall = TextStyle(
        fontFamily = Quicksand, fontWeight = FontWeight.Bold, fontSize = 20.sp
    )
)