package com.llama.petmilly_client.presentation.signupscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.ButtonScreen
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_2_GENDER
import llama.test.jetpack_dagger_plz.utils.Common.TAG


@Composable
fun SignUpScreen_1_birthday(navController: NavController, viewModel: SignUpViewModel) {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        TitleBar(title = "", ismenu = false, clickBack = {
            navController.popBackStack()
        }) {

        }

        CommonSignDescription()

        Text(
            text = "OOO님의 생일은\n언제인가요?",
            fontSize = 30.sp,
            modifier = Modifier.padding(40.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        TextField(
            value = viewModel.birthday.value,
            onValueChange = { viewModel.birthday.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(35.dp),
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
                    text = "1991년 02월 04일",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(55.dp),
            backgroundcolor = if (viewModel.birthday.value == "") Button_NoneClicked else Button_Clicked
        ) {
            if (viewModel.birthday.value != "") {
                navController.navigate(SIGNUPSCREEN_2_GENDER)
            } else {
                Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()
            }

        }
    }
}

@Composable
fun CommonSignDescription(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 40.dp, end = 40.dp, bottom = 30.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_blue_circle),
            contentDescription = null,
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)

        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = stringResource(R.string.signup_top_description),
            fontSize = 13.sp,
            color = Color.Black
        )
    }
}
