package com.llama.petmilly_client.presentation.shelterscreen.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import com.llama.petmilly_client.ui.theme.Background_FDFCE1
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.ui.theme.Purple700
import com.llama.petmilly_client.utils.SpacerWidth
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterCategoryItems(
    title: String,
    description: String,
    vaccination: String,
    onclcik: () -> Unit,
) {
    Row(
        modifier = Modifier
            .height(90.dp)
            .border(width = 1.dp, color = Color(0xFFEfEfEf), shape = RoundedCornerShape(7.dp))
            .clickable {
                onclcik()
            }
    ) {
        Image(
            modifier = Modifier
                .width(80.dp)
                .fillMaxHeight()
                .padding(start = 10.dp, top = 5.dp, bottom = 5.dp),
            painter = painterResource(id = R.drawable.img_testcat_2),
            contentDescription = null,
            contentScale = ContentScale.Crop,


            )

        SpacerWidth(dp = 20.dp)

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = title,
                color = Color.Black,
                fontSize = 15.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )


            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = description,
                fontSize = 12.sp,
                color = Black_60_Transfer,
                modifier = Modifier
                    .background(color = Background_FDFCE1),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Text(
                text = vaccination,
                fontSize = 12.sp,
                color = Black_60_Transfer,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )


        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "5시간 전",
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 8.dp, top = 6.dp),
                fontSize = 8.sp,
                fontFamily = notosans_regular,
                color = Black_30_Transfer,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )

            )

            Spacer(modifier = Modifier.weight(1f))

        }


    }
}


@Preview
@Composable
fun ASDASDA() {
    Column(Modifier.padding(10.dp)) {
        ShelterCategoryItems("감자에오", "수컷 / 1kg / 믹스 / 2개월 추정", "1차 접종완료/중성화O", onclcik = {


        })
    }

}