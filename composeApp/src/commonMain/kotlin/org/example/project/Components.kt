package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import mire_data_app.composeapp.generated.resources.Res
import mire_data_app.composeapp.generated.resources.coat_of_arms_of_somalia_1__1_
import mire_data_app.composeapp.generated.resources.graduation_cap

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
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF0F1F3))
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
            .shadow(0.dp, RoundedCornerShape(8.dp))
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

@Composable
fun WelcomeCard(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .shadow(4.dp, RoundedCornerShape(20.dp))
    ) {
        // Purple gradient background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF8B5CF6), // Darker purple on left
                            Color(0xFFC4B5FD)  // Lighter purple on right
                        )
                    )
                )
        )

        // Content Row
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left side - Text content
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Date
                Text(
                    text = "September 4, 2023",
                    fontSize = 13.sp,
                    color = Color(0xFFE9D5FF).copy(alpha = 0.85f), // Light grey/purple
                    fontWeight = FontWeight.Medium
                )

                // Welcome message
                Text(
                    text = "Welcome back, John!",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 38.sp
                )

                // Subtitle
                Text(
                    text = "Always stay updated in your student portal",
                    fontSize = 15.sp,
                    color = Color.White.copy(alpha = 0.95f),
                    fontWeight = FontWeight.Normal
                )
            }

            // Right side - Graduation cap icon
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .offset(x = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.coat_of_arms_of_somalia_1__1_),
                    contentDescription = "Graduation Cap",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

