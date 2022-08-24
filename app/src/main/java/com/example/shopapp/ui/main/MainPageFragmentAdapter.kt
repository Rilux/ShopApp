package com.example.shopapp.ui.main

import androidx.recyclerview.widget.ListAdapter
import com.example.shopapp.data.model.product.ProductslistItem
import com.example.shopapp.databinding.FragmentMainPageBinding

class MainPageFragmentAdapter : ListAdapter<ProductslistItem, MainPageFragmentAdapter.MainPageFragmentViewHolder>(Comparator()) {
    class MainPageFragmentViewHolder(binding) {

    }

}