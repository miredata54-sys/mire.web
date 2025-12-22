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
import androidx.compose.foundation.clickable
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

enum class Screen {
    LOGIN,
    DASHBOARD
}

@Composable
@Preview
fun App() {
    var currentScreen by remember { mutableStateOf(Screen.LOGIN) }
    
    MaterialTheme {
        when (currentScreen) {
            Screen.LOGIN -> LoginScreen(onLoginClick = { currentScreen = Screen.DASHBOARD })
            Screen.DASHBOARD -> DashboardScreen()
        }
    }
}

@Composable
fun LoginScreen(onLoginClick: () -> Unit = {}) {
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
                onClick = { onLoginClick() },
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

// Dashboard Icons
@Composable
fun EducationIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                // Person sitting at desk
                // Head
                addOval(androidx.compose.ui.geometry.Rect(
                    center.x - 8.dp.toPx(),
                    center.y - 18.dp.toPx(),
                    center.x + 8.dp.toPx(),
                    center.y - 2.dp.toPx()
                ))
                // Body
                moveTo(center.x - 10.dp.toPx(), center.y - 2.dp.toPx())
                lineTo(center.x + 10.dp.toPx(), center.y - 2.dp.toPx())
                lineTo(center.x + 8.dp.toPx(), center.y + 10.dp.toPx())
                lineTo(center.x - 8.dp.toPx(), center.y + 10.dp.toPx())
                close()
                // Desk (book)
                moveTo(center.x - 12.dp.toPx(), center.y + 10.dp.toPx())
                lineTo(center.x + 12.dp.toPx(), center.y + 10.dp.toPx())
                lineTo(center.x + 12.dp.toPx(), center.y + 14.dp.toPx())
                lineTo(center.x - 12.dp.toPx(), center.y + 14.dp.toPx())
                close()
            }
            drawPath(
                path = path,
                color = Color.White,
                style = Stroke(width = 2.5.dp.toPx())
            )
        }
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

@Composable
fun Sidebar(
    selectedMenuItem: String,
    onMenuItemSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .width(250.dp)
            .fillMaxHeight()
            .background(Color(0xFF6B46C1)) // Dark purple
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // Logo/Icon
        EducationIcon()
        
        // Navigation Menu
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val menuItems = listOf(
                "Dashboard",
                "Students",
                "Teachers",
                "Parents",
                "Library",
                "Attendance",
                "Exam",
                "Settings"
            )
            
            menuItems.forEach { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            if (selectedMenuItem == item) Color(0xFFE5E7EB) else Color.Transparent
                        )
                        .clickable { onMenuItemSelected(item) }
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                ) {
                    Text(
                        text = item,
                        color = if (selectedMenuItem == item) Color(0xFF333333) else Color.White,
                        fontSize = 16.sp,
                        fontWeight = if (selectedMenuItem == item) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Composable
fun MainContentArea(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333)
            )
            
            // Search Bar
            var searchText by remember { mutableStateOf("") }
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = {
                    Text(
                        text = "Search",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                },
                trailingIcon = {
                    SearchIcon()
                },
                modifier = Modifier
                    .width(300.dp)
                    .height(40.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF5F5F5),
                    focusedContainerColor = Color(0xFFF5F5F5),
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                singleLine = true
            )
        }
        
        content()
    }
}

@Composable
fun DashboardScreen() {
    var selectedMenuItem by remember { mutableStateOf("Dashboard") }
    
    Row(modifier = Modifier.fillMaxSize()) {
        Sidebar(
            selectedMenuItem = selectedMenuItem,
            onMenuItemSelected = { selectedMenuItem = it }
        )
        
        when (selectedMenuItem) {
            "Dashboard" -> MainContentArea(title = "Welcome to Tabaarak ICT") {
                // Statistics Cards
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Schools Card
                    StatCard(
                        title = "Schools",
                        value = "6000",
                        barColor = Color(0xFFFFB6C1), // Light pink
                        icon = { SchoolIcon(color = Color(0xFFFFB6C1)) },
                        modifier = Modifier.weight(1f)
                    )
                    
                    // Students Card
                    StatCard(
                        title = "Students",
                        value = "25000",
                        barColor = Color(0xFF6B46C1), // Dark purple
                        icon = { GraduationCapIcon(color = Color(0xFF6B46C1)) },
                        modifier = Modifier.weight(1f)
                    )
                    
                    // Teachers Card
                    StatCard(
                        title = "Teachers",
                        value = "3500",
                        barColor = Color(0xFFFFD700), // Yellow
                        icon = { TeachersIcon(color = Color(0xFFFFD700)) },
                        modifier = Modifier.weight(1f)
                    )
                    
                    // Parents Card
                    StatCard(
                        title = "Parents",
                        value = "11020",
                        barColor = Color(0xFF22C55E), // Green
                        icon = { ParentsIcon(color = Color(0xFF22C55E)) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            "Students" -> StudentsScreen()
            "Teachers" -> TeachersScreen()
            "Parents" -> ParentsScreen()
            "Library" -> LibraryScreen()
            "Attendance" -> AttendanceScreen()
            "Exam" -> ExamScreen()
            "Settings" -> SettingsScreen()
            else -> MainContentArea(title = selectedMenuItem) {
                Text("Content for $selectedMenuItem")
            }
        }
    }
}

@Composable
fun StudentsScreen() {
    MainContentArea(title = "Students") {
        Text(
            text = "Students Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333)
        )
        Text(
            text = "Manage student information, enrollment, and records.",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun TeachersScreen() {
    MainContentArea(title = "Teachers") {
        Text(
            text = "Teachers Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333)
        )
        Text(
            text = "Manage teacher profiles, schedules, and assignments.",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ParentsScreen() {
    MainContentArea(title = "Parents") {
        Text(
            text = "Parents Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333)
        )
        Text(
            text = "Manage parent accounts and communication.",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun LibraryScreen() {
    MainContentArea(title = "Library") {
        Text(
            text = "Library Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333)
        )
        Text(
            text = "Manage books, resources, and library records.",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun AttendanceScreen() {
    MainContentArea(title = "Attendance") {
        Text(
            text = "Attendance Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333)
        )
        Text(
            text = "Track and manage student and staff attendance.",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ExamScreen() {
    MainContentArea(title = "Exam") {
        Text(
            text = "Exam Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333)
        )
        Text(
            text = "Schedule exams, manage results, and generate reports.",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun SettingsScreen() {
    MainContentArea(title = "Settings") {
        Text(
            text = "System Settings",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333)
        )
        Text(
            text = "Configure system preferences and user settings.",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun StatCard(
    title: String,
    value: String,
    barColor: Color,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(120.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .shadow(2.dp, RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Colored vertical bar
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .fillMaxHeight()
                    .background(barColor, RoundedCornerShape(2.dp))
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // Icon
            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // Text content
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = value,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF333333)
                )
            }
        }
    }
}