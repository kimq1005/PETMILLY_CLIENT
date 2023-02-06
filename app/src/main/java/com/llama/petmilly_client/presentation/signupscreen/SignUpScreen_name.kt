package com.llama.petmilly_client.login

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.ButtonShapeScreen
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_1_BIRTHDAY

@Composable
fun SignUpScreen_name(navController: NavController, viewModel: SignUpViewModel = hiltViewModel()) {


    val (name, setname) = rememberSaveable {
        mutableStateOf("")
    }

    val (nickname, setnickname) = rememberSaveable {
        mutableStateOf("")
    }

    val context= LocalContext.current

    TitleBar(title = "", ismenu = false, clickBack = { }) {

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.pet_milly_title),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = "petmily",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(bottom = 6.dp)
            )
        }//Row


        Spacer(modifier = Modifier.height(65.dp))

        Text(
            text = "성함 (입양/임보 시)",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(start = 5.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        TextField(
            value = viewModel.name.value,
            onValueChange = { viewModel.name.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = { Text(text = "성함을 입력해주세요. ") }
        )

        Spacer(modifier = Modifier.height(62.dp))
        ///
        Text(
            text = "닉네임 (일반 활동 시)",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(start = 5.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = viewModel.nickname.value,
                onValueChange = { viewModel.nickname.value = it },
                modifier = Modifier
                    .weight(8F)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,

                    ),
                placeholder = { Text(text = "2~10자 이내로 입력해주세요 ") }
            )

            Spacer(modifier = Modifier.width(4.dp))

            ButtonShapeScreen(
                title = "확인",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .weight(2f)
                    .height(55.dp),
                backgroundcolor = Button_NoneClicked,
                shape = RoundedCornerShape(10.dp)
            ) {

            }
        }//Row

        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            backgroundcolor = if (viewModel.name.value == "" && viewModel.nickname.value == "") Button_NoneClicked else Button_Clicked
        ) {
            if (viewModel.name.value != "" && viewModel.nickname.value != ""){
                navController.navigate(SIGNUPSCREEN_1_BIRTHDAY)
//                viewModel.postkakaotoken()

            }else{
                Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()
            }

        }
    }

}