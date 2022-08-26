package com.example.shopapp.ui.root

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shopapp.ui.cart.CartFragment
import com.example.shopapp.ui.catalogue.CatalogueFragment
import com.example.shopapp.ui.main.MainPageFragment

class RootFragmentViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> MainPageFragment()
            1 -> CatalogueFragment()
            else -> CartFragment()
        }
}