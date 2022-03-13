package com.bignerdranch.android.criminalintent.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bignerdranch.android.criminalintent.model.local.user.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

    @Query("SELECT * from UserEntity WHERE login LIKE :login")
    suspend fun getUser(login: String): UserEntity?
}