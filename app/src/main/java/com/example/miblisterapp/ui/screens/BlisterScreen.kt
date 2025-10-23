package com.example.miblisterapp.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlisterScreen() {
    // placeholder state: 28 items
    var taken by remember { mutableStateOf(mutableSetOf<Int>()) }
    val total = 28
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Mi Ciclo") }) }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                Text(text = "Blíster (placeholder)")
                SpacerSmall()
                // show rows of 7
                for (row in 0 until 4) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        for (col in 0 until 7) {
                            val index = row * 7 + col
                            if (index >= total) {
                                Box(modifier = Modifier.size(36.dp))
                            } else {
                                PillView(
                                    index = index,
                                    isTaken = taken.contains(index),
                                    onToggle = {
                                        if (taken.contains(index)) taken.remove(index) else taken.add(index)
                                        // trigger recomposition of set
                                        taken = taken.toMutableSet()
                                    }
                                )
                            }
                        }
                    }
                    SpacerSmall()
                }
            }
        }
    }
}

@Composable
private fun PillView(index: Int, isTaken: Boolean, onToggle: () -> Unit) {
    var scale by remember { mutableStateOf(1f) }
    LaunchedEffect(isTaken) {
        // simple animation effect
        scale = 1.15f
        delay(120)
        scale = 1f
    }
    Card(
        modifier = Modifier
            .size(44.dp)
            .scale(scale)
            .clickable { onToggle() },
        shape = CircleShape
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(if (isTaken) Color(0xFF4CAF50) else Color(0xFFE0E0E0)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = if (isTaken) "🟢" else "⚪")
        }
    }
}

@Composable
private fun SpacerSmall() = androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(vertical = 6.dp))