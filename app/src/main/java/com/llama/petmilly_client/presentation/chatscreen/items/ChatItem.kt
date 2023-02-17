package com.llama.petmilly_client.presentation.chatscreen.items

import android.graphics.drawable.shapes.OvalShape
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.ui.theme.Black_Half_Transfer
import com.llama.petmilly_client.ui.theme.Purple200
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun ChatItem(
    chatModel: ChatModel,
    onclick: () -> Unit,
) {

    Row(modifier = Modifier
        .height(90.dp)
        .clickable {
            onclick()
        }) {
        Image(
            painter = painterResource(id = R.drawable.img_test_puppy),
            contentDescription = null,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .clip(shape = CircleShape)
                .align(Alignment.CenterVertically),
            contentScale = ContentScale.Crop

        )

        Spacer(modifier = Modifier.width(15.dp))

        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Row(
                modifier = Modifier

            ) {
                Text(
                    text = chatModel.name,
                    color = Color.Black,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = chatModel.time,
                    fontSize = 10.sp,
                    color = Black_60_Transfer,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )
            }

            Spacer(modifier = Modifier.height(5.dp))


            Row(

            ) {
                Text(
                    text = chatModel.description,
                    fontSize = 13.sp,
                    color = Color.Black,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFE92F2F),
                            shape = CircleShape
                        )
                        .width(21.dp).height(21.dp)
                        .align(Alignment.CenterVertically),
                    text = chatModel.update,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ), textAlign = TextAlign.Center
                    )

                )
            }
        }


    }
}

//
data class ChatModel(
    val name: String,
    val description: String,
    val time: String,
    val update: String,
)

@Preview
@Composable
fun Hello() {
    LazyColumn() {
        val item = listOf(
            ChatModel("김승현", "설명이다", "10시30분", "1"),
            ChatModel("와우맨", "히", "10시30분", "1"),
            ChatModel("ㄹㄹㅋㄴㅇ", "ㅁㄴㅇ", "10시30분", "1"),
            ChatModel("ㅁㅇㅁㄴㅇ", "ㅁㄴㅇ", "10시30분", "1")
        )

        items(item) { chatmodel ->

//            ChatItem(chatModel = chatmodel) {
//                Log.d(Common.TAG, "ChatTabScreen: ${chatmodel.description}")
//            }

            Spacer(modifier = Modifier.height(5.dp))


        }

    }

}
