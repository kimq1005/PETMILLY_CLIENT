package com.llama.petmilly_client.presentation.chatscreen.items

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * 1. 전체 아이템하나 senditem reciveitem 하나 만들기
 * 2. **/
@Composable
fun ChatRoomItem(
    entityChatModel:EntityChatModel
) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        when (entityChatModel.type) {
            0 -> {
                SendItem(entityChatModel.plzChatModel.send)
            }
            else -> {
                ReciveItem(recive = entityChatModel.plzChatModel.recive)
            }
        }
    }

}


@Composable
fun SendItem(send:String) {
    Column(
        Modifier
            .fillMaxWidth()
            .height(60.dp)) {
        Text(
            text = send,
            modifier = Modifier.align(Alignment.Start),
            color = Color.Red
        )
    }
}

@Composable
fun ReciveItem(recive: String) {
    Column(
        Modifier
            .fillMaxWidth()
            .height(60.dp)) {
        Text(
            text = recive,
            modifier = Modifier.align(Alignment.End),
            color = Color.Blue
        )
    }
}

data class EntityChatModel(
    val type: Int,
    val plzChatModel:PlzChatModel
)
data class PlzChatModel(
    val send:String="",
    val recive:String=""
)
data class SendChatModel(
    val sendchat: String,
    val type: Int = 0,
)

data class ReciveChatModel(
    val recivechat: String,
    val type: Int = 1,
)