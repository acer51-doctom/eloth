package com.eloth.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = ElothYellow,
    secondary = ElothRed,
    tertiary = ElothRedDark,
    background = Black,
    surface = DarkGray,
    onPrimary = Black,
    onSecondary = ElothYellow,
    onTertiary = White,
    onBackground = White,
    onSurface = White,
)

@Composable
fun ElothTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
