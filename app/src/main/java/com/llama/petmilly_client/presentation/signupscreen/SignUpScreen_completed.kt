package com.llama.petmilly_client.presentation.signupscreen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.utils.ButtonScreen
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun SignUpScreen_completed(navController: NavController, viewModel: SignUpViewModel){
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(75.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            Text(
                text = "OOO님,\n펫밀리가 되신걸\n환영합니다!",
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 30.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Text(
                text = "더 많은 유기견들이,\n따뜻한 가족 품으로\n돌아갈 수 있도록 함께 해주세요",
                fontSize = 20.sp,
                modifier = Modifier,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

        }


        ButtonScreen(
            title = "확인",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(55.dp)
                .align(Alignment.BottomCenter),
            backgroundcolor = Button_Clicked
        ) {
            viewModel.postadditionalinfo()
            Log.d(TAG, "SignUpScreen_completed: ${viewModel.housekind.value}")

        }

    }

}
