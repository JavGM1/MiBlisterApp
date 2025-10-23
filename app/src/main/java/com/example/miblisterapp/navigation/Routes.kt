package com.example.miblisterapp.navigation

sealed class Routes(val route: String) {
    object Login : Routes("login")
    object Register : Routes("register")
    object Main : Routes("main") // grafo principal anidado
    object Blister : Routes("blister")
    object Cotizar : Routes("cotizar")
    object Ajustes : Routes("ajustes")
}