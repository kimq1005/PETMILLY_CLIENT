package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.presentation.dialog.SetAlomostCompletedDialog
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.ui.theme.Grey_50_CBC4C4
import com.llama.petmilly_client.utils.*
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun ShelterDetail_3_profile_Screen(
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

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {

        ShelterDetailTitleBar(
            title = "임보처구해요",
            ismenu = false,
            clickBack = { navController.popBackStack() }) {
           viewModel.onShownAlmostCompetedDialog()
        }

        ShelterDetailSuvTitle("주인공의 프로필을\n완성해주세요.")
        /////////////////////

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "중성화 여부",
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ButtonScreen_HOUSE(
                title = "중성화 O",
                textcolor = if (viewModel.isneutered.value == "중성화 O") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(70.dp),
                backgroundcolor = if (viewModel.isneutered.value == "중성화 O") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                enabled = viewModel.isneutered.value != "모르겠어요"
            ) {
                viewModel.isneutered.value = "중성화 O"
            }

            ButtonScreen_HOUSE(
                title = "중성화 X",
                textcolor = if (viewModel.isneutered.value == "중성화 X") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(70.dp),
                backgroundcolor = if (viewModel.isneutered.value == "중성화 X") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                enabled = viewModel.isneutered.value != "모르겠어요",
                textAlign = TextAlign.Center,
            ) {
                viewModel.isneutered.value = "중성화 X"
            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.padding(start = 27.dp)) {
           IDontKnowCheckBox(onclick = { string->
               viewModel.isneutered.value = string
           })
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "모르겠어요", fontSize = 12.sp, fontFamily = notosans_regular, style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color(0xFF050505)
            )
        }//Row

        Spacer(modifier = Modifier.height(65.dp))

        Text(
            text = "접종 여부",
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ButtonScreen_HOUSE(
                title = "미접종",
                textcolor = if (viewModel.isinoculation.value == "미접종") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(100.dp),
                backgroundcolor = if (viewModel.isinoculation.value == "미접종") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                enabled = viewModel.isinoculation.value != "모르겠어요",
                ) {
                viewModel.isinoculation.value = "미접종"
            }

            ButtonScreen_HOUSE(
                title = "1차완료",
                textcolor = if (viewModel.isinoculation.value == "1차완료") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(100.dp),
                backgroundcolor = if (viewModel.isinoculation.value == "1차완료") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                enabled = viewModel.isinoculation.value != "모르겠어요",
            ) {
                viewModel.isinoculation.value = "1차완료"
            }

            ButtonScreen_HOUSE(
                title = "2차 완료",
                textcolor = if (viewModel.isinoculation.value == "2차완료") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(100.dp),
                backgroundcolor = if (viewModel.isinoculation.value == "2차완료") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                enabled = viewModel.isinoculation.value != "모르겠어요",
            ) {
                viewModel.isinoculation.value = "2차완료"
            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.padding(start = 27.dp)) {

            IDontKnowCheckBox(onclick = { string->
                viewModel.isinoculation.value = string
            })

            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "모르겠어요", fontSize = 12.sp, fontFamily = notosans_regular, style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color(0xFF050505)
            )
        }//Row


        /////////////////////
        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {
            val ischeck = viewModel.isinoculation.value != "" && viewModel.isneutered.value != ""

            ButtonScreen(
                title = "다음",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = if (ischeck) Color.Black else Color.LightGray

            ) {
                if (ischeck) {
                        navController.navigate(Common.SHELTERDETAIL_4_PROFILE_SCREEN)
                }
            }

            Text(
                text = "3/8", fontSize = 13.sp,
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

    }//Column
}
