package com.llama.petmilly_client.fcm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.llama.petmilly_client.R


class NotificationActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            ButtonWithNotification()
        }
    }
    
}
@Composable
fun ButtonWithNotification() {
    val context = LocalContext.current

    Button(
        onClick = { sendNotification(context) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Send Notification")
    }

}


private fun sendNotification(context: Context) {
    val notificationManager =
        ContextCompat.getSystemService(context, NotificationManager::class.java) as NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            "CHANNEL_ID",
            "CHANNEL_NAME",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "This is the notification channel"
        }
        notificationManager.createNotificationChannel(channel)
    }

    val notification = NotificationCompat.Builder(context, "CHANNEL_ID")
        .setContentTitle("Notification Title")
        .setContentText("Notification Text")
        .setSmallIcon(R.drawable.icon_main_puppy)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()

    notificationManager.notify(0, notification)
}

