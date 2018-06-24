package com.example.billy.apptweeter.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.billy.apptweeter.R
import com.example.billy.apptweeter.databinding.ActivityMainBinding
import com.example.billy.apptweeter.test.TestMessages

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val layoutManager = LinearLayoutManager(this)

        binding.mRecycleView.layoutManager = layoutManager

        var messages = TestMessages.mockMessageData

        val adapter = MessageAdapter(messages)
        binding.mRecycleView.adapter = adapter

    }
}
