package com.bignerdranch.android.criminalintent.domain.auth.sign_up

interface SignUpInteractorI {
    suspend fun checkEmail(email: String): Boolean
    suspend fun checkPasswords(password: String, repeatedPassword: String): Boolean
    suspend fun signUp(email: String, password: String)
}