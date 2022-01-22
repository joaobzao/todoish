package com.joaobzao.todoish.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Grey800,
    primaryVariant = Color.White,
    onPrimary = Color.White,
    onSurface = Grey800,
    secondary = Orange900,
    background = Black800
)

private val LightColorPalette = lightColors(
    primary = Grey800,
    primaryVariant = Grey800,
    onPrimary = Color.Black,
    onSurface = Color.White,
    secondary = Orange900,
    //background = Black800
)

@Composable
fun TodoishTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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