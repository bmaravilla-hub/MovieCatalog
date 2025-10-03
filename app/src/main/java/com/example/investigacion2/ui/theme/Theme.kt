package com.example.investigacion2.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val PinkColorScheme = lightColorScheme(
    primary = Pink500,
    secondary = Pink200,
    tertiary = Pink100,
    background = Pink50,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Composable
fun Investigacion2Theme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = PinkColorScheme,
        typography = Typography,
        content = content
    )
}