package org.example

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.example.project.ui.dashboardscreens.dashboard_screen.DashboardScreen
import org.example.project.ui.logincreens.LoginScreen
import org.example.project.ui.otpscreens.OtpScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
enum class Screen {
    LOGIN,
    OTP,
    DASHBOARD
}


@Composable
@Preview
fun App() {
    var currentScreen by remember { mutableStateOf(Screen.LOGIN) }

    MaterialTheme {
        when (currentScreen) {
            Screen.LOGIN -> LoginScreen(
                onLoginClick = {

                    currentScreen = Screen.OTP
                }
            )

            Screen.OTP -> OtpScreen(
                onLoginClick = {

                    currentScreen = Screen.DASHBOARD
                }
            )

            Screen.DASHBOARD -> DashboardScreen()
        }
    }
}

