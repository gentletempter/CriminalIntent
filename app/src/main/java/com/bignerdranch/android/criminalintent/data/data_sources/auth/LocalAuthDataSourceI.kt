package com.bignerdranch.android.criminalintent.data.data_sources.auth

interface LocalAuthDataSourceI {
    suspend fun onSignIn(email: String, password: String): Boolean
    suspend fun signUp(email: String, password: String)
    suspend fun checkEmail(email: String): Boolean
    suspend fun checkPasswords(password: String, repeatedPassword: String): Boolean
    suspend fun logout()
}