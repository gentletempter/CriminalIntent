package com.bignerdranch.android.criminalintent.presentation.auth.sign_in

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.criminalintent.domain.auth.sign_in.SignInInteractorI
import com.bignerdranch.android.criminalintent.utils.extensions.call
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val signInInteractorI: SignInInteractorI) : ViewModel() {

    val showCredentialsErrorLiveData = MutableLiveData<Unit>()
    val signInSuccessLiveData = MutableLiveData<Unit>()
    val showProgressLiveData = MutableLiveData<Unit>()
    val hideProgressLiveData = MutableLiveData<Unit>()

    fun onSignInClicked(email: String, password: String) {
        showProgressLiveData.call()
        viewModelScope.launch(Dispatchers.IO) {
            val isSignInSuccess = signInInteractorI.onSignIn(email, password)

            if (isSignInSuccess) {
                signInSuccessLiveData.call()
            } else {
                showCredentialsErrorLiveData.call()
            }
            hideProgressLiveData.call()
        }
    }
}