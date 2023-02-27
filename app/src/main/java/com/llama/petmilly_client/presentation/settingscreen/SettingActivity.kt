package com.llama.petmilly_client.presentation.settingscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.utils.SpacerHeight
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular


class SettingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

        }
    }
}

@Composable
fun SettingScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 25.dp)
    ) {
        TitleBar(title = "설정", ismenu = false, clickBack = { }) {

        }

        Divider(color = Color.Black)

        SpacerHeight(dp = 20.dp)

        SettingText("공지사항", onclick = {

        })

        SpacerHeight(dp = 20.dp)

        Divider(color = Black_30_Transfer, modifier = Modifier.height(0.2.dp))

        SpacerHeight(dp = 20.dp)

        SettingText("자주 묻는 질문", onclick = {

        })

        SpacerHeight(dp = 20.dp)

        Divider(color = Color.Black)

        SpacerHeight(dp = 25.dp)

        SettingText("앱푸시 알림설정", onclick = {

        })

        SpacerHeight(dp = 25.dp)

        Divider(color = Color.Black)

        SpacerHeight(dp = 20.dp)

        SettingText("서비스 이용약관", onclick = {

        })
        SpacerHeight(dp = 20.dp)

        Divider(color = Black_30_Transfer, modifier = Modifier.height(0.2.dp))

        SpacerHeight(dp = 20.dp)

        SettingText("개인 정보 방침", onclick = {

        })

        SpacerHeight(dp = 20.dp)

        Divider(color = Black_30_Transfer, modifier = Modifier.height(0.2.dp))

        SpacerHeight(dp = 20.dp)

        SettingText("위치기반 서비스 이용약관", onclick = {

        })

        SpacerHeight(dp = 20.dp)

        Divider(color = Color.Black)

        SpacerHeight(dp = 20.dp)

        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "버전정보",
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "1.0.0.ver.",
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp,
                color = Black_60_Transfer
            )

        }//Row
        
        Spacer(modifier = Modifier.weight(1f))
        
        Row(Modifier.padding(horizontal = 50.dp, vertical = 80.dp)) {
            Text(
                text = stringResource(id = R.string.secession),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp,
                color = Black_30_Transfer
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(id = R.string.logout),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp,
                color = Black_30_Transfer
            )
        }


    }
}

@Composable
fun SettingText(title:String, onclick:()->Unit){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 20.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = title,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            fontSize = 13.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.img_go), contentDescription = null,
            modifier = Modifier
                .height(15.dp)
                .width(15.dp)
                .clickable {
                    onclick()
                }
        )

    }//Row
}

@Preview
@Composable
fun SettingPreview(){
    SettingScreen()
}