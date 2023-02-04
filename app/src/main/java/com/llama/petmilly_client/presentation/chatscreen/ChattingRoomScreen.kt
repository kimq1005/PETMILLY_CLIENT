package com.llama.petmilly_client.presentation.chatscreen

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.llama.petmilly_client.presentation.chatscreen.items.ChatRoomItem
import com.llama.petmilly_client.presentation.chatscreen.items.EntityChatModel
import com.llama.petmilly_client.presentation.chatscreen.items.PlzChatModel
import com.llama.petmilly_client.presentation.chatscreen.items.SendChatModel
import com.llama.petmilly_client.presentation.profilescreen.ProfileActivity
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun ChattingRoomScreen(navController: NavController,name:String) {
    Column(Modifier.fillMaxSize()) {
        TitleBar(title = name , ismenu = true , clickBack = { navController.popBackStack() }) {

        }
        val context = LocalContext.current


        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(){
            val entityChatModel= arrayListOf<EntityChatModel>()

            entityChatModel.add(EntityChatModel(0, plzChatModel = PlzChatModel(send = "send다 send")))
            entityChatModel.add(EntityChatModel(0, plzChatModel = PlzChatModel(send = "send다 send")))
            entityChatModel.add(EntityChatModel(1, plzChatModel = PlzChatModel(recive = "받는다 ")))
            entityChatModel.add(EntityChatModel(0, plzChatModel = PlzChatModel("send다 send")))

            items(entityChatModel){
                ChatRoomItem(it, onclick = {
                    val intent = Intent(context, ProfileActivity::class.java)
                    context.startActivity(intent)
                })
            }
        }


        val (value, setvaluse) = rememberSaveable {
            mutableStateOf(" ")
        }


        OutlinedTextField(
            value = value,
            onValueChange = setvaluse,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
            keyboardActions = KeyboardActions(onSend ={
                Log.d(TAG, "ChattingRoomScreen: $value")
            })
        )

    }

}