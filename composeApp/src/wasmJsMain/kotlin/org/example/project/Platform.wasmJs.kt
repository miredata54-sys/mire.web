package org.example.project

import org.example.project.components.Platform

actual class Platform {
    actual val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = org.example.project.components.Platform()