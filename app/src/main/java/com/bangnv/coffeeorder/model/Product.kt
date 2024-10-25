package com.bangnv.coffeeorder.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    var id: Long = 0,
    var name: String = "",
    var description: String = "",
    var price: Int = 0,
    var sale: Int = 0,
    var image: String? = "",
    var banner: String? = "",
    var isPopular: String? = "",
    val images: List<String>? = emptyList(),
    var categoryId: Long = 0,
    var categoryName: String? = ""
)
