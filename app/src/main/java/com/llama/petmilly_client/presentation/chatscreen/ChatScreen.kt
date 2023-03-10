package com.llama.petmilly_client.presentation.chatscreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.*
import com.llama.petmilly_client.presentation.chatscreen.items.ChatItem
import com.llama.petmilly_client.presentation.chatscreen.items.ChatModel
import com.llama.petmilly_client.presentation.homescreen.items.BorderCategoryItems
import com.llama.petmilly_client.presentation.shelterscreen.items.ShelterCategoryItems
import com.llama.petmilly_client.ui.theme.Background_Noting
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Purple700
import com.llama.petmilly_client.utils.CommonNotingScreen
import com.llama.petmilly_client.utils.Tabs
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.CHATSCREEN
import llama.test.jetpack_dagger_plz.utils.Common.CHATTINGROOMSCREEN
import llama.test.jetpack_dagger_plz.utils.Common.TAG


@Composable
fun ChatEntityScreen() {
    val navController = rememberNavController()
    val viewModel: ChatViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = CHATSCREEN) {
        composable(CHATSCREEN) {
            ChatScreen(navController)
        }

        composable("CHATTINGROOMSCREEN/{hello}") {
            val wow = it.arguments?.getString("hello").toString()
            Log.d(TAG, "ChatTabScreen: $wow")
            ChattingRoomScreen(navController, wow.toString(), viewModel)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ChatScreen(navController: NavController) {
    val pagerState = rememberPagerState(0)
//    val navController = rememberNavController()

    Column()
    {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color(0xFF99FBE1B0))
        )
        val tabslist = listOf(
            "?????????",
            "????????????"
        )

        Tabs(pagerState, tabslist)
        TabsContent(pagerState = pagerState, navController, 2)
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState, navController: NavController, count: Int) {
    HorizontalPager(state = pagerState, count = count) { page ->
        when (page) {

            0 -> ChatTabScreen(navController)

            1 -> FavoriteChatScreen()

        }
    }
}


@Composable
fun FavoriteChatScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val ismessage = false

        if (ismessage) {

        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Background_Noting)
            ) {
//                Text(
//                    text = "??????",
//                    modifier = Modifier.align(Alignment.Center),
//                    textAlign = TextAlign.Center
//                )

                CommonNotingScreen(
                    text = "?????????\n?????? ????????????\n?????? ?????????",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

    }
}


@Composable
fun ChatTabScreen(
    navController: NavController,
) {

    val firstcheck = true
    if (firstcheck) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Column() {
                LazyRow() {
                    val mylist = listOf(
                        "??????????????????", "?????????????????????", "????????????"
                    )
                    items(mylist) { item ->

                        BorderCategoryItems(title = item) {

                        }
                        Spacer(modifier = Modifier.width(9.dp))

                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

//        ShelterCategoryItems()
                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                ) {
                    val item = listOf(
                        ChatModel(
                            "[??????]?????????", "??????????????? ??? ?????? ?????????\n" +
                                    "????????????? ?????????????????????...", "?????? 10???30???", "1"
                        ),
                        ChatModel(
                            "[??????]?????????", "?????????????????????????????????\n" +
                                    "?????????????????????????????????...", "10???30???", "1"
                        ),
                    )

                    items(item) { chatmodel ->
                        ChatItem(chatModel = chatmodel, onclick =
                        {
                            navController.navigate(CHATTINGROOMSCREEN + "/${chatmodel.name}")
//                    navController.navigate(CHATTINGROOMSCREEN)
                        })

                        Spacer(modifier = Modifier.height(5.dp))


                    }

                }
            }


        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFD9D9D9)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Text(
                modifier = Modifier.fillMaxSize(),
                text = "?????????\n" +
                        "?????? ????????????\n" +
                        "?????? ?????????",
                fontSize = 20.sp,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Black_30_Transfer,
                textAlign = TextAlign.Center
            )

        }
    }


}

