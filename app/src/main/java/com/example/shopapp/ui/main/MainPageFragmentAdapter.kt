package com.example.shopapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopapp.data.model.product.Productslist
import com.example.shopapp.data.model.product.ProductslistItem
import com.example.shopapp.databinding.ItemProductBinding
import kotlinx.android.synthetic.main.item_product.view.*


class MainPageFragmentAdapter :
    ListAdapter<ProductslistItem, MainPageFragmentAdapter.MainPageFragmentViewHolder>(Comparator()) {
    class MainPageFragmentViewHolder(binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var listProducts = emptyList<ProductslistItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPageFragmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return MainPageFragmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainPageFragmentViewHolder, position: Int) {
        val product = listProducts[position]
        Glide.with(holder.itemView.productImageView)
            .load(product.image)
            .into(holder.itemView.productImageView)

        holder.itemView.productNameTextView.text = product.title
        holder.itemView.priceTextView.text = product.price.toString() + "$"

    }

    override fun getItemCount(): Int = listProducts.size

    fun setList(list: Productslist) {
        listProducts = list
        notifyDataSetChanged()
    }

    class Comparator : DiffUtil.ItemCallback<ProductslistItem>() {
        override fun areItemsTheSame(
            oldItem: ProductslistItem,
            newItem: ProductslistItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductslistItem,
            newItem: ProductslistItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }

}