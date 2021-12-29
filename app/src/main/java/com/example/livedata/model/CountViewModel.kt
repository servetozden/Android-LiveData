package com.example.livedata.model

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {

    private var count = 20

    val counterLiveData: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun getCount(){
        count++
        counterLiveData.value = count
    }


}