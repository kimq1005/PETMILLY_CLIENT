package com.llama.petmilly_client.presentation.findanimalscreen.findanimaldetailscreen

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun FADetailScreen_4_DetailInfo(
    navController: NavController,
    viewModel: FADetailViewModel,
    activity: Activity,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        ShelterDetailTitleBar(
            title = "우리아이 찾아요",
            ismenu = false,
            clickBack = { navController.popBackStack() }
        ) {
            activity.finish()
        }

        FADetailSuvTitle("실종 당시 정보를\n상세히 입력해주세요.")

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "실종당시 옷",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = viewModel.clothes.value,
            onValueChange = { viewModel.clothes.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .height(52.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            textStyle = TextStyle(
                fontFamily = notosans_regular,
                fontSize = 15.sp,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            placeholder = {
                Text(
                    text = "실종당시 옷차림을 입력해주세요.",
                    fontSize = 15.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "목줄여부&색깔",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = viewModel.lead.value,
            onValueChange = { viewModel.lead.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .height(52.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            textStyle = TextStyle(
                fontFamily = notosans_regular,
                fontSize = 15.sp,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),

            placeholder = {
                Text(
                    text = "실종당시 착용한 목줄에 대해 설명해주세요.",
                    fontSize = 15.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "특징 및 유의사항",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = viewModel.etc.value,
            onValueChange = { viewModel.etc.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .height(120.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor =  TextField_BackgroudColor ,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            textStyle = TextStyle(
                fontFamily = notosans_regular,
                fontSize = 15.sp,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            placeholder = {
                Text(
                    text = "아이에 대한 특징 및 유의사항에 대해 적어주세요.\n" +
                            "상세하게 기재할수록 도움이 됩니다.",
                    fontSize = 15.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                .height(55.dp),
            backgroundcolor = Color.Black

        ) {
            navController.navigate(Common.FADETAILSCREEN_5_COMMENT_ISOPEN)

        }

    }


}
