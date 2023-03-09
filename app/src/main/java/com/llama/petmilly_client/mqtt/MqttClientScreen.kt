package com.llama.petmilly_client.mqtt

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
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
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import java.util.*


class MqttActivity:ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            MqttClientScreen()
        }
    }
}

@Composable
fun MqttClientScreen() {

    val client by remember {
        mutableStateOf(createMqttClient())
    }

    val context = LocalContext.current

    val messages = remember { mutableStateListOf<String>() }
    val receiveEventText = remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }


    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Test MQTT Client",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 25.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontFamily = notosans_bold
        )

        SpacerHeight(dp = 20.dp)

        messages.forEach { message ->
            Text(message+"wow")
        }



        Spacer(Modifier.height(16.dp))

        //SendText
        Row(Modifier.fillMaxWidth()) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(text = "Enter a message") }
            )


            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    if (text.isNotBlank()) {
                        client.publish("my/topic", text.toByteArray(), 0, false)
                        text = ""
                    }
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Send")
            }
        }//Row


        SpacerHeight(dp = 20.dp)


        Row(Modifier.fillMaxWidth()) {
            //change
            Text(receiveEventText.value)
            Spacer(modifier = Modifier.weight(1f))

        }//Row



    }//Column

//    LaunchedEffect(client) {
//        client.connect()
//        client.subscribe("my/topic") { _, message ->
//            messages.add(message.toString())
//            receiveEventText.value = "$message"
//            Toast.makeText(context, "$message", Toast.LENGTH_SHORT).show()
//        }
//
//    }
//
//    //특정 객체를 청소? 하기 위해서 사용, client가 중복 생성되는 현상을 막기위해서 사용
//    DisposableEffect(client) {
//        onDispose {
//            client.disconnect()
//        }
//    }
}


fun createMqttClient(): MqttClient {
    val broker = "tcp://localhost:1883"
    val clientId = MqttClient.generateClientId()
    val persistence = MemoryPersistence()
    val client = MqttClient(broker, clientId, persistence)

    client.setCallback(object : MqttCallback {
        override fun connectionLost(cause: Throwable?) {
        }

        override fun messageArrived(topic: String?, message: MqttMessage?) {

        }

        override fun deliveryComplete(token: IMqttDeliveryToken?) {
        }

    })

    return client


}


@Preview
@Composable
fun MQtt() {
    MqttClientScreen()
}
