package com.bignerdranch.android.criminalintent.domain.auth.repository

interface AuthRepositoryI {
    suspend fun onSignIn(email: String, password: String): Boolean
    suspend fun checkEmail(email: String): Boolean
    suspend fun checkPasswords(password: String, repeatedPassword: String): Boolean
    suspend fun signUp(email: String, password: String)
    suspend fun logout()
}