package com.bignerdranch.android.criminalintent.presentation.auth.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bignerdranch.android.criminalintent.data.preferences.PreferencesI
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseAuthFragment : Fragment() {
//    @Inject
//    lateinit var preferences: PreferencesI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        if (preferences.getUserToken().isNotBlank()) {
//        }
    }
}