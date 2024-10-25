package com.bangnv.coffeeorder.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    val id: Long = 0,
    val name: String = "",
    val image: String = ""
)
