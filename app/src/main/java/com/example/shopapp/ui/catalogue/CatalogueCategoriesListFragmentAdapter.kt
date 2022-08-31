package com.example.shopapp.ui.catalogue

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.databinding.ItemCategoryBinding
import kotlinx.android.synthetic.main.item_category.view.*

class CatalogueCategoriesListFragmentAdapter :
    ListAdapter<Category, CatalogueCategoriesListFragmentAdapter.CatalogueCategoriesListFragmentViewHolder>(
        Comparator()
    ) {
    class CatalogueCategoriesListFragmentViewHolder(binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var categoryList = emptyList<Category>()

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
        holder.itemView.TextCategory.text = category.categoryName
    }

    override fun getItemCount(): Int = categoryList.size

    fun setList(list: List<Category>) {
        categoryList = list
        notifyDataSetChanged()
    }

    class Comparator : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(
            oldItem: Category,
            newItem: Category
        ): Boolean {
            return oldItem.categoryName == newItem.categoryName
        }

        override fun areContentsTheSame(
            oldItem: Category,
            newItem: Category
        ): Boolean {
            return oldItem.categoryName == newItem.categoryName
        }

    }
}