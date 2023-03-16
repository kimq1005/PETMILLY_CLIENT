package com.llama.petmilly_client.presentation.signupscreen

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_3_JOB
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@SuppressLint("InvalidColorHexValue")
@Composable
fun SignUpScreen_2_gender(navController: NavController, viewModel: SignUpViewModel) {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().background(color = Color.White)) {
        TitleBar(title = "", ismenu = false, clickBack = {
            navController.popBackStack()
        }) {

        }

        CommonSignDescription()
//
//        Spacer(modifier = Modifier.height(55.dp))

        Text(
            text = "${MainApplication.signupname}님\n성별을 알려주세요!",
            fontSize = 30.sp,
            modifier = Modifier.padding(40.dp),
            fontFamily =  notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(35.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        viewModel.gender.value = "남성"
                    }
            ) {
                Text(
                    text = "",
                    modifier = Modifier
                        .height(150.dp)
                        .width(155.dp)
                        .background(
                            color = Color(0xFF20999999), shape = RoundedCornerShape(20.dp)
                        )
                        .align(Alignment.Center)

                )

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = (-30).dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = com.llama.petmilly_client.R.drawable.img_man),
                        contentDescription = null,
                        modifier = Modifier
                            .height(145.dp)
                            .width(145.dp)
                    )
                    Text(
                        text = "남성",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }


            Spacer(modifier = Modifier.width(5.dp))


            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        viewModel.gender.value = "여성"
                    }
            ) {
                Text(
                    text = "",
                    modifier = Modifier
                        .height(150.dp)
                        .width(155.dp)
                        .background(
                            color = Color(0xFF20B616B9), shape = RoundedCornerShape(20.dp)
                        )
                        .align(Alignment.Center)

                )

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = (-30).dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = com.llama.petmilly_client.R.drawable.img_woman),
                        contentDescription = null,
                        modifier = Modifier
                            .height(145.dp)
                            .width(145.dp)
                    )
                    Text(
                        text = "여성",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }

//            Text(
//                text = "Woman",
//                modifier = Modifier
//                    .weight(1f)
//                    .fillMaxHeight()
//                    .background(color = Color(0xFF999999), shape = RoundedCornerShape(20.dp))
//                    .clickable {
//                        viewModel.gender.value = "wowman"
//                    },
//                textAlign = TextAlign.Center
//            )
//        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 20.dp, bottom = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "2/8",
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
                backgroundcolor = if (viewModel.gender.value == "") Button_NoneClicked else Button_Clicked
            ) {
                if (viewModel.gender.value != "") {
                    navController.navigate(SIGNUPSCREEN_3_JOB)
                } else {
                    Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()
                }

            }

        }


    }


}


@Preview
@Composable
fun Gender() {
    val navController = rememberNavController()
    val viewModel: SignUpViewModel = hiltViewModel()
    SignUpScreen_2_gender(navController = navController, viewModel = viewModel)
}