package com.example.billy.apptweeter.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.billy.apptweeter.BR
import com.example.billy.apptweeter.model.Message

class MessageViewModel(private val message: Message) : BaseObservable() {
    var getMessage: String?
        @Bindable
        get() = message.messsage
        set(value) {
            message.messsage = value
            notifyPropertyChanged(BR.getMessage)
        }
}