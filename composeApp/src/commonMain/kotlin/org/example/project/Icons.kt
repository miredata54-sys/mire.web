package org.example.project

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import org.jetbrains.compose.resources.painterResource
import mire_data_app.composeapp.generated.resources.Res
import mire_data_app.composeapp.generated.resources.coat_of_arms_of_somalia_1__1_

@Composable
fun PersonIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                // Head (circle)
                addOval(androidx.compose.ui.geometry.Rect(
                    center.x - 6.dp.toPx(),
                    center.y - 10.dp.toPx(),
                    center.x + 6.dp.toPx(),
                    center.y - 2.dp.toPx()
                ))
                // Body (trapezoid/shoulders)
                moveTo(center.x - 8.dp.toPx(), center.y)
                lineTo(center.x + 8.dp.toPx(), center.y)
                lineTo(center.x + 6.dp.toPx(), center.y + 8.dp.toPx())
                lineTo(center.x - 6.dp.toPx(), center.y + 8.dp.toPx())
                close()
            }
            drawPath(
                path = path,
                color = Color(0xFF555555),
                style = Stroke(width = 2.dp.toPx())
            )
        }
    }
}

@Composable
fun PadlockIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                // Lock body (rounded rectangle)
                moveTo(center.x - 6.dp.toPx(), center.y - 2.dp.toPx())
                lineTo(center.x + 6.dp.toPx(), center.y - 2.dp.toPx())
                lineTo(center.x + 6.dp.toPx(), center.y + 6.dp.toPx())
                lineTo(center.x - 6.dp.toPx(), center.y + 6.dp.toPx())
                close()
                // Lock shackle (U-shape)
                moveTo(center.x - 6.dp.toPx(), center.y - 2.dp.toPx())
                arcTo(
                    rect = androidx.compose.ui.geometry.Rect(
                        center.x - 6.dp.toPx(),
                        center.y - 8.dp.toPx(),
                        center.x + 6.dp.toPx(),
                        center.y - 2.dp.toPx()
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = false
                )
            }
            drawPath(
                path = path,
                color = Color(0xFF555555),
                style = Stroke(width = 2.dp.toPx())
            )
        }
    }
}

@Composable
fun EducationIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(100.dp)

            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.coat_of_arms_of_somalia_1__1_),
            contentDescription = "Coat of arms of Somalia",
            modifier = Modifier.size(70.dp)
        )
    }
}

@Composable
fun SchoolIcon(modifier: Modifier = Modifier, color: Color = Color(0xFFFFB6C1)) {
    Box(
        modifier = modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                // Building base
                moveTo(center.x - 12.dp.toPx(), center.y + 4.dp.toPx())
                lineTo(center.x + 12.dp.toPx(), center.y + 4.dp.toPx())
                lineTo(center.x + 12.dp.toPx(), center.y - 8.dp.toPx())
                lineTo(center.x - 12.dp.toPx(), center.y - 8.dp.toPx())
                close()
                // Roof
                moveTo(center.x - 12.dp.toPx(), center.y - 8.dp.toPx())
                lineTo(center.x, center.y - 16.dp.toPx())
                lineTo(center.x + 12.dp.toPx(), center.y - 8.dp.toPx())
                close()
                // Chimney
                moveTo(center.x + 6.dp.toPx(), center.y - 12.dp.toPx())
                lineTo(center.x + 10.dp.toPx(), center.y - 12.dp.toPx())
                lineTo(center.x + 10.dp.toPx(), center.y - 18.dp.toPx())
                lineTo(center.x + 6.dp.toPx(), center.y - 18.dp.toPx())
                close()
            }
            drawPath(
                path = path,
                color = color,
                style = Stroke(width = 2.5.dp.toPx())
            )
        }
    }
}

@Composable
fun GraduationCapIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF6B46C1)) {
    Box(
        modifier = modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                // Cap base
                moveTo(center.x - 12.dp.toPx(), center.y - 2.dp.toPx())
                lineTo(center.x + 12.dp.toPx(), center.y - 2.dp.toPx())
                lineTo(center.x + 10.dp.toPx(), center.y + 6.dp.toPx())
                lineTo(center.x - 10.dp.toPx(), center.y + 6.dp.toPx())
                close()
                // Top of cap
                moveTo(center.x - 12.dp.toPx(), center.y - 2.dp.toPx())
                arcTo(
                    rect = androidx.compose.ui.geometry.Rect(
                        center.x - 12.dp.toPx(),
                        center.y - 10.dp.toPx(),
                        center.x + 12.dp.toPx(),
                        center.y + 2.dp.toPx()
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = false
                )
                // Tassel
                moveTo(center.x + 10.dp.toPx(), center.y)
                lineTo(center.x + 16.dp.toPx(), center.y + 4.dp.toPx())
            }
            drawPath(
                path = path,
                color = color,
                style = Stroke(width = 2.5.dp.toPx())
            )
        }
    }
}

@Composable
fun TeachersIcon(modifier: Modifier = Modifier, color: Color = Color(0xFFFFD700)) {
    Box(
        modifier = modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Draw three small figures
            val figureWidth = 6.dp.toPx()
            val spacing = 4.dp.toPx()
            val startX = center.x - figureWidth - spacing
            
            for (i in 0..2) {
                val x = startX + i * (figureWidth + spacing)
                val path = Path().apply {
                    // Head
                    addOval(androidx.compose.ui.geometry.Rect(
                        x - 2.dp.toPx(),
                        center.y - 6.dp.toPx(),
                        x + 2.dp.toPx(),
                        center.y - 2.dp.toPx()
                    ))
                    // Body
                    moveTo(x - 3.dp.toPx(), center.y - 2.dp.toPx())
                    lineTo(x + 3.dp.toPx(), center.y - 2.dp.toPx())
                    lineTo(x + 2.dp.toPx(), center.y + 4.dp.toPx())
                    lineTo(x - 2.dp.toPx(), center.y + 4.dp.toPx())
                    close()
                }
                drawPath(
                    path = path,
                    color = color,
                    style = Stroke(width = 1.5.dp.toPx())
                )
            }
        }
    }
}

@Composable
fun ParentsIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF22C55E)) {
    Box(
        modifier = modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Draw two figures
            val figureWidth = 8.dp.toPx()
            val spacing = 4.dp.toPx()
            val startX = center.x - figureWidth / 2 - spacing / 2
            
            for (i in 0..1) {
                val x = startX + i * (figureWidth + spacing)
                val path = Path().apply {
                    // Head
                    addOval(androidx.compose.ui.geometry.Rect(
                        x - 3.dp.toPx(),
                        center.y - 6.dp.toPx(),
                        x + 3.dp.toPx(),
                        center.y - 1.dp.toPx()
                    ))
                    // Body
                    moveTo(x - 4.dp.toPx(), center.y - 1.dp.toPx())
                    lineTo(x + 4.dp.toPx(), center.y - 1.dp.toPx())
                    lineTo(x + 3.dp.toPx(), center.y + 6.dp.toPx())
                    lineTo(x - 3.dp.toPx(), center.y + 6.dp.toPx())
                    close()
                }
                drawPath(
                    path = path,
                    color = color,
                    style = Stroke(width = 2.dp.toPx())
                )
            }
        }
    }
}

@Composable
fun SearchIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF6B46C1)) {
    Box(
        modifier = modifier.size(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                // Circle
                addOval(androidx.compose.ui.geometry.Rect(
                    center.x - 6.dp.toPx(),
                    center.y - 6.dp.toPx(),
                    center.x + 6.dp.toPx(),
                    center.y + 6.dp.toPx()
                ))
                // Handle
                moveTo(center.x + 4.dp.toPx(), center.y + 4.dp.toPx())
                lineTo(center.x + 8.dp.toPx(), center.y + 8.dp.toPx())
            }
            drawPath(
                path = path,
                color = color,
                style = Stroke(width = 2.dp.toPx())
            )
        }
    }
}

