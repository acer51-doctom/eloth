package com.eloth.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eloth.app.ui.theme.Black

@Composable
fun SplashScreen(
    onNavigateToBoot: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
        contentAlignment = Alignment.Center
    ) {
        // Starfield background
        StarfieldBackground()
        
        // Start button
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            NesButton(
                text = "DÉMARRER",
                onClick = onNavigateToBoot,
                modifier = Modifier
                    .width(250.dp)
                    .height(70.dp)
            )
        }
    }
}
