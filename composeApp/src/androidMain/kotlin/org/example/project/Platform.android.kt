package org.example.project

import android.os.Build
import org.example.project.components.Platform

actual class Platform {
    actual val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = org.example.project.components.Platform()