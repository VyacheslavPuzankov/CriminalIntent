package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.criminalintent.repository.CrimeRepository

class CrimeListViewModel: ViewModel() {
    private val crimeRepository =
        CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
}