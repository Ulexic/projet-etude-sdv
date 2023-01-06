package com.example.projet_etude_sdv.navGraphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavGraphDestinations(
    val route: String,
    val title: String,
    val icon: ImageVector?
) {
    object Home : NavGraphDestinations(
        route = "HOME",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : NavGraphDestinations(
        route = "PROFILE",
        title = "Profile",
        icon = Icons.Default.Person
    )

    object Search : NavGraphDestinations(
        route = "SEARCH",
        title = "Search",
        icon = Icons.Default.Search
    )

    object Favorite : NavGraphDestinations(
        route = "FAVORITE",
        title = "Favorite",
        icon = Icons.Default.Favorite
    )

    object Cart : NavGraphDestinations(
        route = "CART",
        title = "Cart",
        icon = Icons.Default.ShoppingCart
    )

    object ProductDetails : NavGraphDestinations(
        route = "PRODUCT_DETAILS",
        title = "",
        icon = null
    )

    object SearchResult : NavGraphDestinations(
        route = "SEARCH_RESULT",
        title = "",
        icon = null
    )
}

fun getDestFromRoute(route: String): NavGraphDestinations {
    return when (route) {
        NavGraphDestinations.Home.route -> NavGraphDestinations.Home
        NavGraphDestinations.Profile.route -> NavGraphDestinations.Profile
        NavGraphDestinations.Search.route -> NavGraphDestinations.Search
        NavGraphDestinations.Cart.route -> NavGraphDestinations.Cart
        NavGraphDestinations.Favorite.route -> NavGraphDestinations.Favorite
        NavGraphDestinations.ProductDetails.route -> NavGraphDestinations.ProductDetails
        NavGraphDestinations.SearchResult.route -> NavGraphDestinations.SearchResult
        else -> NavGraphDestinations.Home
    }
}