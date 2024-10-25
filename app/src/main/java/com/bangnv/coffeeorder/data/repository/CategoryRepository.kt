package com.bangnv.coffeeorder.data.repository

import com.bangnv.coffeeorder.data.network.AppApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.bangnv.coffeeorder.model.Category

class CategoryRepository(private val api: AppApi) {
    fun getCategories(callback: (List<Category>?, String?) -> Unit) {
        api.getCategories().enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                if (response.isSuccessful) {
                    callback(response.body(), null)
                } else {
                    callback(null, response.message())
                }
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                callback(null, t.message)
            }
        })
    }
}