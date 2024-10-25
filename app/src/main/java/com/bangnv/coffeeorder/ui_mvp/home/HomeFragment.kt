package com.bangnv.coffeeorder.ui_mvp.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangnv.coffeeorder.adapter.CategoryAdapter
import com.bangnv.coffeeorder.adapter.ProductGridAdapter
import com.bangnv.coffeeorder.data.network.AppApi
import com.bangnv.coffeeorder.data.network.RetrofitClient
import com.bangnv.coffeeorder.data.repository.CategoryRepository
import com.bangnv.coffeeorder.data.repository.ProductRepository
import com.bangnv.coffeeorder.databinding.FragmentHomeBinding
import com.bangnv.coffeeorder.model.Category
import com.bangnv.coffeeorder.model.Product

class HomeFragment : Fragment(), HomeMvpView {

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var productGridAdapter: ProductGridAdapter
    private lateinit var homeMvpPresent: HomeMvpPresent

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // Lifecycle Methods
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()
        setupRecyclerViews()
        setupPresenter()
        fetchData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Adapter and RecyclerView Initialization
    private fun initAdapters() {
        categoryAdapter = CategoryAdapter(emptyList(), object : CategoryAdapter.IOnClickCategoryItemListener {
            override fun onClickItemCategory(category: Category) {
                clickItemCategory(category)
            }
        })

        productGridAdapter = ProductGridAdapter(
            requireContext(),
            emptyList(),
            object : ProductGridAdapter.IOnClickProductItemListener {
                override fun onClickItemProduct(product: Product) {
                    clickItemProduct(product)
                }
            }
        )
    }

    private fun setupRecyclerViews() {
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.categoryRecyclerView.adapter = categoryAdapter

        binding.productRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.productRecyclerView.adapter = productGridAdapter
    }

    // Presenter Setup
    private fun setupPresenter() {
        val api: AppApi = RetrofitClient.instance
        val productRepository = ProductRepository(api)
        val categoryRepository = CategoryRepository(api)
        val homeRepository = HomeRepository(productRepository, categoryRepository)

        homeMvpPresent = HomePresenter(this, homeRepository)
    }

    // Data Fetching
    private fun fetchData() {
        homeMvpPresent.fetchCategories()
        homeMvpPresent.fetchProducts()
    }

    // Click Listeners
    private fun clickItemCategory(category: Category) {
        Toast.makeText(requireContext(), "Category Clicked: Id = ${category.id}", Toast.LENGTH_SHORT).show()
    }

    private fun clickItemProduct(product: Product) {
        Toast.makeText(requireContext(), "Product Clicked: Id = ${product.id}", Toast.LENGTH_SHORT).show()
    }


    // MVP View Implementation
    override fun showProducts(products: List<Product>) {
        Log.d("HomeFragment", "Products received: $products")
        productGridAdapter.setData(products)
    }

    override fun showCategories(categories: List<Category>) {
        Log.d("HomeFragment", "Categories received: $categories")
        categoryAdapter.setData(categories)
    }

    override fun showError(message: String) {
        Log.e("HomeFragment", "Error: $message")
//        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show() // Optional Toast for errors
    }
}
