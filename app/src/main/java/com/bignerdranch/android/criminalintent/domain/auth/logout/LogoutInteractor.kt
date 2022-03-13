package com.bignerdranch.android.criminalintent.domain.auth.logout

import com.bignerdranch.android.criminalintent.domain.auth.repository.AuthRepositoryI
import javax.inject.Inject

class LogoutInteractor @Inject constructor(private val authRepository: AuthRepositoryI) : LogoutInteractorI {
    override suspend fun onLogout() = authRepository.logout()
}