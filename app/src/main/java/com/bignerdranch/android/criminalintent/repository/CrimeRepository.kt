package com.bignerdranch.android.criminalintent.repository

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.criminalintent.Crime
import com.bignerdranch.android.criminalintent.database.CrimeDatabase
import java.util.*

private const val DATABASE_NAME = "crime-database"
class CrimeRepository private constructor( context: Context){
    private val database : CrimeDatabase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    ).build()
    private val crimeDao = database.crimeDao()
    fun getCrimes(): List<Crime> = crimeDao.getCrimes()
    fun getCrime(id: UUID): Crime? = crimeDao.getCrime(id)
    companion object {
        private var INSTANCE: CrimeRepository? = null
        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = CrimeRepository(context)
            }
        }
        fun get(): CrimeRepository {
            return INSTANCE?: throw
                    java.lang.IllegalStateException("CrimeRepository must be initialized")
        }
    }
}
//Репозиторий нужен чтобы передавать данные между классами контроллера и выдавать данные
//о преступлении
//Функция Room.databaseBuilder() создает конкретную
// реализацию вашего абстрактного класса CrimeDatabase