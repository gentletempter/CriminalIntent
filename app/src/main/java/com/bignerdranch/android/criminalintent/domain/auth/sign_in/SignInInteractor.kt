package com.bignerdranch.android.criminalintent.domain.auth.sign_in

import com.bignerdranch.android.criminalintent.domain.auth.repository.AuthRepositoryI
import javax.inject.Inject

class SignInInteractor @Inject constructor(private val authRepository: AuthRepositoryI) : SignInInteractorI {
    override suspend fun onSignIn(email: String, password: String): Boolean = authRepository.onSignIn(email, password)
}