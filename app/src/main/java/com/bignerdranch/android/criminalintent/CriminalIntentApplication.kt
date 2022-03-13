package com.bignerdranch.android.criminalintent

import android.app.Application
import com.bignerdranch.android.criminalintent.data.repository.crime.CrimeRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CriminalIntentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}