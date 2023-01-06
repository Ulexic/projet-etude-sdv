package com.example.projet_etude_sdv.navBars

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projet_etude_sdv.R

@Composable
fun TopBar(navController: NavHostController, title: String, displayBackButton: Boolean) {
    TopAppBar(
        content = {
            if (displayBackButton) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
            Box(Modifier.height(32.dp)) {
                Row(
                    Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = title, style = MaterialTheme.typography.h6
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun TopBarLogo() {
    TopAppBar(
        content = {
            Box(Modifier.height(32.dp)) {
                Row(
                    Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun TopBarFave(navController: NavHostController, title: String, isModifying: Boolean) {
    TopAppBar(
        content = {
            Box(Modifier.height(32.dp)) {
                Row(
                    Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.h6
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = dimensionResource(R.dimen.padding))
                        .clickable { isModifying != isModifying },
                    text = if (isModifying) "Terminer" else "Modifier"
                )
            }
        }
    )
}

@Preview
@Composable
private fun Preview() {
    TopBarFave(rememberNavController(), "preview", true)
}