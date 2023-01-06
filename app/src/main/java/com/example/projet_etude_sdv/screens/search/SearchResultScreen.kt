package com.example.projet_etude_sdv.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projet_etude_sdv.navBars.TopBar
import com.example.projet_etude_sdv.navGraphs.NavGraphDestinations
import com.example.projet_etude_sdv.screens.products.ProductList

@Composable
fun SearchResultScreen(navController: NavHostController) {
    val products = listOf(1, 1, 1, 1, 1, 1, 1, 1)
    Column() {
        TopBar(navController, NavGraphDestinations.SearchResult.title, true)
        Spacer(Modifier.height(32.dp))
        ProductList(products, navController)
    }
}

@Composable
@Preview
fun SearchScreenPreview() {
    SearchResultScreen(rememberNavController())
}