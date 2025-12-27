package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
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
                    // Marka login la dhaho
                    currentScreen = Screen.OTP
                }
            )

            Screen.OTP -> OtpScreen(
                onLoginClick = {
                    // Marka OTP sax noqdo
                    currentScreen = Screen.DASHBOARD
                }
            )

            Screen.DASHBOARD -> DashboardScreen()
        }
    }
}

