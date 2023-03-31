package com.llama.petmilly_client.presentation.notificationscreen

import androidx.compose.foundation.Image
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
import com.llama.petmilly_client.ui.theme.Pink_5_Transfer
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun NotificationItems(
    type:Int,
    title: String,
    description: String,
    time: String,
    iswrite:Boolean,
//    onclickalarm:()->Unit
) {

//    var background = if(isalarm) Color()

    Box(
        modifier = Modifier
            .height(80.dp)

            .background(if(iswrite) Color.White else Pink_5_Transfer )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically
        ) {

            val image = when(type){
                0->{
                    R.drawable.img_petmilly_heart_menu_2
                }
                1->{
                    R.drawable.img_application_alarm
                }
                2->{
                    R.drawable.img_petmilly_notification
                }
                else->{
                    R.drawable.img_normal_alarm
                }
            }
            Image(
                painter = painterResource(id = image),
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
