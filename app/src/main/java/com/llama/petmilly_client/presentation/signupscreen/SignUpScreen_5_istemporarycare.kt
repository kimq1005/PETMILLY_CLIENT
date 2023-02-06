package com.llama.petmilly_client.presentation.signupscreen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.ButtonShapeScreen
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_6_ISALLERGY

@Composable
fun SignUpScreen_5_istemporarycare(navController: NavController) {

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
            text = "OOO님,\n'임시보호' 해보신 적\n있으신가요?",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .clickable {
                    viewModel.checkCallYourAnimal()
                },
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonShapeScreen(
                title = "No",
                textcolor = Color.White,
                fontSize = 18,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp),
                backgroundcolor = if (viewModel.istemporarycare.value) Button_NoneClicked else Button_Clicked,
                shape = RoundedCornerShape(19.dp)
            ) {
                viewModel.istemporarycare.value = false

            }

            Spacer(modifier = Modifier.width(10.dp))

            ButtonShapeScreen(
                title = "Yes",
                textcolor = Color.White,
                fontSize = 18,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp),
                backgroundcolor = if (!viewModel.istemporarycare.value) Button_NoneClicked else Button_Clicked,
                shape = RoundedCornerShape(19.dp)
            ) {
                viewModel.istemporarycare.value = true

            }
        }//Row

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
            navController.navigate(SIGNUPSCREEN_6_ISALLERGY)
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
fun IstemPor() {
    val navController = rememberNavController()
    SignUpScreen_5_istemporarycare(navController = navController)
}