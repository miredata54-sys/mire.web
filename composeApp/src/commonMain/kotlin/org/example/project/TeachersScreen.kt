package org.example.project

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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

