package com.example.shopapp.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopapp.R
import com.example.shopapp.data.local.entities.CartProduct
import com.example.shopapp.databinding.ItemCartBinding
import kotlinx.android.synthetic.main.item_cart.view.*

interface CartFragmentAdapterListener {
    fun onIncreaseClicked(product: CartProduct)
    fun onDecreaseClicked(product: CartProduct)
    fun onProductClicked(product: CartProduct)
}


class CartFragmentAdapter(
    private val actionListener: CartFragmentAdapterListener
) : ListAdapter<CartProduct, CartFragmentAdapter.CartFragmentViewHolder>(Comparator()),
    View.OnClickListener {
    class CartFragmentViewHolder(binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    private var listProducts = emptyList<CartProduct>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartFragmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)
        binding.imageButtonIncrease.setOnClickListener(this)
        binding.imageButtonDecrease.setOnClickListener(this)

        return CartFragmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartFragmentViewHolder, position: Int) {
        val product = listProducts[position]
        holder.itemView.tag = product
        holder.itemView.imageButtonDecrease.tag = product
        holder.itemView.imageButtonIncrease.tag = product

        Glide.with(holder.itemView.imageViewCartProductImage)
            .load(product.image)
            .into(holder.itemView.imageViewCartProductImage)

        holder.itemView.textViewCartProductName.text = product.name
        holder.itemView.textViewCartProductPrice.text = (product.price * product.numberOfProducts).toString() + "$"
        holder.itemView.textViewCartNumberOfProducts.text = product.numberOfProducts.toString()
    }

    override fun getItemCount(): Int = listProducts.size

    fun setList(list: List<CartProduct>) {
        listProducts = list
        notifyDataSetChanged()
    }

    override fun onClick(v: View) {
        val product = v.tag as CartProduct
        when (v.id) {
            R.id.imageButtonIncrease -> actionListener.onIncreaseClicked(product)
            R.id.imageButtonDecrease -> actionListener.onDecreaseClicked(product)
            else -> actionListener.onProductClicked(product)
        }
    }

    class Comparator : DiffUtil.ItemCallback<CartProduct>() {
        override fun areItemsTheSame(
            oldItem: CartProduct,
            newItem: CartProduct
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CartProduct,
            newItem: CartProduct
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }

}