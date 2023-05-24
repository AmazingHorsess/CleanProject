package com.amazinghorsess.utils.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.amazinghorsess.R

val ItterTypography =  FontFamily(
    Font(R.font.interregualr, FontWeight.Normal)
)
val segoeUi = FontFamily(
    Font(R.font.segoui)
)
val segoeUiBold = FontFamily(
    Font(R.font.segoebold)
)



// Set of Material typography styles to start with
val Typography = Typography(
    h2 = TextStyle(
        fontFamily = segoeUiBold,
        fontSize = 40.sp

    ),
    h1 = TextStyle(
        fontFamily = segoeUi,
        fontSize = 20.sp

    ),
    body1 = TextStyle(
        fontFamily = segoeUiBold,
        fontSize = 20.sp

    ),
    body2 = TextStyle(
        fontFamily = segoeUi,
        fontSize = 14.sp

    ),



    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)