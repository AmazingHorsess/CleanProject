package com.amazinghorsess.utils.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    background = DarkSurfaceColor,
    primary = DarkObjectColor,
    primaryVariant = DarkDividerColor,
    secondary = LightSurfaceColor,
    surface = DarkSurfaceColor,
    onSurface = DarkDividerColor,
    secondaryVariant = DarkDividerColor
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = LightObjectColor,
    primaryVariant = LightDividerColor,
    secondary = Teal200,
    surface = LightSurfaceColor,
    onSurface = LightDividerColor,
    secondaryVariant = LightDividerColor

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CleanProjectTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}