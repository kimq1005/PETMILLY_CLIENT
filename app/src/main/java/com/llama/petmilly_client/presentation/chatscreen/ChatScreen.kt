package com.llama.petmilly_client.presentation.chatscreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.*
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.chatscreen.items.ChatItem
import com.llama.petmilly_client.presentation.chatscreen.items.ChatModel
import com.llama.petmilly_client.presentation.homescreen.items.BorderCategoryItems
import com.llama.petmilly_client.ui.theme.Background_Noting
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.utils.CommonNotingScreen
import com.llama.petmilly_client.utils.Tabs
import com.llama.petmilly_client.utils.notosans_regular
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
            "메세지",
            "즐겨찾기"
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
//                    text = "십알",
//                    modifier = Modifier.align(Alignment.Center),
//                    textAlign = TextAlign.Center
//                )

                CommonNotingScreen(
                    text = "관심 등록한\n친구들이\n아직 없어요",
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column() {
                LazyRow() {
                    val mylist = listOf(
                        "임보처구해요", "이동봉사찾아요", "입양공고"
                    )
                    items(mylist) { item ->

                        BorderCategoryItems(title = item) { title, check ->

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

                            "[초코]이재익", "안녕하세요!", "오후 10시30분", "1", R.drawable.img_test_puppy,
                        ),
                        ChatModel(
                            "[라떼]박세라", "임보 관련 문의드립니다!\n", "10시30분", "1", R.drawable.img_testcat_2,
                        ),
                    )

                    items(item) { chatmodel ->
                        ChatItem(chatModel = chatmodel, image = chatmodel.image, onclick =
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
                text = "전송된\n" +
                        "채팅 메시지가\n" +
                        "아직 없어요",
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

