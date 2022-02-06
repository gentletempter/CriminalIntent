package com.bignerdranch.android.criminalintent.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Crime(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    //var date: String = DateFormat.format("EEEE, dd MMMM yyyy", Date()).toString(),
    var isSolved: Boolean = false,
    //var requiresPolice: Boolean = false
)