package com.llama.petmilly_client.presentation.chatscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar

@Composable
fun ChattingRoomScreen(navController: NavController,name:String) {
    Column(Modifier.fillMaxSize()) {
        TitleBar(title = name , ismenu = false , clickBack = { navController.popBackStack() }) {

        }
    }

}