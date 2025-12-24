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
            "Dashboard" -> MainContentArea(title = "") {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Welcome Card
                    WelcomeCard()

                    // Statistics Cards
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        StatCard(
                            title = "Schools",
                            value = "6000",
                            barColor = Color(0xFFFFB6C1),
                            icon = { SchoolIcon() },
                            modifier = Modifier.weight(1f)
                        )

                        StatCard(
                            title = "Students",
                            value = "25000",
                            barColor = Color(0xFF6B46C1),
                            icon = { GraduationCapIcon() },
                            modifier = Modifier.weight(1f)
                        )

                        StatCard(
                            title = "Teachers",
                            value = "3500",
                            barColor = Color(0xFFFFD700),
                            icon = { TeachersIcon() },
                            modifier = Modifier.weight(1f)
                        )

                        StatCard(
                            title = "Parents",
                            value = "11020",
                            barColor = Color(0xFF22C55E),
                            icon = { ParentsIcon() },
                            modifier = Modifier.weight(1f)
                        )
                    }
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

