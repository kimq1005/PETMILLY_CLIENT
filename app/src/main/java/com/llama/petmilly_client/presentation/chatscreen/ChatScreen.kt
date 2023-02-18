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
import com.llama.petmilly_client.ui.theme.Purple700
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
    val viewModel :ChatViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = CHATSCREEN) {
        composable(CHATSCREEN) {
            ChatScreen(navController)
        }

        composable("CHATTINGROOMSCREEN/{hello}") {
            val wow = it.arguments?.getString("hello").toString()
            Log.d(TAG, "ChatTabScreen: $wow")
            ChattingRoomScreen(navController, wow.toString(),viewModel)
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
                .height(50.dp)
                .background(Color(0xFF99FBE1B0))
        )
        Tabs(pagerState)
        TabsContent(pagerState = pagerState, navController)


    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf(
        "메세지",
        "즐겨찾기"
    )

//    val list = listOf(
//        "메세지" to Icons.Default.ShoppingCart,
//        "즐겨찾기" to Icons.Default.Settings
//    )

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color(0xFF99FBE1B0),
        contentColor = Color.Black,
        indicator = { tabPostions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions = tabPostions),
                height = 5.dp,
                color = Color(0xFFF8A405)
            )
        },
        divider = { contentColorFor(backgroundColor = Color.Black) }
    ) {
        list.forEachIndexed { index, _ ->

            val fontWeight =
                if (index == pagerState.currentPage) notosans_bold else notosans_regular
            Tab(
                text = {
                    Text(
                        text = list[index],
                        fontSize = 17.sp,
                        fontFamily = fontWeight
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                selectedContentColor = Color.Black,

                )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState, navController: NavController) {
    HorizontalPager(state = pagerState, count = 2) { page ->
        when (page) {

            0 -> ChatTabScreen(navController)

            1 -> TabContentScreen(data = "Welcome to Home Screen")

        }
    }
}

@Composable
fun TabContentScreen(data: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Log.d(TAG, "TabContentScreen1")
        Text(
            text = data,
            style = MaterialTheme.typography.h5,
            color = Purple700,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun ChatTabScreen(
    navController: NavController,
) {
    Column(modifier = Modifier.padding(16.dp)) {

        LazyRow() {
            val mylist = listOf(
                "임보처구해요", "이동봉사찾아요", "입양공고"
            )
            items(mylist) { item ->

                BorderCategoryItems(title = item) {

                }
                Spacer(modifier = Modifier.width(9.dp))

            }
        }

        Spacer(modifier = Modifier.height(10.dp))

//        ShelterCategoryItems()
        LazyColumn() {
            val item = listOf(
                ChatModel(
                    "[감자]김승현", "안녕하세요 이 친구 건강은\n" +
                            "어떤가요? 문의문의나문희...", "오루 10시30분", "1"
                ),
                ChatModel(
                    "[금자]와우맨", "문의내용인데용우히히헹\n" +
                            "우히헤에헤에헤헹엫ㅇ헹...", "10시30분", "1"
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

@Composable
fun TabContentScreen3(data: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Log.d(TAG, "TabContentScreen3")
        Text(
            text = data,
            style = MaterialTheme.typography.h5,
            color = Purple700,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun Wow() {
    ChatEntityScreen()
}
