package com.llama.petmilly_client.presentation.signupscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_4_1_ISWITHANIMAL
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun SignUpScreen_3_job(navController: NavController, viewModel: SignUpViewModel) {

//    val viewModel: SignUpViewModel = viewModel()
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        TitleBar(title = "", ismenu = false, clickBack = {
            navController.popBackStack()
        }) {
        }

        CommonSignDescription()
//

        Text(
            text = "${MainApplication.signupname}님\n직업을 알려주세요!",
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


        Spacer(modifier = Modifier.height(4.dp))

        TextField(
            value = viewModel.job.value,
            onValueChange = { viewModel.job.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor =TextField_BackgroudColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = { Text(text = "직접 입력해주세요") }
        )

        Spacer(modifier = Modifier.weight(1f))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 20.dp, bottom = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "3/8",
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
                backgroundcolor = if (viewModel.job.value == "") Button_NoneClicked else Button_Clicked
            ) {
                if (viewModel.job.value != "") {
                    navController.navigate(SIGNUPSCREEN_4_1_ISWITHANIMAL)
                    Log.d(TAG, "SignUpScreen_3_job: ${viewModel.name.value}")
                } else {
                    Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()
                }

            }
        }


    }
}
