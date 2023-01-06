package com.example.projet_etude_sdv.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projet_etude_sdv.navBars.TopBarLogo
import com.example.projet_etude_sdv.screens.products.ProductList

@Composable
fun HomeScreen(navController: NavHostController) {
    val products = listOf(1, 1, 1, 1, 1, 1, 1, 1)
    Column() {
        TopBarLogo()
        ProductList(products, navController)
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}