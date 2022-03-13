package com.bignerdranch.android.criminalintent.presentation.auth.sign_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.bignerdranch.android.criminalintent.R
import com.bignerdranch.android.criminalintent.presentation.auth.base.BaseAuthFragment
import com.bignerdranch.android.criminalintent.presentation.contract.navigator
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseAuthFragment() {

    private lateinit var progress: ProgressBar
    private lateinit var overlay: FrameLayout
    private lateinit var loginField: TextInputLayout
    private lateinit var passwordField: TextInputLayout
    private lateinit var repeatPasswordField: TextInputLayout
    private lateinit var buttonSignUp: AppCompatButton
    private lateinit var buttonSignIn: AppCompatTextView

    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSignUp = view.findViewById(R.id.button_sign_up)
        buttonSignIn = view.findViewById(R.id.button_sign_in)
        loginField = view.findViewById(R.id.input_layout_login)
        passwordField = view.findViewById(R.id.input_layout_password)
        repeatPasswordField = view.findViewById(R.id.input_layout_repeat_password)
        overlay = view.findViewById(R.id.overlay_container)
        progress = view.findViewById(R.id.progress)

        if (loginField.editText?.text?.isBlank() == true) {
            ContextCompat.getColorStateList(
                requireContext(),
                R.color.auth_input_layout_stroke_color_default
            )?.let {
                loginField.setBoxStrokeColorStateList(it)
            }
        } else {
            ContextCompat.getColorStateList(
                requireContext(),
                R.color.auth_input_layout_stroke_color
            )?.let { colorList ->
                loginField.setBoxStrokeColorStateList(colorList)
            }
        }

        initListeners()
        subscribeOnLiveData()
    }

    private fun initListeners() {
        loginField.editText?.addTextChangedListener {
            it?.let {
                if (it.isBlank()) {
                    ContextCompat.getColorStateList(
                        requireContext(),
                        R.color.auth_input_layout_stroke_color_default
                    )?.let { colorList ->
                        loginField.setBoxStrokeColorStateList(colorList)
                    }
                } else {
                    ContextCompat.getColorStateList(
                        requireContext(),
                        R.color.auth_input_layout_stroke_color
                    )?.let { colorList ->
                        loginField.setBoxStrokeColorStateList(colorList)
                    }
                }
            }
        }
        buttonSignUp.setOnClickListener {
            val email = loginField.editText?.text.toString()
            val password = passwordField.editText?.text.toString()
            val repeatPassword = repeatPasswordField.editText?.text.toString()

            viewModel.onSignUpClicked(email, password, repeatPassword)
        }
        buttonSignIn.setOnClickListener {
            //this.findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }

    private fun subscribeOnLiveData() {
        viewModel.showEmailErrorLiveData.observe(viewLifecycleOwner, {
            loginField.error = getString(R.string.auth_sign_up_email_incorrect)
        })
        viewModel.showPasswordErrorLiveData.observe(viewLifecycleOwner, {
            passwordField.error = getString(R.string.auth_sign_up_password_incorrect)
            repeatPasswordField.error = getString(R.string.auth_sign_up_password_incorrect)
        })
        viewModel.clearEmailErrorLiveData.observe(viewLifecycleOwner, {
            loginField.error = null
        })
        viewModel.clearPasswordErrorLiveData.observe(viewLifecycleOwner, {
            passwordField.error = null
            repeatPasswordField.error = null
        })
        viewModel.signUpSuccessLiveData.observe(viewLifecycleOwner, {
            navigator().goToCrimeList()
        })
        viewModel.showProgressLiveData.observe(viewLifecycleOwner, {
            progress.isVisible = true
        })
        viewModel.hideProgressLiveData.observe(viewLifecycleOwner, {
            progress.isVisible = false
        })
    }
}