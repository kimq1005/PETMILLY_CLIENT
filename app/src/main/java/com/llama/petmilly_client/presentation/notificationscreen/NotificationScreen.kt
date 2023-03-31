package com.llama.petmilly_client.presentation.notificationscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.Background_Noting
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.utils.CommonNotingScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import java.io.FileDescriptor


@Composable
fun NotificationScreen(navController: NavController) {
    val isNotification = true
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = dimensionResource(id = R.dimen.bottomnavi_heigt))
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(color = Color.White)
        )
        NotificationTitleBar(navController = navController)

//        Spacer(modifier = Modifier.weight(1f))

        if (isNotification) {
            IsAlarmScreen()
        } else {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Background_Noting)
            ) {

                CommonNotingScreen(text = "알림이 없습니다.", modifier = Modifier.align(Alignment.Center))
            }


        }
    }

}

@Composable
fun IsAlarmScreen() {
    Column(modifier = Modifier
        .fillMaxHeight()
        .background(color = Color.White)) {
        LazyColumn() {
            val notificationTestData = listOf(
                NotificationTestData(
                    "관심 동물 입양상태 변경",
                    "초코의 입양 상태가 변경 되었어요!",
                    "12시간 전",
                    type = 0,
                    ischeck = false

                ),

                NotificationTestData(
                    "입양/임보 신청서 마감",
                    "설명설명설명설명",
                    "1일 전",
                    type = 1,
                    ischeck = false
                ),


                NotificationTestData(
                    "신고",
                    "세라님으로 부터 신고를 당했습니다.",
                    "3일 전",
                    type = 2,
                    ischeck = true
                ),


                NotificationTestData(
                    "펫밀리가 되신지 1주일이나 지났어요!",
                    "감사합니다!",
                    "5일 전",
                    type = 5,
                    ischeck = true
                ),


                )
            items(notificationTestData) { item ->
                NotificationItems(
                    title = item.title,
                    description = item.description,
                    time = item.time,
                    type = item.type,
                    iswrite = item.ischeck
                )
            }
        }
    }
}

@Composable
fun NotificationTitleBar(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_back),
            contentDescription = null,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
                .align(Alignment.CenterStart)
                .clickable {
                    navController.popBackStack()
                }
        )

        Text(
            text = "알림",
            fontSize = 17.sp,
            fontFamily = notosans_bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center),
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Text(
            text = "전체읽음",
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterEnd)
                .clickable {

                }
                .padding(end = 20.dp),
            textAlign = TextAlign.End,
            fontFamily = notosans_regular,
            style = TextStyle(textDecoration = TextDecoration.Underline),
            color = Black_30_Transfer

        )

    }
}


@Composable
fun TextTest() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "hi")
    }
}

data class NotificationTestData(
    val title: String,
    val description: String,
    val time: String,
    val type: Int,
    val ischeck:Boolean

)

@Preview
@Composable
fun SSefdszkjfhszf() {
    val navController = rememberNavController()
    NotificationScreen(navController)

//    TextTest()
}