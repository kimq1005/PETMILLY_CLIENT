package com.llama.petmilly_client.presentation.notificationscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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


@Composable
fun NotificationScreen(navController: NavController) {
    val isNotification = false
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

        Spacer(modifier = Modifier.weight(1f))

        if (isNotification) {

        } else {

            Box(modifier = Modifier.fillMaxSize().background(color = Background_Noting)) {
//                Text(
//                    text = "십알",
//                    modifier = Modifier.align(Alignment.Center),
//                    textAlign = TextAlign.Center
//                )

                CommonNotingScreen(text = "알림이 없습니다.", modifier = Modifier.align(Alignment.Center))
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
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
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

@Preview
@Composable
fun SSefdszkjfhszf() {
    val navController = rememberNavController()
    NotificationScreen(navController)

//    TextTest()
}