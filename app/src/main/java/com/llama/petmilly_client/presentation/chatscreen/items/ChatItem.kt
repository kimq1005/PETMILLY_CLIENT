package com.llama.petmilly_client.presentation.chatscreen.items

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Purple200
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun ChatItem(
    chatModel: ChatModel,
    onclick: ()->Unit
){
    Card(modifier = Modifier
        .fillMaxSize()
        .clickable {
            onclick()
        },
        backgroundColor = Purple200
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = chatModel.name,
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold)

                    Text(
                        text = chatModel.time,
                        fontSize = 11.sp,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text =chatModel.description,
                        fontSize = 12.sp,
                        color = Color.Black,
                    )

                    Text(
                        text =  chatModel.update,
                        fontSize = 11.sp,
                        color = Color.Black
                    )
                }
            }


        }
    }
}
//
data class ChatModel(
    val name:String,
    val description:String,
    val time:String,
    val update:String
)

@Preview
@Composable
fun Hello(){
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
