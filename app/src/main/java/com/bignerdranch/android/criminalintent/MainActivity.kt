package com.bignerdranch.android.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bignerdranch.android.criminalintent.data.preferences.PreferencesI
import com.bignerdranch.android.criminalintent.presentation.auth.sign_in.SignInFragment
import com.bignerdranch.android.criminalintent.presentation.auth.sign_up.SignUpFragment
import com.bignerdranch.android.criminalintent.presentation.content.base.LogOutDialogFragment
import com.bignerdranch.android.criminalintent.presentation.content.crimes.CrimeFragment
import com.bignerdranch.android.criminalintent.presentation.content.crimes.CrimeListFragment
import com.bignerdranch.android.criminalintent.presentation.contract.Navigator
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CrimeListFragment.Callbacks, Navigator {
    @Inject
    lateinit var preferences: PreferencesI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (preferences.getUserToken().isNotBlank()) {
            goToCrimeList()
        } else {
            goToSignIn()
        }
    }

    override fun onBackPressed() {
        val fragmentCount = supportFragmentManager.backStackEntryCount
        if (fragmentCount > 1) {
            super.onBackPressed()
        } else {
            finish()
        }
    }

    override fun onCrimeSelected(crimeID: UUID) {
        val fragment = CrimeFragment.newInstance(crimeID)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun goToSignIn() {
        launchFragment(SignInFragment())
    }

    override fun goToSignUp() {
        launchFragment(SignUpFragment())
    }

    override fun goToCrimeList() {
        launchFragment(CrimeListFragment())
    }

    override fun showLogOutDialog() {
        launchFragment(LogOutDialogFragment())
    }

    override fun clearBackStack() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}