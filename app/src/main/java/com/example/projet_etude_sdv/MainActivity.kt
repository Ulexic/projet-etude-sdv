package com.example.projet_etude_sdv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.projet_etude_sdv.screens.MainScreen
import com.example.projet_etude_sdv.ui.theme.SirioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SirioTheme(true) {
                MainScreen()
            }
        }
    }
}