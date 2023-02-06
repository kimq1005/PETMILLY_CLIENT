package com.llama.petmilly_client.presentation.signupscreen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.ButtonShapeScreen
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_8_CALLWORKINGTIME

@Composable
fun SignUpScreen_7_callyourhouse(navController: NavController) {
    val viewModel: SignUpViewModel = viewModel()
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        TitleBar(title = "", ismenu = false, clickBack = {
            navController.popBackStack()
        }) {
        }

        CommonSignDescription()

        Text(
            text = "OOO님,\n거주하고 계신 \n환경을 알려주세요!",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 35.dp, end = 35.dp), horizontalArrangement = Arrangement.SpaceAround) {
            ButtonShapeScreen(
                title = "아파트",
                textcolor = Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(2.dp)
                    .height(55.dp)
                    ,
                backgroundcolor = if (viewModel.housekind.value == "아파트" ) Button_Clicked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp)
            ) {
                viewModel.housekind.value = "아파트"
            }

            ButtonShapeScreen(
                title = "단독주택",
                textcolor = Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(2.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.housekind.value == "단독주택" ) Button_Clicked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp)
            ) {
                viewModel.housekind.value = "단독주택"
            }

            ButtonShapeScreen(
                title = "오피스텔",
                textcolor = Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(2.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.housekind.value == "오피스텔" ) Button_Clicked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp)
            ) {
                viewModel.housekind.value = "오피스텔"
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 35.dp, end = 35.dp), horizontalArrangement = Arrangement.SpaceAround) {
            ButtonShapeScreen(
                title = "다세대/다가구",
                textcolor = Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(2.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.housekind.value =="다세대/다가구" ) Button_Clicked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp)
            ) {
                viewModel.housekind.value = "다세대/다가구"
            }

            ButtonShapeScreen(
                title = "빌라",
                textcolor = Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(2.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.housekind.value == "빌라" ) Button_Clicked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp)
            ) {
                viewModel.housekind.value ="빌라"
            }

            ButtonShapeScreen(
                title = "원룸/투룸",
                textcolor = Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(2.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.housekind.value == "원룸/투룸" ) Button_Clicked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp)
            ) {
                viewModel.housekind.value = "원룸/투룸"
            }
        }


        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(55.dp),
            backgroundcolor = if(viewModel.housekind.value!="") Button_Clicked else Button_NoneClicked
        ) {
            if (viewModel.housekind.value!="") {
                navController.navigate(SIGNUPSCREEN_8_CALLWORKINGTIME)
            } else {
                Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()
            }
        }
    }// Column
}

@Preview
@Composable
fun CallyourHouse(){
    val navController = rememberNavController()
    SignUpScreen_7_callyourhouse(navController = navController)
}