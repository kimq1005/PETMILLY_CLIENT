package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.*

@Composable
fun ShelterDetail_1_profile_Screen(
    navController: NavController,
    viewModel: ShelterDetailViewModel,
    activity: ShelterDetailActivity
) {
    Column(Modifier.fillMaxSize()) {
        ShelterDetailTitleBar(title = "임보처구해요", ismenu = false, clickBack = { navController.popBackStack()}) {
            activity.finish()
        }

        ShelterDetailSuvTitle("주인공의 프로필을\n입력해주세요.")

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "이름",
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
            value = viewModel.animalname.value,
            onValueChange = { viewModel.animalname.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = if (viewModel.animalname.value == "") TextField_BackgroudColor else Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = { Text(text = "주인공의 이름을 적어주세요.") }
        )


        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "성별",
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
                title = "수컷",
                textcolor = if (viewModel.animalsex.value == "수컷") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.animalsex.value == "수컷") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center
            ) {
                viewModel.animalsex.value = "수컷"
            }

            ButtonScreen_HOUSE(
                title = "암컷",
                textcolor = if (viewModel.animalsex.value == "암컷") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.animalsex.value == "암컷") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center
            ) {
                viewModel.animalsex.value = "암컷"
            }

            ButtonScreen_HOUSE(
                title = "모름",
                textcolor = if (viewModel.animalsex.value == "모름") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.animalsex.value == "모름") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center
            ) {
                viewModel.animalsex.value = "모름"
            }


        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "사진 첨부",
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

        Spacer(modifier = Modifier.weight(1f))

        Box(modifier = Modifier.fillMaxWidth().padding(start = 24.dp, end = 24.dp, bottom = 20.dp)) {

            val ischeck = viewModel.animalname.value != "" && viewModel.animalsex.value != ""
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
//                        navController.navigate(Common.SIGNUPSCREEN_4_3_CALLYOUTANIMAL_First)
                } else {

                }
            }

            Text(
                text = "1/8", fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = if(ischeck) Color.White  else Grey_50_CBC4C4,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
            )

        }


    }
}

@Preview
@Composable
fun ADIADA(){
    val navController = rememberNavController()
    val viewModel:ShelterDetailViewModel = hiltViewModel()
    ShelterDetail_7_Application_Period_Screen(navController,viewModel)
}