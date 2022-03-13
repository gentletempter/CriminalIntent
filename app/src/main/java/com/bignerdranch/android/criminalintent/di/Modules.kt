package com.bignerdranch.android.criminalintent.di

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.criminalintent.data.data_sources.auth.LocalAuthDataSource
import com.bignerdranch.android.criminalintent.data.data_sources.auth.LocalAuthDataSourceI
import com.bignerdranch.android.criminalintent.data.local.AppRoomDB
import com.bignerdranch.android.criminalintent.data.local.UserDao
import com.bignerdranch.android.criminalintent.data.preferences.AppSharedPreferences
import com.bignerdranch.android.criminalintent.data.preferences.PreferencesI
import com.bignerdranch.android.criminalintent.data.repository.auth.AuthRepository
import com.bignerdranch.android.criminalintent.domain.auth.logout.LogoutInteractor
import com.bignerdranch.android.criminalintent.domain.auth.logout.LogoutInteractorI
import com.bignerdranch.android.criminalintent.domain.auth.repository.AuthRepositoryI
import com.bignerdranch.android.criminalintent.domain.auth.sign_in.SignInInteractor
import com.bignerdranch.android.criminalintent.domain.auth.sign_in.SignInInteractorI
import com.bignerdranch.android.criminalintent.domain.auth.sign_up.SignUpInteractor
import com.bignerdranch.android.criminalintent.domain.auth.sign_up.SignUpInteractorI
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
abstract class BindsModules {

    @Binds
    abstract fun bindPreferences(
        appSharedPreferences: AppSharedPreferences
    ): PreferencesI
}

@InstallIn(ViewModelComponent::class)
@Module
abstract class BindViewModelModules {
    @Binds
    abstract fun bindPreferences(
        appSharedPreferences: AppSharedPreferences
    ): PreferencesI

    @Binds
    abstract fun bindSignInInteractor(
        signInInteractor: SignInInteractor
    ): SignInInteractorI

    @Binds
    abstract fun bindSignUpInteractor(
        signInInteractor: SignUpInteractor
    ): SignUpInteractorI

    @Binds
    abstract fun bindLogoutInteractor(
        logoutInteractor: LogoutInteractor
    ): LogoutInteractorI

    @Binds
    abstract fun bindLocalSigInDataSource(
        LocalAuthDataSource: LocalAuthDataSource
    ): LocalAuthDataSourceI

    @Binds
    abstract fun bindSignInRepository(
        authRepository: AuthRepository
    ): AuthRepositoryI
}

@InstallIn(ViewModelComponent::class)
@Module
class ProvideViewModelModules {

//    @Provides
//    fun bindCrimeDao(@ApplicationContext context: Context): CrimeDao {
//        val appRoom = Room.databaseBuilder(context, AppRoomDB::class.java, "AppRoomDB").build()
//        return appRoom.getCrimeDao()
//    }

    @Provides
    fun bindUserDao(@ApplicationContext context: Context): UserDao {
        val appRoom = Room.databaseBuilder(context, AppRoomDB::class.java, "AppRoomDB").build()
        return appRoom.getUserDao()
    }
}