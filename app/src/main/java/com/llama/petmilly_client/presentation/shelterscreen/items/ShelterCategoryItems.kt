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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import com.llama.petmilly_client.ui.theme.Purple700

@Composable
fun ShelterCategoryItems(
    title: String,
    description: String,
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


        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(2f)
        ) {

            Text(
                text = title,
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )


            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = Color(0xFF99000000),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 20.dp)
                )

            }


        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "5시간 전",
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 8.dp, top = 6.dp),
                fontSize = 8.sp,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.weight(1f))

//            Text(
//                text = "마감 D-3",
//                modifier = Modifier
//                    .padding(bottom = 6.dp, end = 8.dp)
//                    .background(color = Color.Red, shape = RoundedCornerShape(5.dp))
//                    .padding(3.dp)
//                    .align(Alignment.End),
//                color = Color.White,
//                fontSize = 10.sp,
//                textAlign = TextAlign.Center
//            )
        }


    }
}


@Preview
@Composable
fun ASDASDA() {
    Column(Modifier.padding(10.dp)) {
        ShelterCategoryItems("감자에오", "수컷 / 1kg / 믹스 / 2개월 추정/" + " 1차접종완료 / 중성화O", onclcik = {


        })
    }

}