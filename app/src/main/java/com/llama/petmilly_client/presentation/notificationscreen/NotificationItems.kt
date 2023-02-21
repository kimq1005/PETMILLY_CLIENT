package com.llama.petmilly_client.presentation.notificationscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Black_40_Transfer
import com.llama.petmilly_client.ui.theme.Black_5_Transfer
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun NotificationItems(
    title: String,
    description: String,
    time: String,
//    isalarm:Boolean,
//    onclickalarm:()->Unit
) {

//    var background = if(isalarm) Color()

    Box(
        modifier = Modifier
            .height(80.dp)
            .padding(horizontal = 25.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.img_petmilly_heart_menu),
                contentDescription = null,
                modifier = Modifier
                    .height(21.dp)
                    .width(21.dp)
                    .align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.width(23.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = title,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontSize = 15.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = description,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontSize = 12.sp,
                    color = Black_40_Transfer
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = time,
                modifier = Modifier.padding(end = 25.dp),
                fontSize = 11.sp,
                color = Black_30_Transfer,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
            )
        }

        Divider(
            color = Black_5_Transfer,
            modifier = Modifier
                .height(1.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
fun NotificationItemsPreview() {
    NotificationItems(title = "제목입니다.", description = "설명입니다 설명이라구요", "15시간전")
}