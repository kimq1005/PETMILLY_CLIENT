package com.llama.petmilly_client.presentation.chatscreen

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.chatscreen.items.ChatRoomItem
import com.llama.petmilly_client.presentation.chatscreen.items.EntityChatModel
import com.llama.petmilly_client.presentation.chatscreen.items.PlzChatModel
import com.llama.petmilly_client.presentation.dialog.AdoptionApplicationDialog
import com.llama.petmilly_client.presentation.dialog.ChatRoomDialog
import com.llama.petmilly_client.presentation.myprofilescreen.MyProfileActivity
import com.llama.petmilly_client.presentation.myprofilescreen.ProfileActivity
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.ui.theme.Black_Half_Transfer
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ChattingRoomScreen(navController: NavController, name: String, viewModel: ChatViewModel) {
    val context = LocalContext.current

    val (value, setvaluse) = rememberSaveable {
        mutableStateOf("")
    }

    val firstcheckBoolean = false
    Column(
        Modifier
            .background(Color(0xFF33FBE1B0))
    ) {
        Spacer(

            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White)
        )

        TitleBar(
            title = name,
            ismenu = true,
            clickBack = { navController.popBackStack() },
            clickMenu = {
                viewModel.onChatRoomDialog()
            }
        )

        if (viewModel.isChatRoomDialog) {
            ChatRoomDialog(
                onCompleted = { /*TODO*/ },
                onAlarmOff = { /*TODO*/ },
                onBenUser = { /*TODO*/ },
                onReport = { /*TODO*/ },
                onFavoriteChatRoom = { /*TODO*/ },
                onExitChatRoom = { /*TODO*/ },
                onDismiss = {
                    viewModel.DismissChatRoomDialog()
                })
        }


        Divider(
            color = Black_Half_Transfer, modifier = Modifier
                .height(1.dp)
        )

        Row(
            Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(color = Color(0xFF99D9D9D9)),
        ) {
            Spacer(modifier = Modifier.width(30.dp))

            Image(
                painter = painterResource(id = R.drawable.img_testcat),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row {
                    Text(
                        text = "힝구",
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
                    )

                    Text(
                        text = ":암컷 /1KG /믹스/ 2개월 추정\n1차접종완료 /중성화X",
                        fontSize = 12.sp,
                        color = Black_60_Transfer,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
                    )
                }
            }

        }



        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(modifier = Modifier.padding(start = 25.dp, end = 16.dp)) {
            val entityChatModel = arrayListOf<EntityChatModel>()
            entityChatModel.add(
                EntityChatModel(
                    0,
                    plzChatModel = PlzChatModel(recive = "안녕하세요!")
                )
            )
            entityChatModel.add(
                EntityChatModel(
                    0,
                    plzChatModel = PlzChatModel(recive = "혹시 힝구 임시보호처 구해졌나요?! ")
                )
            )
            entityChatModel.add(
                EntityChatModel(
                    1,
                    plzChatModel = PlzChatModel(send = "아니요 아직 안됐습니다. 입양 신청해주세요!")
                )
            )

            entityChatModel.add(
                EntityChatModel(
                    0,
                    plzChatModel = PlzChatModel(recive = "넵 알겠습니다!.")
                )
            )

            entityChatModel.add(
                EntityChatModel(
                    2,
                    plzChatModel = PlzChatModel(send = "이재익")
                )
            )





            items(entityChatModel) { item ->

                ChatRoomItem(
                    item,
                    onclick = {
                        val intent = Intent(context, ProfileActivity::class.java)
                        context.startActivity(intent)
                    },
                    onconfirm = {
                        viewModel.onShowAdoptionApplcationDialog()
                        //임보신청서 dialog
                    }
                )

                val paddingValue =
                    if (item.type == entityChatModel.getOrNull(entityChatModel.indexOf(item) + 1)?.type) {
                        8.dp
                    } else {
                        20.dp
                    }

                Spacer(modifier = Modifier.height(paddingValue))

            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(start = 15.dp, end = 15.dp, bottom = 65.dp, top = 10.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.img_plus),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(25.dp)
                    .width(25.dp)
                    .align(Alignment.CenterVertically),
            )

            TextField(
                value = value,
                onValueChange = setvaluse,
                modifier = Modifier

                    .weight(8f)
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,
                ),
                placeholder = {
                    Text(
                        text = "내용을 입력해주세요.",
                        fontSize = 14.sp
                    )
                },
            )

            Image(
                painter = painterResource(id = R.drawable.img_send),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .height(25.dp)
                    .width(25.dp)

            )

        }

    SetDialog(viewModel = viewModel)

    }//Column

}

@Composable
fun SetDialog(viewModel: ChatViewModel){
    if(viewModel.isAdoptionApplicationDialog){
        AdoptionApplicationDialog(
            onDismiss = { viewModel.onDismissAdoptionApplicationDialog() },
            onConfirm = {  },
            onModify = {  },
            ischatroom = true
        )
    }
}


@Preview
@Composable
fun AFDFHDF() {
    val navController = rememberNavController()
    val name = "ad"
    val viewModel: ChatViewModel = hiltViewModel()
    ChattingRoomScreen(navController, name, viewModel)
}