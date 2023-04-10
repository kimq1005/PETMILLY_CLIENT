package com.llama.petmilly_client.mqtt

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.data.di.DataModule.BASE_URL
import com.llama.petmilly_client.utils.SpacerHeight
import com.llama.petmilly_client.utils.notosans_bold
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import org.eclipse.paho.client.mqttv3.*
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import java.util.*


class MqttActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MqttClientScreen()
        }
    }
}


@Composable
fun MqttClientScreen() {
    val client by remember { mutableStateOf(createMqttClient()) }
    val messages = remember { mutableStateListOf<String>() }
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        // Show received messages
        LazyColumn {
            items(messages) { message ->
                Text(text = message)
            }
        }

        // Text input and send button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(text = "Enter a message") },
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    if (text.isNotBlank()) {
                        client.publish("my/topic", text.toByteArray(), 0, false)
                        text = ""
                    }
                },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Send")
            }
        }
    }

    // Connect to the broker when the composable is first shown
    LaunchedEffect(client) {
        if (client.isConnected) {
            client.disconnect()
        } else {
            try {
                val options = MqttConnectOptions()
                options.isAutomaticReconnect = true
                client.connect()
//        client.subscribe("my/topic") { _, message ->
//            messages.add(message.toString())
//        }
                Log.d(TAG, "MqttClientScreen: SUCCESS")
            } catch (e: java.lang.Exception) {
                Log.d(TAG, "MqttClientScreen ERROR: $e")
            }
        }


    }

    // Disconnect from the broker when the composable is removed from the screen
    DisposableEffect(client) {
        onDispose {
            try {
                client.disconnect()
            } catch (e: MqttException) {
                Log.e(TAG, "Error disconnecting from the broker", e)
            }
        }
    }

}

fun createMqttClient(): MqttClient {
    val broker = "tcp://192.168.64.94:1883"
    //넘어렵당 ㅠ_ㅠ
    val clientId = MqttClient.generateClientId()
//    val clientId = "android-" + UUID.randomUUID().toString()
    val persistence = MemoryPersistence()
    val client = MqttClient(broker, clientId, persistence)

    client.setCallback(object : MqttCallback {
        override fun connectionLost(cause: Throwable?) {
            Log.d(TAG, "connectionLost: $cause")
        }

        override fun messageArrived(topic: String?, message: MqttMessage?) {
            Log.d(TAG, "messageArrived: $message")
        }

        override fun deliveryComplete(token: IMqttDeliveryToken?) {
            Log.d(TAG, "deliveryComplete: $token")
        }
    })

    return client
}

//@Composable
//fun MqttClientScreen() {
//
//    val client by remember {
//        mutableStateOf(createMqttClient())
//    }
//
//    val context = LocalContext.current
//
//    val messages = remember { mutableStateListOf<String>() }
//    val receiveEventText = remember { mutableStateOf("") }
//    var text by remember { mutableStateOf("") }
//
//
//    Column(
//        Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Text(
//            "Test MQTT Client",
//            modifier = Modifier.fillMaxWidth(),
//            fontSize = 25.sp,
//            color = Color.Black,
//            textAlign = TextAlign.Center,
//            fontFamily = notosans_bold
//        )
//
//        SpacerHeight(dp = 20.dp)
//
//        messages.forEach { message ->
//            Text(message+"wow")
//        }
//
//
//
//        Spacer(Modifier.height(16.dp))
//
//        //SendText
//        Row(Modifier.fillMaxWidth()) {
//            TextField(
//                value = text,
//                onValueChange = { text = it },
//                label = { Text(text = "Enter a message") }
//            )
//
//
//            Spacer(modifier = Modifier.weight(1f))
//
//            Button(
//                onClick = {
//                    if (text.isNotBlank()) {
//                        client.publish("my/topic", text.toByteArray(), 0, false)
//                        text = ""
//                    }
//                },
//                modifier = Modifier.padding(top = 16.dp)
//            ) {
//                Text("Send")
//            }
//        }//Row
//
//
//        SpacerHeight(dp = 20.dp)
//
//
//        Row(Modifier.fillMaxWidth()) {
//            //change
//            Text(receiveEventText.value)
//            Spacer(modifier = Modifier.weight(1f))
//
//        }//Row
//
//
//
//    }//Column
//
//    LaunchedEffect(client) {
//        if(client.isConnected){
//            client.disconnect()
//        }
//        try {
//            client.connect()
//            Log.d(TAG, "MqttClientScreen SUCCESS: 됐냐? ")
////            client.subscribe("my/topic") { _, message ->
////                messages.add(message.toString())
////                receiveEventText.value = "$message"
////                Toast.makeText(context, "$message", Toast.LENGTH_SHORT).show()
////            }
//        }catch (e:Exception){
//            Log.d(TAG, "MqttClientScreen ERROR: $e")
//        }
//
//
//    }
//
//    //특정 객체를 청소? 하기 위해서 사용, client가 중복 생성되는 현상을 막기위해서 사용
//    DisposableEffect(client) {
//        onDispose {
//            client.disconnect()
//        }
//    }
//}
//
//
//fun createMqttClient(): MqttClient {
//    //192.168.0.102
//    val broker = "tcp://192.168.64.94:3000"
//    val clientId = MqttClient.generateClientId()
////    val clientId = "slfnjszkufjhszkuf"
//    val persistence = MemoryPersistence()
//    val client = MqttClient(broker, clientId, persistence)
//
//    client.setCallback(object : MqttCallback {
//        override fun connectionLost(cause: Throwable?) {
//            Log.d(TAG, "connectionLost: $cause")
//        }
//
//        override fun messageArrived(topic: String?, message: MqttMessage?) {
//            Log.d(TAG, "messageArrived: $message")
//        }
//
//        override fun deliveryComplete(token: IMqttDeliveryToken?) {
//            Log.d(TAG, "deliveryComplete: $token")
//        }
//
//    })
//
//    return client
//
//
//}
