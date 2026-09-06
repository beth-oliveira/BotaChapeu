package org.example.botachapeu

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform