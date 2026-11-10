package org.nsh07.pomodoro.ui

import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.drawOutline
import androidx.compose.ui.unit.dp

/**
 * Dependency-free "liquid glass" look: a soft top-down sheen over the (already translucent)
 * container, plus a specular edge that is bright at the top-left and bottom-right corners.
 */
fun Modifier.liquidGlass(shape: Shape): Modifier = this
    .drawWithContent {
        drawContent()
        drawOutline(
            outline = shape.createOutline(size, layoutDirection, this),
            brush = Brush.verticalGradient(
                0f to Color.White.copy(alpha = 0.28f),
                0.5f to Color.Transparent,
                1f to Color.White.copy(alpha = 0.10f)
            )
        )
    }
    .border(
        width = 1.dp,
        brush = Brush.linearGradient(
            colors = listOf(
                Color.White.copy(alpha = 0.85f),
                Color.White.copy(alpha = 0.10f),
                Color.White.copy(alpha = 0.10f),
                Color.White.copy(alpha = 0.55f)
            ),
            start = Offset.Zero,
            end = Offset.Infinite
        ),
        shape = shape
    )
