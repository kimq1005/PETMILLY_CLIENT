package com.llama.petmilly_client.presentation.chatscreen.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.utils.notosans_regular


/**
 * 1. 전체 아이템하나 senditem reciveitem 하나 만들기
 * 2. **/
@Composable
fun ChatRoomItem(
    entityChatModel: EntityChatModel,
    onclick: () -> Unit,
) {
    Column(
        Modifier.fillMaxSize()
    ) {
        when (entityChatModel.type) {
            0 -> {
                ReciveItem(recive = entityChatModel.plzChatModel.recive, onclick = {
                    onclick()
                })


            }
            else -> {
                SendItem(entityChatModel.plzChatModel.send, onclick = {
                    onclick()
                })
            }
        }
    }

}


@Composable
fun SendItem(
    send: String,
    onclick: () -> Unit,
) {
    Row(
        Modifier
            .fillMaxWidth(),
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Column(modifier = Modifier.align(Alignment.Bottom)) {
            Text(
                modifier = Modifier.align(Alignment.End),
                text = "읽음",
                fontSize = 8.sp,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                textAlign = TextAlign.End
            )
            
            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "오후 8:44",
                fontSize = 8.sp,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

        }
        
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            modifier = Modifier
                .background(
                    color = Color(0xFFFbE1B0),
                    shape = RoundedCornerShape(
                        topStart = 6.dp,
                        topEnd = 0.dp,
                        bottomStart = 6.dp,
                        bottomEnd = 6.dp
                    )
                )
                .padding(10.dp)
                .clickable { onclick() }
                .align(Alignment.CenterVertically),
            text = send,
            fontSize = 13.sp,
            color = Color.Black,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )
    }
}

@Composable
fun ReciveItem(recive: String, onclick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = R.drawable.img_test_puppy), contentDescription = null,
            modifier = Modifier
                .height(28.dp)
                .width(28.dp)
                .clip(shape = CircleShape)
                .align(Alignment.CenterVertically),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(10.dp))
        Text(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 6.dp,
                        bottomStart = 6.dp,
                        bottomEnd = 6.dp
                    )
                )
                .padding(10.dp)
                .clickable { onclick() }
                .align(Alignment.CenterVertically),
            text = recive,
            fontSize = 13.sp,
            color = Color.Black,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "오후 1:34",
            modifier = Modifier.align(Alignment.Bottom),
            color = Black_60_Transfer,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            fontSize = 8.sp
        )
    }
}

data class EntityChatModel(
    val type: Int,
    val plzChatModel: PlzChatModel,
)

data class PlzChatModel(
    val send: String = "",
    val recive: String = "",
)
