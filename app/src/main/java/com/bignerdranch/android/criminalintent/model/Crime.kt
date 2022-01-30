package com.bignerdranch.android.criminalintent.model

import android.text.format.DateFormat
import java.util.*

data class Crime(
    val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: String = DateFormat.format("EEEE, dd MMMM yyyy", Date()).toString(),
    var isSolved: Boolean = false,
    var requiresPolice: Boolean = false
)