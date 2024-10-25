package com.bangnv.coffeeorder.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bangnv.coffeeorder.R

fun replaceFragment(activity: AppCompatActivity, fragment: Fragment) {
    val fragmentTag = fragment::class.java.simpleName
    val fragmentManager = activity.supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()

    val existingFragment = fragmentManager.findFragmentByTag(fragmentTag)
    if (existingFragment != null) {
        fragmentTransaction.show(existingFragment)
    } else {
        fragmentTransaction.add(R.id.fragmentContainer, fragment, fragmentTag)
    }

    val fragments = fragmentManager.fragments
    for (f in fragments) {
        if (f != existingFragment) { fragmentTransaction.hide(f) }
    }

    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commit()
}
