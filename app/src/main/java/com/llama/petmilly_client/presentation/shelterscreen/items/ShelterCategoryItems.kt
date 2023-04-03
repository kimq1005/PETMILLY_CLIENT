package com.llama.petmilly_client.presentation.shelterscreen.items

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
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
import coil.compose.rememberImagePainter
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.CommonObject
import com.llama.petmilly_client.utils.CommonObject.convertTimetoHour
import com.llama.petmilly_client.utils.SpacerWidth
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShelterCategoryItems(
    image: String?,
    title: String,
    description: String,
    vaccination: String,
    isComplete: Boolean,
    isReceipt: Boolean,
    time:String,
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

//        val ispetmily = true

        Box(contentAlignment = Alignment.Center) {

            Image(
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .align(Alignment.CenterStart)
                    .padding(start = 15.dp, top = 10.dp),
                painter = if (image != null) {
                    rememberImagePainter(data = image)
                } else painterResource(id = R.drawable.img_testcat_2),
//                painter =painterResource(id = R.drawable.img_testcat_2),
                contentDescription = null,
                contentScale = ContentScale.Crop,

                )


            if (!isReceipt) {
                Text(
                    text = "심사중",
                    fontSize = 8.sp,
                    fontFamily = if (isComplete) notosans_regular else notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .offset(y = 15.dp, x = 5.dp)
                        .background(
                            if (isComplete) Color.Black else Category_Cliked,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(horizontal = 5.dp, vertical = 4.dp)
                        .align(Alignment.TopStart)
                )
            } else if (isComplete) {
                Text(
                    text = "petmily ❤️",
                    fontSize = 8.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .offset(y = 15.dp, x = 5.dp)
                        .background(
                            if (isComplete) Color.Black else Category_Cliked,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(horizontal = 5.dp, vertical = 4.dp)
                        .align(Alignment.TopStart)
                )
            }

        }


        SpacerWidth(dp = 20.dp)

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = if (!isComplete) title else "(완료) $title",
                color = if (!isComplete) Color.Black else Black_30_Transfer,
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
                color = if (!isComplete) Black_60_Transfer else Black_20_Transfer,
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
                color = if (!isComplete) Black_60_Transfer else Black_20_Transfer,
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
                text = convertTimetoHour(time),
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


