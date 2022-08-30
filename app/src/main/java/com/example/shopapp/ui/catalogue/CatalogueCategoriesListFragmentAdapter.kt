package com.example.shopapp.ui.catalogue

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shopapp.databinding.ItemCategoryBinding
import kotlinx.android.synthetic.main.item_category.view.*

class CatalogueCategoriesListFragmentAdapter :
    ListAdapter<String, CatalogueCategoriesListFragmentAdapter.CatalogueCategoriesListFragmentViewHolder>(
        Comparator()
    ) {
    class CatalogueCategoriesListFragmentViewHolder(binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var categoryList = emptyList<String>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatalogueCategoriesListFragmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(inflater, parent, false)


        return CatalogueCategoriesListFragmentViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CatalogueCategoriesListFragmentViewHolder,
        position: Int
    ) {
        val category = categoryList[position]
        holder.itemView.TextCategory.text = category
    }

    override fun getItemCount(): Int = categoryList.size

    fun setList(list: List<String>) {
        categoryList = list
        notifyDataSetChanged()
    }

    class Comparator : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }

    }
}