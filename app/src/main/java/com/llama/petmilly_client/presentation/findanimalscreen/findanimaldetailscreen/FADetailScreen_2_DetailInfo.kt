package com.llama.petmilly_client.presentation.findanimalscreen.findanimaldetailscreen

import android.app.Activity
import android.icu.text.UnicodeSet.SpanCondition
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
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun FADetailScreen_2_DetailInfo(
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
            value = viewModel.missingclothes.value,
            onValueChange = { viewModel.missingclothes.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .height(52.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = if (viewModel.missingclothes.value == "") TextField_BackgroudColor else Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = {
                Text(
                    text = "실종당시 옷차림을 입력해주세요."
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
            value = viewModel.issnood.value,
            onValueChange = { viewModel.issnood.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .height(52.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = if (viewModel.issnood.value == "") TextField_BackgroudColor else Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = {
                Text(
                    text = "아이에 대한 특징 및 유의사항에 대해 적어주세요.\n상세하게 기재할수록 도움이 됩니다."
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
            value = viewModel.missingspecies.value,
            onValueChange = { viewModel.missingspecies.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .height(120.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = if (viewModel.missingspecies.value == "") TextField_BackgroudColor else Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = {
                Text(
                    text = "실종당시 착용한 목줄에 대해 설명해주세요."
                )
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        val ischeck =
            viewModel.missingclothes.value != "" && viewModel.issnood.value != "" && viewModel.missingspecies.value != ""


        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                .height(55.dp),
            backgroundcolor = if (ischeck) Color.Black else Button_NoneClicked

        ) {
            if (ischeck) {
                        navController.navigate(Common.FADETAILSCREEN_3_COMMENT_ISOPEN)
            } else {

            }
        }

    }


}
