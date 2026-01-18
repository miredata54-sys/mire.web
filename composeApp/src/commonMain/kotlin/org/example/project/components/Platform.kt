package org.example.project

expect class Platform {
    val name: String
}

expect fun getPlatform(): Platform

