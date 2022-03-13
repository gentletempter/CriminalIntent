package com.bignerdranch.android.criminalintent.presentation.auth.sign_up

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.criminalintent.domain.auth.sign_up.SignUpInteractorI
import com.bignerdranch.android.criminalintent.utils.extensions.call
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val signUpInteractorI: SignUpInteractorI) :
    ViewModel() {

    val showEmailErrorLiveData = MutableLiveData<Unit>()
    val clearEmailErrorLiveData = MutableLiveData<Unit>()
    val showPasswordErrorLiveData = MutableLiveData<Unit>()
    val clearPasswordErrorLiveData = MutableLiveData<Unit>()
    val signUpSuccessLiveData = MutableLiveData<Unit>()
    val showProgressLiveData = MutableLiveData<Unit>()
    val hideProgressLiveData = MutableLiveData<Unit>()

    fun onSignUpClicked(email: String, password: String, repeatPassword: String) {
        showProgressLiveData.call()
        viewModelScope.launch(Dispatchers.IO) {
            val isEmailValid = signUpInteractorI.checkEmail(email)
            val isPasswordsValid = signUpInteractorI.checkPasswords(password, repeatPassword)

            if (!isEmailValid) {
                showEmailErrorLiveData.call()
                hideProgressLiveData.call()
                return@launch
            } else {
                clearEmailErrorLiveData.call()
            }

            if (!isPasswordsValid) {
                showPasswordErrorLiveData.call()
                hideProgressLiveData.call()
                return@launch
            } else {
                clearPasswordErrorLiveData.call()
            }

            signUpInteractorI.signUp(email, password)
            hideProgressLiveData.call()
            signUpSuccessLiveData.call()
        }
    }
}