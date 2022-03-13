package com.bignerdranch.android.criminalintent.presentation.contract

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {
    fun goToSignIn()
    fun goToSignUp()
    fun goToCrimeList()
    fun showLogOutDialog()
    fun clearBackStack()
}