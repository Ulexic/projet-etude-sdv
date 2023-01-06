package com.example.projet_etude_sdv.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.projet_etude_sdv.navBars.BottomBar
import com.example.projet_etude_sdv.navGraphs.RootNavGraph

@Preview
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                RootNavGraph(navController = navController)
            }
        },
        bottomBar = { BottomBar(navController = navController) }
    )
}
