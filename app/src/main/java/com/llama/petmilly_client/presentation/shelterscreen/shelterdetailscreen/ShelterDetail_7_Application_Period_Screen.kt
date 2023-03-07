package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.dialog.SetAlomostCompletedDialog
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Grey_50_CBC4C4
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterDetail_7_Application_Period_Screen(navController: NavController, viewModel: ShelterDetailViewModel,activity:Activity) {

    SetAlomostCompletedDialog(
        viewModel.isAlmostCompletedDialog, onDismiss = {
            viewModel.onDismissAlmostCompetedDialog()
        },
        activity = activity
    )
    
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {

        ShelterDetailTitleBar(
            title = "임보처구해요",
            ismenu = false,
            clickBack = { navController.popBackStack() }) {
               viewModel.onShownAlmostCompetedDialog()
        }

        ShelterDetailSuvTitle("신청서 접수기간\n희망 시 입력해주세요.")

        Spacer(modifier = Modifier.height(28.dp))


        Text(
            text = "신청서 접수기간(선택)",
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


        TextField(
            value = viewModel.hopeapplicationperiod.value,
            onValueChange = { viewModel.hopeapplicationperiod.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,
            ),
            textStyle = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),

            placeholder = {
                Text(
                    text = "23.00.00 ~ 23.00.00",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray
                )
            }
        )

        Spacer(modifier = Modifier.height(33.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .background(color = Color(0xFFECF2FF)),

            ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 25.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.img_puppy),
                    contentDescription = null,
                    modifier = Modifier
                        .width(50.dp)
                        .height(40.dp)
                        .align(Alignment.CenterStart)
                )

                Image(
                    painter = painterResource(id = R.drawable.img_puppy_star),
                    contentDescription = null,
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = 20.dp)
                )

            }

            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxHeight(), verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "* 임보/입양신청서 접수기간 설정 시",
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,
                )
                Text(
                    text = " 해당 기간 내 신청서 접수 받을 수 있으며,",
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,

                )

                Text(
                    text = " 작성자분의 심사를 통해 선별할 수 있습니다.",
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,

                )

            }//Column
        }//Row

        Spacer(modifier = Modifier.height(19.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(61.dp)
                .background(color = Color(0xFFECF2FF)),

            ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 25.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.img_puppy),
                    contentDescription = null,
                    modifier = Modifier
                        .width(50.dp)
                        .height(40.dp)
                        .align(Alignment.CenterStart)
                )

                Image(
                    painter = painterResource(id = R.drawable.img_puppy_star),
                    contentDescription = null,
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = 20.dp)
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxHeight(), verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "* 기간 미설정 시,",
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,
                )
                Text(
                    text = " 수시로 채팅으로 문의받을 수 있습니다.",
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,


                )

            }//Column
        }//Row

        Spacer(modifier = Modifier.weight(1f))



        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {
            val ischeck = viewModel.hopepeople.value != "" && viewModel.nopeople.value != ""

            ButtonScreen(
                title = "완료",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = if (ischeck) Color.Black else Button_NoneClicked

            ) {
                if (ischeck) {
                        activity.finish()
                    //임보처 구해요 글쓰기 완료
                } else {

                }
            }

            Text(
                text = "", fontSize = 13.sp,
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