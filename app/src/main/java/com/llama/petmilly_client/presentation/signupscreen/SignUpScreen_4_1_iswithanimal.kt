package com.llama.petmilly_client.presentation.signupscreen.viewmodel

import android.graphics.drawable.shapes.OvalShape
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.CommonSignDescription
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.*
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_4_2_CALLYOUTANIMAL
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_5_ISTEMPORARYCARE

@Composable
fun SignUpScreen_4_1_iswithanimal(navController: NavController, viewModel: SignUpViewModel) {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().background(color = Color.White)) {
        TitleBar(title = "", ismenu = false, clickBack = {
            navController.popBackStack()
        }) {
        }

        CommonSignDescription()
//

        Text(
            text = "${MainApplication.signupname}님,\n현재 반려동물과\n같이 살고 계신가요?",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
            fontFamily =  notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.livewithanimal.value == "네, 같이 살고 있어요.") {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "네, 같이 살고 있어요",
                textcolor = if (viewModel.livewithanimal.value == "네, 같이 살고 있어요.") Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 5.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.livewithanimal.value == "네, 같이 살고 있어요.") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if(viewModel.livewithanimal.value== "네, 같이 살고 있어요.") notosans_bold else notosans_regular
            ) {
                viewModel.livewithanimal.value = "네, 같이 살고 있어요."
            }

        }//Row


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.livewithanimal.value == "아니요, 같이 살고 있지 않아요.") {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "아니요, 같이 살고 있지 않아요",
                textcolor = if (viewModel.livewithanimal.value == "아니요, 같이 살고 있지 않아요.") Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 5.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.livewithanimal.value == "아니요, 같이 살고 있지 않아요.") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily =   if (viewModel.livewithanimal.value == "아니요, 같이 살고 있지 않아요.") notosans_bold else notosans_regular
            ) {
                viewModel.livewithanimal.value = "아니요, 같이 살고 있지 않아요."
            }

        }//Row


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.livewithanimal.value == "지금은 아니지만, 키운적은 있어요.") {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "지금은 아니지만, 키운적은 있어요.",
                textcolor = if (viewModel.livewithanimal.value == "지금은 아니지만, 키운적은 있어요.") Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 5.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.livewithanimal.value == "지금은 아니지만, 키운적은 있어요.") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily =if (viewModel.livewithanimal.value == "지금은 아니지만, 키운적은 있어요.") notosans_bold else notosans_regular
            ) {
                viewModel.livewithanimal.value = "지금은 아니지만, 키운적은 있어요."
            }

        }//Row


        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 20.dp, bottom = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "4/8",
                modifier = Modifier.align(Alignment.TopEnd),
                fontSize = 13.sp,
                color = Color.LightGray
            )

            ButtonScreen(
                title = "다음",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .align(Alignment.BottomCenter),
                backgroundcolor = if (viewModel.livewithanimal.value == "") Button_NoneClicked else Button_Clicked
            ) {
                if (viewModel.livewithanimal.value != "") {
                    if (viewModel.livewithanimal.value == "네, 같이 살고 있어요.") {
                        navController.navigate(SIGNUPSCREEN_4_2_CALLYOUTANIMAL)
                    }else{
                        navController.navigate(SIGNUPSCREEN_5_ISTEMPORARYCARE)
                    }
                } else {
                    Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()
                }
            }
        }


    }// Column
}


