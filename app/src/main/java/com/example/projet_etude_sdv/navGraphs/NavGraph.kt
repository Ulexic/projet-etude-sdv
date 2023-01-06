package com.example.projet_etude_sdv.navGraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projet_etude_sdv.screens.cart.CartScreen
import com.example.projet_etude_sdv.screens.favorites.FavoriteScreen
import com.example.projet_etude_sdv.screens.home.HomeScreen
import com.example.projet_etude_sdv.screens.products.ProductDetailScreen
import com.example.projet_etude_sdv.screens.profile.ProfileScreen
import com.example.projet_etude_sdv.screens.search.SearchResultScreen
import com.example.projet_etude_sdv.screens.search.SearchScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavGraphDestinations.Home.route
    ) {
        composable(route = NavGraphDestinations.Home.route) {
            HomeScreen(navController)
        }
        composable(route = NavGraphDestinations.Search.route) {
            SearchScreen(navController)
        }
        composable(route = NavGraphDestinations.Favorite.route) {
            FavoriteScreen(navController)
        }
        composable(route = NavGraphDestinations.Cart.route) {
            CartScreen(navController)
        }
        composable(route = NavGraphDestinations.Profile.route) {
            ProfileScreen(navController)
        }
        composable(route = NavGraphDestinations.ProductDetails.route) {
            ProductDetailScreen(navController)
        }
        composable(route = NavGraphDestinations.SearchResult.route) {
            SearchResultScreen(navController)
        }
    }
}
