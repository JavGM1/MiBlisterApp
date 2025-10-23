package com.example.miblisterapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Settings
import com.example.miblisterapp.ui.screens.*

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            LoginScreen(
                onNavigateToRegister = { navController.navigate(Routes.Register.route) },
                onLoginSuccess = {
                    // limpia el stack de auth y navega al grafo main
                    navController.navigate(Routes.Main.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.Register.route) {
            RegisterScreen(onRegisterSuccess = {
                navController.navigate(Routes.Login.route) {
                    popUpTo(Routes.Register.route) { inclusive = true }
                }
            })
        }

        // Grafo anidado para las pantallas principales con BottomNav
        navigation(startDestination = Routes.Blister.route, route = Routes.Main.route) {
            composable(Routes.Blister.route) {
                MainScaffold(navController = navController) { innerModifier: Modifier ->
                    Box(modifier = innerModifier) {
                        BlisterScreen()
                    }
                }
            }
            composable(Routes.Cotizar.route) {
                MainScaffold(navController = navController) { innerModifier: Modifier ->
                    Box(modifier = innerModifier) {
                        CotizarScreen()
                    }
                }
            }
            composable(Routes.Ajustes.route) {
                MainScaffold(navController = navController) { innerModifier: Modifier ->
                    Box(modifier = innerModifier) {
                        AjustesScreen()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    navController: NavHostController,
    content: @Composable (Modifier) -> Unit
) {
    val items = listOf(Routes.Blister, Routes.Cotizar, Routes.Ajustes)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(getTitleForRoute(currentRoute)) })
        },
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                // evita múltiples instancias en el stack
                                launchSingleTop = true
                                restoreState = true
                                // popUpTo puede ajustarse para preservar estado
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = when (item) {
                                    Routes.Blister -> Icons.Default.Home
                                    Routes.Cotizar -> Icons.Default.ShoppingCart
                                    Routes.Ajustes -> Icons.Default.Settings
                                    else -> Icons.Default.Home
                                },
                                contentDescription = item.route
                            )
                        },
                        label = { Text(getLabelForRoute(item.route)) }
                    )
                }
            }
        }
    ) { innerPadding ->
        // convert PaddingValues to Modifier and pass down to content
        content(Modifier.padding(innerPadding))
    }
}

private fun getTitleForRoute(route: String?): String {
    return when (route) {
        Routes.Blister.route -> "Mi Ciclo"
        Routes.Cotizar.route -> "Cotizar"
        Routes.Ajustes.route -> "Ajustes"
        else -> "MiBlisterApp"
    }
}

private fun getLabelForRoute(route: String?): String {
    return when (route) {
        Routes.Blister.route -> "Mi Ciclo"
        Routes.Cotizar.route -> "Cotizar"
        Routes.Ajustes.route -> "Ajustes"
        else -> ""
    }
}