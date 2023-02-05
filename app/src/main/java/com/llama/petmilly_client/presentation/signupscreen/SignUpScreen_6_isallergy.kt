package com.llama.petmilly_client.presentation.signupscreen

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

@Composable
fun SignUpScreen_6_isallergy(navController: NavController) {

    val viewModel: SignUpViewModel = viewModel()
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        TitleBar(title = "", ismenu = false, clickBack = {
            navController.popBackStack()
        }) {
        }

        CommonSignDescription()

        Text(
            text = "OOO님,\n동물 관련하여 \n알러지가 있으신가요?",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        ButtonShapeScreen(
            title = "네 알러지 있어요",
            textcolor = Color.White,
            fontSize = 18,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp, bottom = 10.dp)
                .height(55.dp),
            backgroundcolor = if (viewModel.isallery.value == 0 ) Button_Clicked else Button_NoneClicked,
            shape = RoundedCornerShape(19.dp)
        ) {
            viewModel.isallery.value = 0
        }

        ButtonShapeScreen(
            title = "아니요, 없어요",
            textcolor = Color.White,
            fontSize = 18,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp, bottom = 10.dp)
                .height(55.dp),
            backgroundcolor = if (viewModel.isallery.value == 1 ) Button_Clicked else Button_NoneClicked,
            shape = RoundedCornerShape(19.dp)
        ) {
            viewModel.isallery.value = 1
        }


        ButtonShapeScreen(
            title = "모르겠어요",
            textcolor = Color.White,
            fontSize = 18,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp)
                .height(55.dp),
            backgroundcolor = if (viewModel.isallery.value == 2 ) Button_Clicked else Button_NoneClicked,
            shape = RoundedCornerShape(19.dp)
        ) {
            viewModel.isallery.value = 2
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
            backgroundcolor = Button_Clicked
        ) {
//            if (viewModel.istemporarycare.value) {
//                navController.navigate(Common.SIGNUPSCREEN_3)
//            } else {
//                Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()
//            }
        }
    }// Column
}

@Preview
@Composable
fun isallergy(){
    val navController = rememberNavController()
    SignUpScreen_6_isallergy(navController = navController)
}