package com.llama.petmilly_client.presentation.serachscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun SerachScreen() {

    val (search, setsearch) = rememberSaveable {
        mutableStateOf("")
    }

    val isserach = true

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            TextField(
                value = search,
                onValueChange = setsearch,
                modifier = Modifier
                    .weight(8f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,
                ),
                placeholder = { Text(text = "정보를 검색해보세요.") },
            )

            Spacer(modifier = Modifier.width(5.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1.5f)
                    .width(55.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Search_ButtonColor),
                shape = RoundedCornerShape(10.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_search),
                    contentDescription = null,
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (isserach) {
            IsSearchScreen()
        } else {
            NotingSerachScreen()
        }


//        Text(text = "더보기")


    }


}

@Composable
fun IsSearchScreen() {

    val context = LocalContext.current
    val stringlist = listOf(
        "라떼",
        "라떼언니",
        "라마",
        "라마짱짱"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .height(330.dp)
            .background(color = Color(0xFFF8F4F4), shape = RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "최근 검색어",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(top = 16.dp, start = 14.dp),
                fontSize = 14.sp,
                color = Black_40_Transfer,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )

            )

            Spacer(modifier = Modifier.weight(1f))


            Text(
                text = "전체 삭제",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(top = 16.dp, end = 14.dp),
                fontSize = 14.sp,
                color = Black_40_Transfer,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )

            )
        }//Row

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(Modifier.padding(horizontal = 20.dp)) {

            items(stringlist){ item->
                SearchItems(searchtext = item ) {
                    Toast.makeText(context, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
                }

                Spacer(modifier = Modifier.height(20.dp))
            }

        }

        Spacer(modifier = Modifier.weight(1f))

        if(stringlist.size > 10){

            Text(
                text = "더보기",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 25.dp),
                fontSize = 14.sp,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color(0xFF1FA5DE),
                textAlign = TextAlign.Center
            )
        }



    }
}

@Composable
fun NotingSerachScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .height(330.dp)
            .background(color = Color(0xFFF8F4F4), shape = RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = "최근 검색어",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(top = 16.dp, start = 14.dp),
                fontSize = 14.sp,
                color = Black_40_Transfer,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )

            )

            Spacer(modifier = Modifier.weight(1f))


            Text(
                text = "전체 삭제",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(top = 16.dp, end = 14.dp),
                fontSize = 14.sp,
                color = Black_40_Transfer,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )

            )
        }//Row

        Text(
            text = "최근 검색어가 없어요..!",
            modifier = Modifier.align(Alignment.Center),
            fontSize = 15.sp,
            fontFamily = notosans_regular,
            color = Black_30_Transfer,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

    }
}

@Preview
@Composable
fun SerachPreview() {
    SerachScreen()
}

