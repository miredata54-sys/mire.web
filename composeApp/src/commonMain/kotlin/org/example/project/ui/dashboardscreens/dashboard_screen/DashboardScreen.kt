package org.example.project.ui.dashboardscreens.dashboard_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.components.MainContentArea
import org.example.project.components.Sidebar
import org.example.project.components.StatCard
import org.example.project.components.WelcomeCard
import org.example.project.components.GraduationCapIcon
import org.example.project.components.ParentsIcon
import org.example.project.components.SchoolIcon
import org.example.project.settingsscreen.SettingsScreen
import org.example.project.components.TeachersIcon
import org.example.project.ui.dashboardscreens.adminsschool_screens.adminschool
import org.example.project.ui.dashboardscreens.attendence.AttendanceScreen
import org.example.project.ui.dashboardscreens.examscreen.ExamScreen
import org.example.project.ui.dashboardscreens.parentscreen.ParentsScreen
import org.example.project.ui.dashboardscreens.studentscreens.StudentsScreen
import org.example.project.ui.dashboardscreens.teacherscreen.TeachersScreen

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

                    WelcomeCard()

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
            "adminsschools" -> adminschool()
            "Attendance" -> AttendanceScreen()
            "Exam" -> ExamScreen()
            "Settings" -> SettingsScreen()
            else -> MainContentArea(title = selectedMenuItem) {
                Text("Content for $selectedMenuItem")
            }
        }
    }
}

