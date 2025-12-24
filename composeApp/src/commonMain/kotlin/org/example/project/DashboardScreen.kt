package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen() {
    var selectedMenuItem by remember { mutableStateOf("Dashboard") }
    
    Row(modifier = Modifier.fillMaxSize()) {
        Sidebar(
            selectedMenuItem = selectedMenuItem,
            onMenuItemSelected = { selectedMenuItem = it }
        )
        
        when (selectedMenuItem) {
            "Dashboard" -> MainContentArea(title = " ") {
                // Welcome Card
                WelcomeCard()
                
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
                        icon = { GraduationCapIcon(color = Color(0xFF6B46C1)) },
                        barColor = Color(0xFF6B46C1), // Dark purple
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

