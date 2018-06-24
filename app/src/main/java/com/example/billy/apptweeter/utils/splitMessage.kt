package com.example.billy.apptweeter.utils

fun String.checkLengthMessage(message: String): Boolean {
    return message.length <= 50
}