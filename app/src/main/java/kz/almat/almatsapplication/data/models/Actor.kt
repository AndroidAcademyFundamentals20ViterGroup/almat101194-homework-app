package kz.almat.almatsapplication.data.models

import androidx.annotation.DrawableRes

data class Actor(
        val id: Int,
        val name: String,
        @DrawableRes
        val image: Int
)