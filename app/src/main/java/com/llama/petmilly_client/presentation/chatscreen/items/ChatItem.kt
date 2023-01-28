package com.llama.petmilly_client.presentation.chatscreen.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Purple200
import com.llama.petmilly_client.ui.theme.Purple700

@Composable
fun ChatItem(
    chatModel: ChatModel,
    onclick:()->Unit
){
    Card(modifier = Modifier.fillMaxSize()
        .clickable { onclick() },
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
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text ="chatModel.description",
                    fontSize = 12.sp,
                    color = Color.Blue,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text =  "chatModel.update",
                    fontSize = 11.sp,
                    color = Color.Black
                )
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