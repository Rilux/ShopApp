package com.example.shopapp.ui.catalogue.categoryList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopapp.R
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.databinding.FragmentCatalogueCategoriesListBinding
import com.example.shopapp.ui.catalogue.productListByCategory.ProductListByCategoryFragment
import com.example.shopapp.ui.login.LoginFragment
import com.example.shopapp.ui.sharedViewModels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CatalogueCategoriesListFragment : Fragment() {

    private lateinit var binding: FragmentCatalogueCategoriesListBinding
    private val viewModel: CatalogueCategoriesListFragmentViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var adapter: CatalogueCategoriesListFragmentAdapter
    private lateinit var recyclerview: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogueCategoriesListBinding.inflate(layoutInflater)
        val view = binding.root
        setRecycler()

        lifecycleScope.launch {
            viewModel.getCategoriesList()
        }
        viewModel.categories.observe(viewLifecycleOwner, Observer {
            adapter.setList(it)
        })

        return view
    }

    fun setRecycler() {
        recyclerview = binding.recyclerView
        adapter =
            CatalogueCategoriesListFragmentAdapter(object : CatalogueCategoriesListAdapterListener {

                override fun onCategoryClicked(category: Category) {
                    sharedViewModel.setCategory(category)
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view_tag, ProductListByCategoryFragment())
                        .commit()
                }
            })
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(context)
    }
}