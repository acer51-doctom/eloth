package com.eloth.app.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eloth.app.ui.theme.Black
import com.eloth.app.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun MenuScreen(
    onNavigateToMoloch: () -> Unit,
    onNavigateToCharacter: () -> Unit,
    onNavigateBack: () -> Unit
) {
    var showContent by remember { mutableStateOf(false) }
    var contentAlpha by remember { mutableFloatStateOf(0f) }
    
    val animatedAlpha by animateFloatAsState(
        targetValue = contentAlpha,
        animationSpec = tween(durationMillis = 500),
        label = "menu_alpha"
    )
    
    LaunchedEffect(Unit) {
        delay(100)
        showContent = true
        contentAlpha = 1f
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        BackButton(
            onClick = onNavigateBack,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
                .alpha(animatedAlpha)
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .alpha(animatedAlpha),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Que souhaitez-vous faire ?",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
            
            Spacer(modifier = Modifier.height(48.dp))
            
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 32.dp)
            ) {
                NesButton(
                    text = "Bâton de Moloch",
                    onClick = onNavigateToMoloch,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                )
                
                NesButton(
                    text = "Créer son personnage",
                    onClick = onNavigateToCharacter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                )
            }
        }
    }
}
