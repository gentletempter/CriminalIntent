package com.bignerdranch.android.criminalintent.data.repository.auth

import com.bignerdranch.android.criminalintent.data.data_sources.auth.LocalAuthDataSourceI
import com.bignerdranch.android.criminalintent.domain.auth.repository.AuthRepositoryI
import javax.inject.Inject

class AuthRepository @Inject constructor(private val localAuthDataSource: LocalAuthDataSourceI) :
    AuthRepositoryI {
    override suspend fun onSignIn(email: String, password: String): Boolean =
        localAuthDataSource.onSignIn(email, password)

    override suspend fun checkEmail(email: String): Boolean = localAuthDataSource.checkEmail(email)

    override suspend fun checkPasswords(password: String, repeatedPassword: String): Boolean =
        localAuthDataSource.checkPasswords(password, repeatedPassword)

    override suspend fun signUp(email: String, password: String) =
        localAuthDataSource.signUp(email, password)

    override suspend fun logout() = localAuthDataSource.logout()
}