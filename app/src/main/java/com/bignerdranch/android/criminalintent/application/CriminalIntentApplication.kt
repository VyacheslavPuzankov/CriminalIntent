package com.bignerdranch.android.criminalintent.application

import android.app.Application
import com.bignerdranch.android.criminalintent.repository.CrimeRepository

class CriminalIntentApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}
//Это подкласс приложения, он создан чтобы переопределить функцию onCreate()
// и добавить в нее инициализацию репозитория