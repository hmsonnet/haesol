package com.pda.haesol.ui.demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    fun setData(newData: String) {
        _data.value = newData
    }
}