package com.bangnv.coffeeorder.ui_mvp.home

class HomePresenter(
    private val view: HomeMvpView,
    private val homeRepository: HomeRepository
) : HomeMvpPresent {

    override fun fetchProducts() {
        homeRepository.getProducts { products, errorMessage ->
            if (products != null) {
                view.showProducts(products)
            } else {
                view.showError(errorMessage ?: "An error occurred")
            }
        }
    }

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
