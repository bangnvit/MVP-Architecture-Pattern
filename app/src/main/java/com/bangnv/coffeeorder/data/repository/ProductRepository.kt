package com.bangnv.coffeeorder.data.repository

import com.bangnv.coffeeorder.data.network.AppApi
import com.bangnv.coffeeorder.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class ProductRepository(private val api: AppApi) {

    // Using Coroutine
    suspend fun getProducts(): List<Product>? {
        return try {
            api.getProducts() // suspend function already
        } catch (e: Exception) {
            null // catch exception...
        }
    }

    // Using Callback
//    fun getProducts(callback: (List<Product>?, String?) -> Unit) {
//        api.getProducts().enqueue(object : Callback<List<Product>> {
//            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
//                if (response.isSuccessful) {
//                    callback(response.body(), null)
//                } else {
//                    callback(null, response.message())
//                }
//            }
//
//            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
//                callback(null, t.message)
//            }
//        })

}