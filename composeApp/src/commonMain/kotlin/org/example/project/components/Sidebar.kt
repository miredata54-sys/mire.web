package org.example.project.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Sidebar(
    selectedMenuItem: String,
    onMenuItemSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .width(250.dp)
            .fillMaxHeight()
            .background(Color(0xFF6B46C1))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {

        EducationIcon()


        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val menuItems = listOf(
                "Dashboard",
                "Students",
                "Teachers",
                "Parents",
                "adminschool",
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