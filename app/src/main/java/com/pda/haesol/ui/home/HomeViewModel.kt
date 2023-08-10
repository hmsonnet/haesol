package com.pda.haesol.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    // MutableLiveData를 사용하여 문자열 데이터를 저장하고 초기값을 설정합니다.
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    // LiveData로 노출되는 불변의 데이터
    val text: LiveData<String> = _text
}