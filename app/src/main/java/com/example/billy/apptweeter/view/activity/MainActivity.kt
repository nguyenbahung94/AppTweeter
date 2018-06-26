package com.example.billy.apptweeter.view.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.billy.apptweeter.R
import com.example.billy.apptweeter.databinding.ActivityMainBinding
import com.example.billy.apptweeter.model.Message
import com.example.billy.apptweeter.utils.*
import com.example.billy.apptweeter.view.adapter.MessageAdapter

class MainActivity : AppCompatActivity() {
    private val mListMessage = mutableListOf<Message>()
    private lateinit var tvMessage: EditText
    private var adapter: MessageAdapter? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val layoutManager = LinearLayoutManager(this)

        binding.mRecycleView.layoutManager = layoutManager
        tvMessage = this.findViewById(R.id.tvmessage)
        // var messages = TestMessages.mockMessageData

        adapter = MessageAdapter(mListMessage)
        binding.mRecycleView.adapter = adapter
        binding.mRecycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                hideKeyboard(recyclerView!!, this@MainActivity)
            }
        })

    }

    /*
    * note :if message contain only space I will show message error
    * remove space before start and end of message only keep space between small string of message
    * */
    fun onClickAddMessage(view: View) {
        if (!tvMessage.text.isEmpty()) {
            if (!containCharacter(tvMessage.text.toString())) {
                Toast.makeText(this, getString(R.string.toast_error_only_space), Toast.LENGTH_SHORT).show()
                return
            }
            val boolean = hasSpace(tvMessage.text.toString())
            if (boolean) {
                Toast.makeText(this, getString(R.string.toast_error_input_invalid), Toast.LENGTH_SHORT).show()
            } else {
                val msg = Message()
                msg.message = splitMessage(tvMessage.text.toString().trim())
                mListMessage.add(msg)
                adapter!!.notifyDataSetChanged()
            }
        } else {
            Toast.makeText(this, getString(R.string.toast_error_cant_be_empty), Toast.LENGTH_SHORT).show()
        }
    }

}
