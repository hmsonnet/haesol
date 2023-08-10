package com.pda.haesol.ui.demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DemoViewModel : ViewModel() {

    // MutableLiveData를 사용하여 데모 데이터 저장
    private val _demo = MutableLiveData<String>().apply {
        value = "Hello, Demo!"
    }

    // LiveData로 노출되는 불변의 데이터
    val demo: LiveData<String> = _demo

    // 값을 변경하기 위한 메서드
    fun updateDemoValue(newValue: String) {
        _demo.value = newValue
    }
}