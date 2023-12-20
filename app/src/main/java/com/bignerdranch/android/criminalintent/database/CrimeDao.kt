package com.bignerdranch.android.criminalintent.database

import androidx.room.Dao
import androidx.room.Query
import com.bignerdranch.android.criminalintent.Crime
import java.util.*

@Dao
interface CrimeDao {
    @Query("SELECT * FROM crime")
    fun getCrimes(): List<Crime>
    @Query("SELECT * FROM crime WHERE id=(:id)")
    fun getCrime(id: UUID): Crime?
//Query добавляет две функции для извлечения данных (списка преступлений и UUID) 
}
//Dao интерфейс с функциями баз данных, который позволяет получить список всех преступлений
// либо UUID конкретного преступления

