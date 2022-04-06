package com.example.fragments.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstNumViewModel: ViewModel() {
    private val mutableNum = MutableLiveData<Int>(1)

    val num: LiveData<Int> get() = mutableNum

    fun increase() {
        mutableNum.value = mutableNum.value?.plus(1)
    }

    fun decrease() {
        mutableNum.value = mutableNum.value?.minus(1)
    }
}