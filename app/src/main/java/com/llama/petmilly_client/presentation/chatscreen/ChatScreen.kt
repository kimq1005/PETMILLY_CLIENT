package com.llama.petmilly_client.presentation.chatscreen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.*
import com.llama.petmilly_client.presentation.chatscreen.items.ChatItem
import com.llama.petmilly_client.presentation.chatscreen.items.ChatModel
import com.llama.petmilly_client.ui.theme.Purple700
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.CHATSCREEN
import llama.test.jetpack_dagger_plz.utils.Common.CHATTINGROOMSCREEN
import llama.test.jetpack_dagger_plz.utils.Common.TAG


@Composable
fun ChatEntityScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = CHATSCREEN){
        composable(CHATSCREEN){
            ChatScreen(navController)
        }

        composable("CHATTINGROOMSCREEN/{hello}"){
            val wow =it.arguments?.getString("hello").toString()
            Log.d(TAG, "ChatTabScreen: $wow")
            ChattingRoomScreen(navController, wow.toString())
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ChatScreen(navController: NavController) {
    val pagerState = rememberPagerState(1)
//    val navController = rememberNavController()

    Column(

    ) {

        TopAppBar() {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "채팅",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(top = 30.dp, bottom = 20.dp),
                    textAlign = TextAlign.Start
                )
            }
        }

        Tabs(pagerState)
        TabsContent(pagerState = pagerState, navController)


    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf(
        "입양신청서" to Icons.Default.Home,
        "채팅" to Icons.Default.ShoppingCart,
        "즐겨찾기" to Icons.Default.Settings
    )

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Purple700,
        contentColor = Color.White,
        indicator = { tabPostions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions = tabPostions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                icon = {
                    Icon(imageVector = list[index].second, contentDescription = null)
                },
                text = { Text(text = list[index].first) },
                selected = pagerState.currentPage == index,

                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState, navController: NavController) {
    HorizontalPager(state = pagerState, count = 3) { page ->
        when (page) {

            0 -> TabContentScreen(data = "Welcome to Home Screen")

            1 -> ChatTabScreen(navController)

            2 -> TabContentScreen(data = "Welcome to Settings Screen")
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

        LazyColumn() {
            val item = listOf(
                ChatModel("김승현", "설명이다", "10시30분", "1"),
                ChatModel("와우맨", "히", "10시30분", "1"),
                ChatModel("ㄹㄹㅋㄴㅇ", "ㅁㄴㅇ", "10시30분", "1"),
                ChatModel("ㅁㅇㅁㄴㅇ", "ㅁㄴㅇ", "10시30분", "1")
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
}
