package com.example.mvvm_assignment_01.ui.main

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _inputText = MutableLiveData<String>().apply {
        value = ""
    }
    var text : LiveData<String> = _inputText



    fun update(data: TextView, input: CharSequence) {
        var rtrn = ""
        var t = data.text.toString()
        if(input.length > t.length){
            rtrn = t+ input[t.length]
        }else if(input.length<t.length){
            rtrn = t.substring(0, t.length -1)
        }

        data.text = rtrn

    }
}