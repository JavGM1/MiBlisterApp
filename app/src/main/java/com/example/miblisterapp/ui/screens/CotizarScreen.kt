package com.example.miblisterapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class PriceItem(val farmacia: String, val price: String, val link: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CotizarScreen(
    items: List<PriceItem> = samplePrices(),
    onOpenLink: (String) -> Unit = {}
) {
    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text("Cotizar") }) }) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(12.dp)
        ) {
            Text("Comparador de precios (placeholder)")
            SpacerSmall()
            LazyColumn {
                items(items) { item ->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable { onOpenLink(item.link) }
                    ) {
                        Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                            Column {
                                Text(item.farmacia)
                                Text("Precio: ${item.price}")
                            }
                            Button(onClick = { onOpenLink(item.link) }) {
                                Text("Abrir")
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun samplePrices() = listOf(
    PriceItem("Farmacia A", "$4.50", "https://farmacia-a.example/product"),
    PriceItem("Farmacia B", "$5.20", "https://farmacia-b.example/product")
)

@Composable
private fun SpacerSmall() = androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(vertical = 6.dp))