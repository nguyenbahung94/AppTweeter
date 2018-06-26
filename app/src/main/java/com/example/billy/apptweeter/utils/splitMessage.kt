package com.example.billy.apptweeter.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.util.regex.Pattern

/*
* slit message
* */
fun splitMessage(message: String): String {
    var allMessage: String? = ""
    if (message.length <= 50) {
        return message
    } else {
        val listSplitMessage = mutableListOf<String>()
        var dem = 0
        var itemMessage = ""
        var positionOfSpace = 0
        for (i in 0 until message.length) {
            if (dem == 46) {
                if (message[dem++] == ' ') {
                    listSplitMessage.add(itemMessage)
                    itemMessage = ""
                    dem = 0
                } else {
                    val tam = i - positionOfSpace
                    val length = itemMessage.length - tam
                    val messageFirst = itemMessage.substring(0, length)
                    val messageSecond = itemMessage.substring(length, itemMessage.length).trim()
                    listSplitMessage.add(messageFirst)
                    dem = 0
                    itemMessage = messageSecond + message[i]
                }
            } else {
                if (!(dem == 0 && message[i] == ' ')) {
                    itemMessage += message[i]
                    dem++
                }

            }
            //remember position of space for subString
            if (message[i] == ' ') {
                positionOfSpace = i
            }
            if (i == message.length - 1) {
                listSplitMessage.add(itemMessage)

            }

        }
        for (j in 0 until listSplitMessage.size) {
            allMessage += when (j) {
                0 -> "[" + '"' + "${j + 1}/${listSplitMessage.size} " + listSplitMessage[j] + '"'
                listSplitMessage.size - 1 -> "," + '"' + " ${j + 1}/${listSplitMessage.size} " + listSplitMessage[j] + '"' + "]"
                else -> "," + '"' + "${j + 1}/${listSplitMessage.size} " + listSplitMessage[j] + '"'
            }
        }
    }
    return allMessage!!
}

/*
not contain space and length more than 50
* */
fun hasSpace(message: String): Boolean {
    var contain = message.contains(' ')
    var leng = message.length > 50
    return !message.contains(' ') && message.length > 50
}

/*
contain any character or number
* */
fun containCharacter(message: String): Boolean {
    return Pattern.matches(".*[a-zA-Z].*", message) || Pattern.matches(".*[0-9].*", message)
}

/*
* hide keyboard when scrolling recycleview
* */
fun hideKeyboard(view: View, context: Context) {
    val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}
