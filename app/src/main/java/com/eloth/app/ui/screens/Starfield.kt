package com.eloth.app.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlin.random.Random

data class Star(
    var x: Float,
    var y: Float,
    val size: Float,
    val speed: Float
)

@Composable
fun StarfieldBackground(
    starCount: Int = 300
) {
    var stars by remember {
        mutableStateOf(List(starCount) {
            Star(
                x = Random.nextFloat(),
                y = Random.nextFloat(),
                size = Random.nextFloat() * 2f + 1f,
                speed = Random.nextFloat() * 0.5f + 0.5f
            )
        })
    }
    
    LaunchedEffect(Unit) {
        while (true) {
            delay(16) // ~60 FPS
            stars = stars.map { star ->
                var newY = star.y + (star.speed * 0.001f)
                if (newY > 1f) {
                    newY = 0f
                    star.x = Random.nextFloat()
                }
                star.copy(y = newY)
            }
        }
    }
    
    Canvas(modifier = Modifier.fillMaxSize()) {
        stars.forEach { star ->
            drawCircle(
                color = Color.White.copy(alpha = 0.7f),
                radius = star.size,
                center = Offset(
                    x = star.x * size.width,
                    y = star.y * size.height
                )
            )
        }
    }
}
