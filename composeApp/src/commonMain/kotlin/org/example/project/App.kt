package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.foundation.Canvas
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

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
@Preview
fun App() {
    MaterialTheme {
        LoginScreen()
    }
}

@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4A90E2), // Blue background
                        Color(0xFF357ABD)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // Subtle topographic pattern overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0x1AFFFFFF),
                            Color(0x0AFFFFFF),
                            Color.Transparent
                        ),
                        radius = 800f
                    )
                )
        )
        
        // Login card
        Column(
            modifier = Modifier
                .width(400.dp)
                .padding(32.dp)
                .shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Username field
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = {
                    Text(
                        text = "UserName",
                        color = Color.Gray.copy(alpha = 0.6f),
                        fontSize = 16.sp
                    )
                },
                trailingIcon = {
                    PersonIcon(modifier = Modifier.padding(end = 12.dp))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF5F5F5),
                    focusedContainerColor = Color(0xFFF5F5F5),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            
            // Password field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(
                        text = "Password",
                        color = Color.Gray.copy(alpha = 0.6f),
                        fontSize = 16.sp
                    )
                },
                trailingIcon = {
                    PadlockIcon(modifier = Modifier.padding(end = 12.dp))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF5F5F5),
                    focusedContainerColor = Color(0xFFF5F5F5),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            
            // Login button
            Button(
                onClick = { /* Handle login */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2C3E50) // Dark blue
                )
            ) {
                Text(
                    text = "Login",
                    color = Color(0xFFFFA500), // Yellow-orange
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            // Recover Password link
            TextButton(
                onClick = { /* Handle password recovery */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Recover Password",
                    color = Color(0xFF2C3E50), // Dark blue
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}