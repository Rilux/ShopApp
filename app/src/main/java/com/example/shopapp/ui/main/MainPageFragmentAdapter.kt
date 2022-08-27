package com.example.shopapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopapp.data.local.Product
import com.example.shopapp.databinding.ItemProductBinding
import kotlinx.android.synthetic.main.item_product.view.*


class MainPageFragmentAdapter :
    ListAdapter<Product, MainPageFragmentAdapter.MainPageFragmentViewHolder>(Comparator()) {
    class MainPageFragmentViewHolder(binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var listProducts = emptyList<Product>()

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

    fun setList(list: List<Product>) {
        listProducts = list
        notifyDataSetChanged()
    }

    class Comparator : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(
            oldItem: Product,
            newItem: Product
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Product,
            newItem: Product
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }

}