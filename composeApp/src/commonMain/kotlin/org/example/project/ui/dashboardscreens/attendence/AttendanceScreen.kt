package org.example.project.ui.dashboardscreens.attendence

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.example.project.components.MainContentArea

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

