package com.bignerdranch.android.criminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bignerdranch.android.criminalintent.Crime

@Database(entities = [Crime::class ],
    version=1, exportSchema = false)
@TypeConverters(CrimeTypeConverters::class)
// Подключение конвертера в структуру базы данных
abstract class CrimeDatabase : RoomDatabase() {
    abstract fun crimeDao(): CrimeDao
    //абстрактная фунция создает экзмпляр DAO
}
//Аннотация database добавляет базу данных, объявляя сущность - crime и версию базы данных