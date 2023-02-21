package com.llama.petmilly_client.presentation.findanimalscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun FindAnimalDetailScreen(navController: NavController) {


    val (value, setvaluse) = rememberSaveable {
        mutableStateOf("")
    }


    Column {
        LazyRow(modifier = Modifier.padding(horizontal = 10.dp)) {
            val imageTestData = listOf(
                ImageTestData(com.llama.petmilly_client.R.drawable.img_test_puppy),
                ImageTestData(com.llama.petmilly_client.R.drawable.img_test_puppy),
                ImageTestData(com.llama.petmilly_client.R.drawable.img_test_puppy)
            )
            items(imageTestData) { item ->
                FindAnimalDetailImage(image = item.image)
                Spacer(modifier = Modifier.width(9.dp))

            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "소중한 제보를 기다립니다.",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .background(Purple700),
                fontSize = 16.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(id = com.llama.petmilly_client.R.string.locationconfirm),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .background(Purple700),
                fontSize = 13.sp,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Black_40_Transfer,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = "이름/성별",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "곰자/수컷",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                color = Black_30_Transfer
            )



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = "몸무게",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "15kg",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp), color = Black_30_Transfer
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = "품종",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "믹스견",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp), color = Black_30_Transfer
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = "목줄여부&색",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "목줄착용",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp), color = Black_30_Transfer
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = "실종당시 옷",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "미착용",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth(), color = Black_30_Transfer
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Pink_5_Transfer)
                    .padding(top = 5.dp, start = 10.dp, bottom = 10.dp, end = 10.dp)

            ) {
                Text(
                    text = "실종일자/지역",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "23.1.10(월)10시 \n월계동 뱅뱅사거리",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp), color = Color.LightGray
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = "특징",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "귀 한쪽 접혀있어요. 겁 많음. 꼬리 짧음. 사람 가까이하지 않으므로 신속한 제보가 최선입니다. 도와주세요.",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

        }//Column

        Spacer(modifier = Modifier.height(20.dp))

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "0개의 제보가 작성되었습니다.",
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            fontSize = 15.sp,
            color = Black_40_Transfer,
            modifier = Modifier.padding(start = 22.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "소중한 가족을 찾아주세요.\n" +
                    "허위제보 시 이용에 제한을 받을 수 있습니다.",
           fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            fontSize = 14.sp,
            color = Black_40_Transfer,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))


        Row(
            Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(start = 24.dp, end = 24.dp, bottom = 30.dp)
        ) {

            TextField(
                value = value,
                onValueChange = setvaluse,
                modifier = Modifier
                    .weight(8f)
                    .height(47.dp),
                shape = RoundedCornerShape(20.5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,
                ),
                placeholder = {
                    Text(
                        text = "제보를 입력해주세요.",
                        fontSize = 12.sp,
                        modifier = Modifier.fillMaxHeight()
                    )
                },
            )

            Image(
                painter = painterResource(id = R.drawable.img_send),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .height(25.dp)
                    .width(25.dp)
            )

        }

    }

}

@Composable
fun FindAnimalDetailImage(image: Int) {
    Image(
        painter = rememberImagePainter(data = image),
        contentDescription = null,
        modifier = Modifier
            .height(165.dp)
            .width(165.dp),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun FindAnimalDetailScreenPreview() {
    val navController = rememberNavController()
    FindAnimalDetailScreen(navController)
}