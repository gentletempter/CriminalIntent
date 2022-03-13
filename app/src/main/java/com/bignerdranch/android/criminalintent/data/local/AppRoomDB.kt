package com.bignerdranch.android.criminalintent.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bignerdranch.android.criminalintent.model.local.crime.Crime
import com.bignerdranch.android.criminalintent.model.local.user.UserEntity

@Database(
    entities = [UserEntity::class, Crime::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(CrimeTypeConverters::class)

abstract class AppRoomDB : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getCrimeDao(): CrimeDao
}