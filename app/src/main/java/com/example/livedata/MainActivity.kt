package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.databinding.ActivityMainBinding
import com.example.livedata.model.CountTimerViewModel
import com.example.livedata.model.CountViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val countViewModel: CountViewModel by lazy {
        ViewModelProvider(this).get(CountViewModel::class.java)
    }

    private val countTimerViewModel: CountTimerViewModel by lazy {
        ViewModelProvider(this).get(CountTimerViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main)

        countViewModel.counterLiveData.observe(this){
            binding.textView.text = "$it"
        }

        binding.button.setOnClickListener {
            countViewModel.getCount()
        }

        countTimerViewModel.timerStartFun()
        countTimerViewModel.time.observe(this){
            binding.textView.text = it.toString()
        }

    }
}