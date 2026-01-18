package org.example.project.settingsscreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.example.project.components.MainContentArea

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

