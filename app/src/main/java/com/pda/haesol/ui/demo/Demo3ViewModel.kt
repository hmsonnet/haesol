package com.pda.haesol.ui.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pda.haesol.databinding.FragmentDemo2Binding

class Demo3ViewModel : ViewModel() {

    private val _textViewValue = MutableLiveData<String>().apply {
        value = "This is demo3 Fragment"
    }

    val textViewValue: MutableLiveData<String> = _textViewValue

}