package com.example.billy.apptweeter.test

import com.example.billy.apptweeter.model.Message
import java.util.*

object TestMessages {
    val mockMessageData: List<Message>
        get() {
            val list = ArrayList<Message>()
            for (i in 0..24) {
                val message = "La cita de referencia en España para los profesionales del marketing online vuelve al World Trade Center. Zaragoza acoge cada año a cientos de profesionales para aprender sobre SEO, Social Media, Analítica y Optimización, Desarrollo, actualizarse con los últimos cambios en Internet y realizar mucho… mucho networking."
                val article = Message()
                article.message = message
                list.add(article)
            }
            return list
        }
}