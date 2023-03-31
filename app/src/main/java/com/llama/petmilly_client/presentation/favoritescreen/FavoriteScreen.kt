package com.llama.petmilly_client.presentation.favoritescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.*
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.chatscreen.ChatTabScreen
import com.llama.petmilly_client.presentation.chatscreen.FavoriteChatScreen
import com.llama.petmilly_client.utils.CommonNotingScreen
import com.llama.petmilly_client.utils.Tabs
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import kotlinx.coroutines.launch


@Composable
fun FavoriteEntityScreen() {
    val navController = rememberNavController()
    val viewModel: FavoriteViewModel = hiltViewModel()

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FavoriteScreen(navController: NavController) {

    val pagerState = rememberPagerState(0)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = dimensionResource(id = R.dimen.bottomnavi_heigt)))
    {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color(0xFF99FBE1B0))
        )

        val tabslist = listOf(
            "구해요 입양처",
            "구해요 임보처",
            "찾아요 우리아이",
            "찾아요 이동봉사",
        )

        FavroiteTabs(pagerState, tabslist)
        TabsContent(
            pagerState = pagerState,
            navController,
            4
        )
    }


}

@ExperimentalPagerApi
@Composable
fun FavroiteTabs(pagerState: PagerState, list: List<String>) {
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
        list.forEachIndexed { index, text ->

            val fontWeight =
                if (index == pagerState.currentPage) notosans_bold else notosans_regular
            val fontFamily = if (text.startsWith("구해요") || text.startsWith("찾아요")) notosans_regular else fontWeight
            Tab(
                text = {
                    Column(modifier = Modifier.padding(bottom = 5.dp)) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(CenterHorizontally),
                            text = text.substring(0, 3),
                            fontSize = 11.sp,
                            fontFamily = fontFamily,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(CenterHorizontally),
                            text = text.substring(3),
                            fontSize = 15.sp,
                            fontFamily = fontWeight,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
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


@Composable
fun BitText(string: String) {
    Text(
        text = string,
        fontSize = 17.sp,
        color = Color.Black,
        fontFamily = notosans_bold,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        ),
    )
}


@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState, navController: NavController, count: Int) {
    HorizontalPager(state = pagerState, count = count) { page ->
        when (page) {

            0 -> FavoriteChatScreen()

            1 -> FavoriteChatScreen()

            2 -> FavoriteChatScreen()

            3 -> FavoriteChatScreen()

        }
    }
}

@Composable
fun SaveShelterScreen() {
    CommonNotingScreen(
        text = "관심 등록한\n" +
                "친구들이\n" +
                "아직 없어요",
        modifier = Modifier
    )
}



