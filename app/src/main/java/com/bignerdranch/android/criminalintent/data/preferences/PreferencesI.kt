package com.bignerdranch.android.criminalintent.data.preferences

interface PreferencesI {
    fun saveEmail(email: String)
    fun savePassword(password: String)
    fun getEmail(): String
    fun getPassword(): String
    fun saveUserToken(token: Int?)
    fun getUserToken(): String
}