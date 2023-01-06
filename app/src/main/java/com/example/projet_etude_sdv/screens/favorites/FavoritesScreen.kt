package com.example.projet_etude_sdv.screens.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projet_etude_sdv.navBars.TopBarFave
import com.example.projet_etude_sdv.navGraphs.NavGraphDestinations
import com.example.projet_etude_sdv.screens.profile.ProfileScreen

@Composable
fun FavoriteScreen(navController: NavHostController) {
    Column() {
        TopBarFave(navController, NavGraphDestinations.Favorite.title, false)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "PROFILE",
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    ProfileScreen(rememberNavController())
}