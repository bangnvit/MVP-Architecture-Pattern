package com.bangnv.coffeeorder.ui_mvp.home

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomePresenter(
    private val view: HomeMvpView,private val homeRepository: HomeRepository
) : HomeMvpPresent {

    // Using Coroutine
    override fun fetchProducts() {
        CoroutineScope(Dispatchers.IO).launch { // Run on the I/O thread
            val products = homeRepository.getProducts() // Call suspend function to fetch products

            withContext(Dispatchers.Main) { // Switch to the Main thread to update the UI
                if (products != null) {
                    view.showProducts(products) // Display products in the view
                } else {
                    view.showError("Failed to fetch products") // Show error message if fetching fails
                }
            }
        }
    }

    // Using Callback
//    override fun fetchProducts() {
//        homeRepository.getProducts { products, errorMessage ->
//            if (products != null) {
//                view.showProducts(products)
//            } else {
//                view.showError(errorMessage ?: "An error occurred")
//            }
//        }
//    }

    // Using Callback
    override fun fetchCategories() {
        homeRepository.getCategories { categories, errorMessage ->
            if (categories != null) {
                view.showCategories(categories)
            } else {
                view.showError(errorMessage ?: "An error occurred")
            }
        }
    }
}