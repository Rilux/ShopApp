package com.example.shopapp.ui.root

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.shopapp.R
import com.example.shopapp.databinding.FragmentRootBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.internal.managers.FragmentComponentManager

class RootFragment : Fragment() {

    private lateinit var binding: FragmentRootBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRootBinding.inflate(layoutInflater)
        val view = binding.root

        binding.rootFragmentViewPager.adapter =
            RootFragmentViewPagerAdapter(FragmentComponentManager.findActivity(view.context) as FragmentActivity)
        binding.rootFragmentViewPager.isUserInputEnabled = false
        TabLayoutMediator(binding.tabLayout, binding.rootFragmentViewPager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = "Main"
                    tab.setIcon(R.drawable.ic_home)
                }
                1 -> {
                    tab.text = "Catalogue"
                    tab.setIcon(R.drawable.ic_catalogue)
                }
                2 -> {
                    tab.text = "Cart"
                    tab.setIcon(R.drawable.ic_cart)
                }
            }
        }.attach()
        return view
    }

}