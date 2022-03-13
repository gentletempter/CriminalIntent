package com.bignerdranch.android.criminalintent.presentation.auth.sign_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.bignerdranch.android.criminalintent.R
import com.bignerdranch.android.criminalintent.databinding.LayoutSignInBinding
import com.bignerdranch.android.criminalintent.presentation.auth.base.BaseAuthFragment
import com.bignerdranch.android.criminalintent.presentation.contract.navigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseAuthFragment() {

    private var binding: LayoutSignInBinding? = null

    private val viewModel by viewModels<SignInViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LayoutSignInBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (binding?.inputLayoutLogin?.editText?.text?.isBlank() == true) {
            ContextCompat.getColorStateList(requireContext(), R.color.auth_input_layout_stroke_color_default)?.let {
                binding?.inputLayoutLogin?.setBoxStrokeColorStateList(it)
            }
        } else {
            ContextCompat.getColorStateList(requireContext(), R.color.auth_input_layout_stroke_color)?.let { colorList ->
                binding?.inputLayoutLogin?.setBoxStrokeColorStateList(colorList)
            }
        }

        initListeners()
        subscribeOnLiveData()
    }

    private fun initListeners() {
        binding?.inputLayoutLogin?.editText?.addTextChangedListener {
            it?.let {
                if (it.isBlank()) {
                    ContextCompat.getColorStateList(requireContext(), R.color.auth_input_layout_stroke_color_default)?.let { colorList ->
                        binding?.inputLayoutLogin?.setBoxStrokeColorStateList(colorList)
                    }
                } else {
                    ContextCompat.getColorStateList(requireContext(), R.color.auth_input_layout_stroke_color)?.let { colorList ->
                        binding?.inputLayoutLogin?.setBoxStrokeColorStateList(colorList)
                    }
                }
            }
        }
        binding?.buttonSignIn?.setOnClickListener {
            val email = binding?.inputLayoutLogin?.editText?.text.toString()
            val password = binding?.inputLayoutPassword?.editText?.text.toString()
            viewModel.onSignInClicked(email, password)
        }
        binding?.buttonSignUp?.setOnClickListener {
            navigator().goToSignUp()
        }
    }

    private fun subscribeOnLiveData() {
        viewModel.showCredentialsErrorLiveData.observe(viewLifecycleOwner, {
            binding?.inputLayoutLogin?.error = getString(R.string.auth_sign_in_credentials_incorrect)
            binding?.inputLayoutPassword?.error = getString(R.string.auth_sign_in_credentials_incorrect)
        })
        viewModel.signInSuccessLiveData.observe(viewLifecycleOwner, {
            navigator().goToCrimeList()
        })
        viewModel.showProgressLiveData.observe(viewLifecycleOwner, {
            binding?.progress?.isVisible = true
        })
        viewModel.hideProgressLiveData.observe(viewLifecycleOwner, {
            binding?.progress?.isVisible = false
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}