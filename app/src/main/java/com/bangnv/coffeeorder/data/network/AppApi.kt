package com.bangnv.coffeeorder.data.network

import com.bangnv.coffeeorder.data.network.NetworkEndPoint.GET_LIST_CATEGORIES
import com.bangnv.coffeeorder.data.network.NetworkEndPoint.GET_LIST_PRODUCTS
import com.bangnv.coffeeorder.model.Category
import com.bangnv.coffeeorder.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface AppApi {
    @GET(GET_LIST_PRODUCTS) // URL endpoint list products
    fun getProducts(): Call<List<Product>>

    @GET(GET_LIST_CATEGORIES) // URL endpoint list categories
    fun getCategories(): Call<List<Category>>
}