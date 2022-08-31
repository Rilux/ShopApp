package com.example.shopapp.ui.catalogue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.shopapp.R
import com.example.shopapp.databinding.FragmentCatalogueBinding
import com.example.shopapp.ui.registration.RegistrationFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogueBaseFragment : Fragment(R.layout.fragment_catalogue) {

    lateinit var binding: FragmentCatalogueBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogueBinding.inflate(layoutInflater)
        val view = binding.root

        parentFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view_tag, CatalogueCategoriesListFragment())
            .commit()

        return view
    }

}