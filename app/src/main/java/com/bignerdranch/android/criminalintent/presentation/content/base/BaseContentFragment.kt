package com.bignerdranch.android.criminalintent.presentation.content.base

import androidx.fragment.app.Fragment

abstract class BaseContentFragment : Fragment(), LogOutListener {

    fun showLogoutDialog() {
        val supportFragment = requireActivity().supportFragmentManager
        val logOutDialogFragment = LogOutDialogFragment()
        logOutDialogFragment.setLogOutListener(this)
        logOutDialogFragment.show(supportFragment, "LogOutDialogFragment")
    }
}