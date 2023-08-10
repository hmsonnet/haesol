package com.pda.haesol.ui.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleViewModel : ViewModel() {

    // MutableLiveData를 사용하여 샘플 데이터 저장
    private val _sample = MutableLiveData<String>().apply {
        value = "Hello, ViewModel!"
    }

    // LiveData로 노출되는 불변의 데이터
    val sample: LiveData<String> = _sample

    // 데이터 업데이트를 위한 함수
    fun updateSample(newData: String) {
        _sample.value = newData
    }

}