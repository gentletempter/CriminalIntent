package com.bignerdranch.android.criminalintent.presentation.content.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import com.bignerdranch.android.criminalintent.R
import com.bignerdranch.android.criminalintent.presentation.contract.navigator

class LogOutDialogFragment : DialogFragment() {

    private var listener: LogOutListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_logout_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<AppCompatButton>(R.id.logout_cancel).setOnClickListener {
            navigator().apply {
                clearBackStack()
                goToCrimeList()
            }
        }
        view.findViewById<AppCompatButton>(R.id.logout_yes).setOnClickListener {
            listener?.onLogOut()
            navigator().apply {
                clearBackStack()
                goToSignIn()
            }
        }
    }

    fun setLogOutListener(listener: LogOutListener) {
        this.listener = listener
    }
}