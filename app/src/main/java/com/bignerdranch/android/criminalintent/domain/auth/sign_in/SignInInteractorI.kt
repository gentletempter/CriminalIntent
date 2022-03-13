package com.bignerdranch.android.criminalintent.domain.auth.sign_in

interface SignInInteractorI {
    suspend fun onSignIn(email: String, password: String): Boolean
}