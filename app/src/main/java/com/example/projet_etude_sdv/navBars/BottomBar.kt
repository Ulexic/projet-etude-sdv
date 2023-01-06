package com.example.projet_etude_sdv.navBars


import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.projet_etude_sdv.navGraphs.NavGraphDestinations

@Preview
@Composable
private fun preview() {
    BottomBar(rememberNavController())
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        NavGraphDestinations.Home,
        NavGraphDestinations.Search,
        NavGraphDestinations.Favorite,
        NavGraphDestinations.Cart,
        NavGraphDestinations.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: NavGraphDestinations,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            if (screen.route == NavGraphDestinations.Cart.route) {
                BadgedBox(
                    badge = {
                        Badge(
                            modifier = Modifier.padding(top = 8.dp),
                            backgroundColor = MaterialTheme.colors.primary
                        ) {
                            Text(text = "8", color = Color.White)
                        }
                    }
                ) {
                    Icon(
                        imageVector = screen.icon!!,
                        contentDescription = "${screen.title} Navigation Icon"
                    )
                }
            } else {
                Icon(
                    imageVector = screen.icon!!,
                    contentDescription = "${screen.title} Navigation Icon"
                )
            }
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route)
        }
    )
}
