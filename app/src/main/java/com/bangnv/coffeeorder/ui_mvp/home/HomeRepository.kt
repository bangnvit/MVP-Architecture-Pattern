package com.bangnv.coffeeorder.ui_mvp.home

import com.bangnv.coffeeorder.data.repository.CategoryRepository
import com.bangnv.coffeeorder.data.repository.ProductRepository
import com.bangnv.coffeeorder.model.Category
import com.bangnv.coffeeorder.model.Product

class HomeRepository(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {
    fun getProducts(callback: (List<Product>?, String?) -> Unit) {
        productRepository.getProducts(callback)
    }

    fun getCategories(callback: (List<Category>?, String?) -> Unit) {
        categoryRepository.getCategories(callback)
    }
}