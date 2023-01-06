package com.example.projet_etude_sdv.screens.products

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.projet_etude_sdv.R
import com.example.projet_etude_sdv.navGraphs.NavGraphDestinations

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductList(products: List<Int>, navController: NavHostController) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        state = rememberLazyListState(),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding))
    ) {
        items(products) { item ->
            Box(contentAlignment = Alignment.TopEnd,
                modifier = Modifier.clickable() {
                    navController.navigate(NavGraphDestinations.ProductDetails.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            ) {
                ListItem(item)
                FavoriteButton(color = Color.Red)
            }
        }
    }
}

@Composable
fun FavoriteButton(
    color: Color = Color.White
) {
    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = !isFavorite
        }
    ) {
        Icon(
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.padding),
                end = dimensionResource(R.dimen.padding)
            ),
            tint = color,
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }
}

@Composable
fun ListItem(item: Int) {
    Column {
        Card(
            //border = BorderStroke(Dp.Hairline, Color.Gray),
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding))
                .width(200.dp)
                .height(200.dp),
            backgroundColor = Color.White
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Black)
            )
        }
        Text(
            modifier = Modifier.padding(start = dimensionResource(R.dimen.padding)),
            text = "Test"
        )
        Text(
            modifier = Modifier.padding(start = dimensionResource(R.dimen.padding)),
            text = "Desc", color = Color.DarkGray
        )
        Text(
            modifier = Modifier.padding(start = dimensionResource(R.dimen.padding)),
            text = "Price"
        )
    }
}