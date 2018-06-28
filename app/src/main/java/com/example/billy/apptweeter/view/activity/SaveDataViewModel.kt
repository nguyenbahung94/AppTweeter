package com.example.billy.apptweeter.view.activity

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.billy.apptweeter.model.Message

class SaveDataViewModel : ViewModel() {
    var message: String = ""
    var mListMessage = MutableLiveData<List<Message>>()

    fun setMessages(mgs: String) {
        message = mgs
    }

    fun getMessages(): String {
        return message
    }
}