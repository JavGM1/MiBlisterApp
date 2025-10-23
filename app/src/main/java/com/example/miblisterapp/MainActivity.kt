package com.example.miblisterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    Surface(color = MaterialTheme.colorScheme.background) {
        Text(text = "MiBlisterApp - Scaffold placeholder")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppContent()
}
