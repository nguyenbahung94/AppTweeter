package com.example.billy.apptweeter.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.billy.apptweeter.R
import com.example.billy.apptweeter.databinding.ItemMessageBinding
import com.example.billy.apptweeter.model.Message
import com.example.billy.apptweeter.viewmodel.MessageViewModel

class MessageAdapter(private val mListMessage: MutableList<Message>) : RecyclerView.Adapter<MessageAdapter.BindingHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val binding = DataBindingUtil.inflate<ItemMessageBinding>(LayoutInflater.from(parent.context), R.layout.item_message, parent, false)
        return BindingHolder(binding)
    }

    override fun getItemCount(): Int {
        return mListMessage.size
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val binding = holder.bindingHolder
        binding.item = MessageViewModel(mListMessage[position])
    }


    class BindingHolder(var bindingHolder: ItemMessageBinding) : RecyclerView.ViewHolder(bindingHolder.mainLayout)
}