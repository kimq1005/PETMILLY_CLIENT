package com.llama.petmilly_client.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

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

    fun convertAddress(address: String): String {
        val keywords = address.split(" ")
        return if (keywords.size > 2) "${keywords[1]} ${keywords.last()}" else "${keywords[0]} ${keywords[1]}"
    }

    //1/18 (수요일) - 17시 형태로 바꾸는 함수
    @RequiresApi(Build.VERSION_CODES.O)
    fun convertmoveservicetime(dateStr: String): String {
        val date = Instant.parse(dateStr).atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime()
        val month = date.monthValue
        val day = date.dayOfMonth
        val dayOfWeek = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN)
        val hour = date.hour
        return "$month/$day ($dayOfWeek) - ${hour}시"
    }



}