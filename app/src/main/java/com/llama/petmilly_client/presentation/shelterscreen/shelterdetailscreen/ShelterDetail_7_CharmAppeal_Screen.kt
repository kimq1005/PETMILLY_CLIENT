package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.presentation.dialog.SetAlomostCompletedDialog
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun ShelterDetail_CharmAppeal_7_Screen(
    navController: NavController,
    viewModel: ShelterDetailViewModel,
    activity: Activity,
) {
    SetAlomostCompletedDialog(
        viewModel.isAlmostCompletedDialog, onDismiss = {
            viewModel.onDismissAlmostCompetedDialog()
        },
        activity = activity
    )

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ShelterDetailTitleBar(
            title = "임보처구해요",
            ismenu = false,
            clickBack = { navController.popBackStack() }) {
            viewModel.onShownAlmostCompetedDialog()
        }

        ShelterDetailSuvTitle("주인공의 매력어필을\n한줄로 해주세요.")

        Spacer(modifier = Modifier.height(28.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "매력어필",
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

            Text(
                text = " (띄어쓰기 포함 최대 20자)",
                color = Color.Black,
                fontSize = 13.sp,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
        }


        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = viewModel.charmAppeal.value,
            onValueChange = { viewModel.charmAppeal.value = it },
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
            maxLines = 1,

            placeholder = {
                Text(
                    text = "예)미소가 이쁜 감자에요."
                )
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {
            val ischeck = viewModel.charmAppeal.value != ""

            ButtonScreen(
                title = "다음",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = if (ischeck) Color.Black else Color.LightGray

            ) {
                if(ischeck){
                    navController.navigate(Common.SHELTERDETAIL_8_APPLICATION_SCREEN)
                }
            }

            Text(
                text = "7/8", fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
            )

        }

    }
}