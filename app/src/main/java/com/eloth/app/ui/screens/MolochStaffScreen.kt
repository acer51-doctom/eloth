package com.eloth.app.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eloth.app.data.MolochEffects
import com.eloth.app.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun MolochStaffScreen(
    onNavigateBack: () -> Unit
) {
    var currentNumber by remember { mutableStateOf(0) }
    var finalNumber by remember { mutableStateOf(0) }
    var effectDescription by remember { mutableStateOf("") }
    var isRolling by remember { mutableStateOf(false) }
    var showEffect by remember { mutableStateOf(false) }
    var effectAlpha by remember { mutableFloatStateOf(0f) }

    val coroutineScope = rememberCoroutineScope()
    val numberColor = if (showEffect) ElothYellow else White
    
    val animatedEffectAlpha by animateFloatAsState(
        targetValue = effectAlpha,
        animationSpec = tween(durationMillis = 300),
        label = "effect_alpha"
    )
    
    suspend fun rollDice() {
        isRolling = true
        showEffect = false
        effectAlpha = 0f
        effectDescription = ""
        
        // Calculate final result
        finalNumber = Random.nextInt(1, 101)
        
        // Animation with progressive slowdown (20 steps, 4.5 seconds)
        val totalSteps = 20
        val totalDuration = 4500L
        
        for (step in 1..totalSteps) {
            // Show random number
            currentNumber = Random.nextInt(1, 101)
            
            // Calculate delay using exponential easing
            val progress = step.toFloat() / totalSteps
            val easedProgress = 1f - (1f - progress) * (1f - progress) * (1f - progress)
            val minInterval = 20L
            val maxInterval = totalDuration / (totalSteps * 0.5f)
            val delayTime = (minInterval + (maxInterval * easedProgress)).toLong()
            
            delay(delayTime)
        }
        
        // Show final result
        currentNumber = finalNumber
        effectDescription = MolochEffects.effects[finalNumber] ?: "Effet inconnu"
        
        delay(100)
        showEffect = true
        effectAlpha = 1f
        isRolling = false
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
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Title
            Text(
                text = "Bâton de Moloch",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = ElothYellow,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .shadow(
                        elevation = 10.dp,
                        spotColor = ElothYellow
                    )
            )
            
            // Number display
            Text(
                text = if (currentNumber == 0) "?" else currentNumber.toString(),
                fontSize = 96.sp,
                fontWeight = FontWeight.Bold,
                color = numberColor,
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .shadow(
                        elevation = if (showEffect) 10.dp else 0.dp,
                        spotColor = ElothYellow
                    )
            )
            
            // Roll button
            NesButton(
                text = "Lancer le dé",
                onClick = {
                    if (!isRolling) {
                        coroutineScope.launch {
                            rollDice()
                        }
                    }
                },
                enabled = !isRolling,
                modifier = Modifier
                    .width(250.dp)
                    .height(70.dp)
                    .padding(bottom = 48.dp)
            )
            
            // Effect description
            if (showEffect) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .border(2.dp, Gray700)
                        .background(Gray900)
                        .padding(24.dp)
                        .alpha(animatedEffectAlpha)
                ) {
                    Text(
                        text = effectDescription,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic,
                        color = White,
                        textAlign = TextAlign.Center,
                        lineHeight = 28.sp
                    )
                }
            } else if (isRolling) {
                Text(
                    text = "Lancement en cours...",
                    fontSize = 14.sp,
                    color = Gray400,
                    modifier = Modifier.alpha(0.7f)
                )
            } else {
                Text(
                    text = "Prêt à lancer le Bâton de Moloch!",
                    fontSize = 14.sp,
                    color = Gray400,
                    modifier = Modifier.alpha(0.7f)
                )
            }
        }
    }
}
