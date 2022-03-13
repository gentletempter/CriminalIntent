package com.bignerdranch.android.criminalintent.utils.extensions

import androidx.lifecycle.MutableLiveData

fun MutableLiveData<Unit>?.call() {
    this?.postValue(Unit)
}