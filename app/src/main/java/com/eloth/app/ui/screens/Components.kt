package com.eloth.app.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eloth.app.ui.theme.ElothRed
import com.eloth.app.ui.theme.ElothRedDark
import com.eloth.app.ui.theme.ElothYellow

@Composable
fun NesButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    val offsetY by animateDpAsState(
        targetValue = if (isPressed) 6.dp else 0.dp,
        animationSpec = tween(durationMillis = 100),
        label = "button_offset"
    )
    
    val shadowHeight by animateDpAsState(
        targetValue = if (isPressed) 2.dp else 8.dp,
        animationSpec = tween(durationMillis = 100),
        label = "button_shadow"
    )
    
    Box(
        modifier = modifier
            .offset(y = offsetY),
        contentAlignment = Alignment.Center
    ) {
        // Shadow
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(y = shadowHeight)
                .background(
                    color = ElothRedDark,
                    shape = RoundedCornerShape(12.dp)
                )
        )
        
        // Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = if (enabled) ElothRed else ElothRed.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(12.dp)
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    enabled = enabled,
                    onClick = onClick
                )
                .padding(horizontal = 32.dp, vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = ElothYellow,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}
