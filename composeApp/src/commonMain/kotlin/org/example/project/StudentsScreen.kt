package org.example.project

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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

