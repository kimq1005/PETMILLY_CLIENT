package com.llama.petmilly_client.presentation.signupscreen.viewmodel

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.CommonSignDescription
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.ButtonScreen
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun SignUpScreen_4_1_iswithanimal(navController: NavController) {

    val viewModel: SignUpViewModel = viewModel()
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        TitleBar(title = "", ismenu = false, clickBack = {
            navController.popBackStack()
        }) {
        }

        CommonSignDescription()
//

        Text(
            text = "OOO님,\n현재 반려동물과\n같이 살고 계신가요?",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                          viewModel.livewithanimal.value ="같이 살고있어요"
                },
                modifier = Modifier.weight(1f).padding(5.dp)
            ){
                Text(text = "네 같이\n살고 있어요", textAlign = TextAlign.Center)
            }

            Button(
                onClick = { viewModel.livewithanimal.value = "아니요 없어욥" },
                modifier = Modifier.weight(1f).padding(5.dp)
            ){
                Text(text = "아니요 \n없어요", textAlign = TextAlign.Center)
            }

            Button(
                onClick = { viewModel.livewithanimal.value = "키운적 있어욥" },
                modifier = Modifier.weight(1f).padding(5.dp)
            ){
                Text(text = "키운적\n있어요", textAlign = TextAlign.Center)
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
            backgroundcolor = if (viewModel.livewithanimal.value == "") Button_NoneClicked else Button_Clicked
        ) {
            if (viewModel.livewithanimal.value != "") {
                navController.navigate(Common.SIGNUPSCREEN_3)
            } else {
                Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()
            }
        }
    }// Column
}

@Preview
@Composable
fun Iswithanimal() {
    val navController = rememberNavController()
    SignUpScreen_4_1_iswithanimal(navController = navController)
}