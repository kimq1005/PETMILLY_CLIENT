package com.llama.petmilly_client.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object CommonObject {

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertTimetoHour(dateTimeString :String) :String {
        val formatter = DateTimeFormatter.ISO_DATE_TIME
        val dateTime = LocalDateTime.parse(dateTimeString, formatter)

        val now = LocalDateTime.now()
        val duration = Duration.between(dateTime, now)

        return when {
            duration.toDays() >= 30 -> "${duration.toDays() / 30}달 전"
            duration.toDays() > 0 -> "${duration.toDays()}일 전"
            duration.toHours() > 0 -> "${duration.toHours()}시간 전"
            else -> "방금 전"
        }
    }


}