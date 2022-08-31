package com.example.shopapp.ui.registration

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopapp.R
import com.example.shopapp.databinding.FragmentRegistrationBinding
import com.example.shopapp.ui.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        val view = binding.root
        binding.buttonRegis.setOnClickListener {
            Log.d("MyLog", "RegisterFragmentButtonClicked")

        }

        return view
    }
}