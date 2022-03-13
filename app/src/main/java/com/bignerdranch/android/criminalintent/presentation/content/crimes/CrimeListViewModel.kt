package com.bignerdranch.android.criminalintent.presentation.content.crimes

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.criminalintent.data.repository.crime.CrimeRepository
import com.bignerdranch.android.criminalintent.model.local.crime.Crime

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()

    fun addCrime(crime: Crime) {
        crimeRepository.addCrime(crime)
    }
}