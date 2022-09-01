package com.example.shopapp.ui.catalogue.productListByCategory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopapp.R
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.databinding.FragmentProductListByCategoryBinding
import com.example.shopapp.ui.catalogue.categoryList.CatalogueCategoriesListFragment
import com.example.shopapp.ui.main.MainPageActionListener
import com.example.shopapp.ui.main.MainPageFragmentAdapter
import com.example.shopapp.ui.registration.RegistrationFragment
import com.example.shopapp.ui.sharedViewModels.SharedViewModel
import com.example.shopapp.utils.extensions.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductListByCategoryFragment : Fragment(R.layout.fragment_product_list_by_category) {
    private lateinit var binding: FragmentProductListByCategoryBinding

    private lateinit var adapter: MainPageFragmentAdapter
    private lateinit var recyclerview: RecyclerView

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: ProductListByCategoryFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductListByCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        drawRecyclerView()

        sharedViewModel.chosenCategory.observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                viewModel.getProductsByCategory(it)
            }
        })

        viewModel.productslist.observe(viewLifecycleOwner, Observer {
            adapter.setList(it)
        })

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_tag, CatalogueCategoriesListFragment())
                .commit()
        }
        return view
    }


    private fun drawRecyclerView() {
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.recycler_view_item_width)
        recyclerview = binding.recyclerViewProductsListByCategory
        adapter = MainPageFragmentAdapter(object : MainPageActionListener {
            override fun onAddToCartClicked(product: Product) {
                lifecycleScope.launch {
                    sharedViewModel.addToCart(product)
                }
            }

            override fun onDetailedViewClicked(product: Product) {
                sharedViewModel.setChosenProduct(product)
                findNavController().navigate(R.id.action_rootFragment_to_productDetailedFragment)
            }

        })
        recyclerview.adapter = adapter
        recyclerview.layoutManager = GridLayoutManager(context, 2)
        recyclerview.addItemDecoration(GridSpacingItemDecoration(2, spacingInPixels, true, 0))
    }
}