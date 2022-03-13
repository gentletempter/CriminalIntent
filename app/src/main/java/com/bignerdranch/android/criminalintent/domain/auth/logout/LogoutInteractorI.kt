package com.bignerdranch.android.criminalintent.domain.auth.logout

interface LogoutInteractorI {
    suspend fun onLogout()
}