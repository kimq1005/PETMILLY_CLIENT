package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.app.Activity
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.dialog.SetAlomostCompletedDialog
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Grey_50_CBC4C4
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun ShelterDetail_6_conditons_Screen(
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

        ShelterDetailSuvTitle("임보조건을\n입력해주세요.")

        Spacer(modifier = Modifier.height(28.dp))
        ///////////////////////////////////////

        Text(
            text = "\uD83D\uDC81\u200D 이런분을 희망해요",
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

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            TextField(
                value = viewModel.hopepeople.value,
                onValueChange = { viewModel.hopepeople.value = it },
                modifier = Modifier
                    .weight(8.5f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = if (viewModel.hopepeople.value == "") TextField_BackgroudColor else Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,

                    ),
                placeholder = { Text(text = "예) 출퇴근 유연하신 분") }
            )


            Image(
                painter = painterResource(id = R.drawable.img_shelter_plus),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .height(45.dp)
                    .width(45.dp),
                contentScale = ContentScale.Crop
            )
        }//Row

        Spacer(modifier = Modifier.height(90.dp))

        Text(
            text = "✋\u200D 이런분은 안돼요",
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

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            TextField(
                value = viewModel.nopeople.value,
                onValueChange = { viewModel.nopeople.value = it },
                modifier = Modifier
                    .weight(8.5f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = if (viewModel.nopeople.value == "") TextField_BackgroudColor else Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,

                    ),
                placeholder = { Text(text = "예) 2주에1회 병원 통원 가능하신 분") }
            )


            Image(
                painter = painterResource(id = R.drawable.img_shelter_plus),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .height(45.dp)
                    .width(45.dp),
                contentScale = ContentScale.Crop
            )
        }//Row


        ///////////////////////////////////////
        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {
            val ischeck = viewModel.hopepeople.value != "" && viewModel.nopeople.value != ""

            ButtonScreen(
                title = "다음",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = if (ischeck) Color.Black else Button_NoneClicked

            ) {
                if (ischeck) {
                    navController.navigate(Common.SHELTERDETAIL_7_APPLICATION_SCREEN)
                } else {

                }
            }

            Text(
                text = "6/8", fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = if (ischeck) Color.White else Grey_50_CBC4C4,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
            )

        }
    }
}