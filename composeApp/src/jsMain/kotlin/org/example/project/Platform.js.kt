package org.example.project

actual class Platform {
    actual val name: String = "Web with Kotlin/JS"
}

actual fun getPlatform(): Platform = Platform()