package com.bignerdranch.android.criminalintent.domain.auth.sign_up

import com.bignerdranch.android.criminalintent.domain.auth.repository.AuthRepositoryI
import javax.inject.Inject

class SignUpInteractor @Inject constructor(private val authRepository: AuthRepositoryI) : SignUpInteractorI {
    override suspend fun checkEmail(email: String): Boolean = authRepository.checkEmail(email)

    override suspend fun checkPasswords(password: String, repeatedPassword: String): Boolean =
        authRepository.checkPasswords(password, repeatedPassword)

    override suspend fun signUp(email: String, password: String) = authRepository.signUp(email, password)
}