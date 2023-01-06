package com.example.projet_etude_sdv.screens.products

import android.view.MotionEvent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.projet_etude_sdv.R
import com.example.projet_etude_sdv.navBars.TopBar

@Composable
fun ProductDetailScreen(navController: NavHostController) {
    Column {
        TopBar(navController, "", true)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(dimensionResource(R.dimen.padding)))
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        Row(Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = dimensionResource(R.dimen.padding)),
                text = "name"
            )
            Spacer(Modifier.weight(1f))
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = dimensionResource(R.dimen.padding)),
                text = "price"
            )
        }
        Row(Modifier.fillMaxWidth()) {
            RatingBar()
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(dimensionResource(R.dimen.padding)),
                text = "(notes)"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { /*TODO*/ },
            content = { Text(text = "Ajouter au panier") }
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RatingBar(x: Int = 0) {
    val starIcon = painterResource(id = android.R.drawable.star_off)
    var rating: Int by remember { mutableStateOf(x) }

    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        for (star in 1..5) {
            Icon(
                painter = starIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .padding(end = 4.dp)
                    .pointerInteropFilter {
                        when (it.action) {
                            MotionEvent.ACTION_DOWN -> {
                                rating = star
                                true
                            }
                            else -> false
                        }
                    },
                tint = if (star <= rating) Color.Yellow else Color.Gray
            )
        }
    }
}