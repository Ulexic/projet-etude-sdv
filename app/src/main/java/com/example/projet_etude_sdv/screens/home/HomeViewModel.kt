package com.example.projet_etude_sdv.screens.home

import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    var cartBadge = 0;

    fun addToCart() {
        cartBadge++
    }

}