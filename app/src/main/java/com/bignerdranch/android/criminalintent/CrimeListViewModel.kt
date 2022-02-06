package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.criminalintent.model.Crime

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
}