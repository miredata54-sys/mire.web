package org.example.project

actual class Platform {
    actual val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = Platform()