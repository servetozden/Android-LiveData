package com.example.livedata.model

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountTimerViewModel: ViewModel() {


    private val countTime = MutableLiveData<Long>()
    val time: LiveData<Long>

        get() = countTime


    fun timerStartFun() {
        val timer = object : CountDownTimer(100000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countTime.value=millisUntilFinished/1000
            }
            override fun onFinish() {
            }
        }
        timer?.start()
    }
}