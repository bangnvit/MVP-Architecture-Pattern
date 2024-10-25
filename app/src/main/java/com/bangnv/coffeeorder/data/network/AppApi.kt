package com.bangnv.coffeeorder.data.network

import com.bangnv.coffeeorder.data.network.NetworkEndPoint.GET_LIST_CATEGORIES
import com.bangnv.coffeeorder.data.network.NetworkEndPoint.GET_LIST_PRODUCTS
import com.bangnv.coffeeorder.model.Category
import com.bangnv.coffeeorder.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.http.GET

interface AppApi {
    // Using Coroutine
    @GET(GET_LIST_PRODUCTS) // URL endpoint list products
    suspend fun getProducts(): List<Product>

    // Using Callback
//    @GET(GET_LIST_PRODUCTS) // URL endpoint list products
//    fun getProducts(): Call<List<Product>>

    // Using Callback
    @GET(GET_LIST_CATEGORIES) // URL endpoint list categories
    fun getCategories(): Call<List<Category>>
}