package com.eloth.app.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eloth.app.ui.theme.Black
import com.eloth.app.ui.theme.ElothYellow
import com.eloth.app.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun BootScreen(
    onNavigateToMenu: () -> Unit,
    onNavigateBack: () -> Unit
) {
    var showButton by remember { mutableStateOf(false) }
    var titleOffset by remember { mutableStateOf(-250.dp) }
    var titleAlpha by remember { mutableFloatStateOf(0f) }
    var buttonAlpha by remember { mutableFloatStateOf(0f) }
    
    val animatedOffset by animateDpAsState(
        targetValue = titleOffset,
        animationSpec = tween(durationMillis = 5600, easing = LinearEasing),
        label = "title_animation"
    )
    
    val animatedTitleAlpha by animateFloatAsState(
        targetValue = titleAlpha,
        animationSpec = tween(durationMillis = 500),
        label = "title_alpha"
    )
    
    val animatedButtonAlpha by animateFloatAsState(
        targetValue = buttonAlpha,
        animationSpec = tween(durationMillis = 500),
        label = "button_alpha"
    )
    
    LaunchedEffect(Unit) {
        // Start animation
        delay(100)
        titleAlpha = 1f
        titleOffset = 0.dp
        
        // Show button after animation
        delay(5600)
        showButton = true
        buttonAlpha = 1f
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
        contentAlignment = Alignment.Center
    ) {
        StarfieldBackground()
        
        // Back button
        if (showButton) {
            BackButton(
                onClick = onNavigateBack,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
                    .alpha(animatedButtonAlpha)
            )
        }
        
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.offset(y = animatedOffset)
        ) {
            Text(
                text = "ELOTH",
                fontSize = 72.sp,
                fontWeight = FontWeight.Bold,
                color = White,
                modifier = Modifier
                    .alpha(animatedTitleAlpha)
                    .shadow(
                        elevation = 10.dp,
                        spotColor = ElothYellow
                    )
            )
            
            if (showButton) {
                Spacer(modifier = Modifier.height(32.dp))
                
                NesButton(
                    text = "Commencer !",
                    onClick = onNavigateToMenu,
                    modifier = Modifier
                        .width(250.dp)
                        .height(70.dp)
                        .alpha(animatedButtonAlpha)
                )
            }
        }
    }
}

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    androidx.compose.material3.IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = "<",
            fontSize = 32.sp,
            color = ElothYellow,
            fontWeight = FontWeight.Bold
        )
    }
}
