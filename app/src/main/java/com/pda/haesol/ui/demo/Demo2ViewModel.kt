package com.pda.haesol.ui.demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Demo2ViewModel : ViewModel() {

    private val _button = MutableLiveData<String>().apply {
        value = "This is demo2 Fragment"
    }
    val button: MutableLiveData<String> = _button
}