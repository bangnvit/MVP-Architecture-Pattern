package com.bangnv.coffeeorder.ui_mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangnv.coffeeorder.R
import com.bangnv.coffeeorder.databinding.ActivityMainBinding
import com.bangnv.coffeeorder.ui_mvp.account.AccountFragment
import com.bangnv.coffeeorder.ui_mvp.cart.CartFragment
import com.bangnv.coffeeorder.ui_mvp.contact.ContactFragment
import com.bangnv.coffeeorder.ui_mvp.feedback.FeedbackFragment
import com.bangnv.coffeeorder.ui_mvp.home.HomeFragment
import com.bangnv.coffeeorder.utils.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
        binding.bottomNavigation.selectedItemId = R.id.nav_home // Set default fragment
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            val selectedFragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_cart -> CartFragment()
                R.id.nav_feedback -> FeedbackFragment()
                R.id.nav_contact -> ContactFragment()
                R.id.nav_account -> AccountFragment()
                else -> null
            }

            selectedFragment?.let {
                replaceFragment(this, it)
                true
            } ?: false // Return false if no valid fragment is selected
        }
    }
}
