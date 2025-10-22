package com.example.miblisterapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.ListItem
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AjustesScreen(
    onToggleNotifications: (Boolean) -> Unit = {},
    onToggleBiometric: (Boolean) -> Unit = {}
) {
    var notificationsEnabled by remember { mutableStateOf(true) }
    var biometricEnabled by remember { mutableStateOf(false) }

    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text("Ajustes") }) }) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)) {
                Text("Configuración")
                SpacerSmall()
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Notificaciones")
                    Switch(checked = notificationsEnabled, onCheckedChange = {
                        notificationsEnabled = it
                        onToggleNotifications(it)
                    })
                }
                SpacerSmall()
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Acceso biométrico")
                    Switch(checked = biometricEnabled, onCheckedChange = {
                        biometricEnabled = it
                        onToggleBiometric(it)
                    })
                }
            }
        }
    }
}

@Composable
private fun SpacerSmall() = androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(vertical = 6.dp))