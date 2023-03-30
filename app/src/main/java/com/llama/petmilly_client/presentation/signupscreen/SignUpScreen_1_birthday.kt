package com.llama.petmilly_client.presentation.signupscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Grey_100_CBC4C4
import com.llama.petmilly_client.ui.theme.Grey_50_CBC4C4
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_2_GENDER
import llama.test.jetpack_dagger_plz.utils.Common.TAG


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen_1_birthday(navController: NavController, viewModel: SignUpViewModel) {

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val yearFocusRequester = remember { FocusRequester() }
    val monthFocusRequest = remember { FocusRequester() }
    val dayFocusRequest = remember { FocusRequester() }

    Column(modifier = Modifier.fillMaxSize().background(color = Color.White)) {
        TitleBar(title = "", ismenu = false, clickBack = {
            navController.popBackStack()
        }) {

        }

        CommonSignDescription()

        Text(
            text = "${MainApplication.signupname}님의 생일은\n언제인가요?",
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



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
        ) {
            Row(modifier = Modifier.weight(4f)) {

                TextField(
                    value = viewModel.birthday_year.value,
                    onValueChange = {
                        if (it.length <= 4) {
                            viewModel.birthday_year.value = it
                            viewModel.birthday.value = viewModel.birthday_year.value + viewModel.birthday_month.value + viewModel.birthday_day.value

                            if (it.length == 4) {
                                monthFocusRequest.requestFocus()
                            }
                        }

                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
//                        focusedLabelColor = Color.White,
                        cursorColor = Color.Black,
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),

                    textStyle = TextStyle(
                        fontSize = 30.sp, fontFamily = notosans_bold,
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),

                    placeholder = {
                        Text(
                            text = "1990년",
                            fontSize = 30.sp,
                            fontFamily = notosans_bold,
                            color = Grey_100_CBC4C4,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )
                    }
                )


            }


            Row(modifier = Modifier.weight(3f)) {
                TextField(
                    value = viewModel.birthday_month.value,
                    onValueChange = {
                        if (it.length <= 2) {
                            viewModel.birthday_month.value = it
                            viewModel.birthday.value = viewModel.birthday_year.value + viewModel.birthday_month.value + viewModel.birthday_day.value

                            if (it.length == 2) {
                                dayFocusRequest.requestFocus()
                            }

                        }
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    maxLines = 1,
                    modifier = Modifier.focusRequester(monthFocusRequest),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
//                        focusedLabelColor = Color.White,
                        cursorColor = Color.Black,
                    ),
                    textStyle = TextStyle(
                        fontSize = 30.sp, fontFamily = notosans_bold,
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),

                    placeholder = {
                        Text(
                            text = "02월",
                            fontSize = 30.sp,
                            fontFamily = notosans_bold,
                            color = Grey_100_CBC4C4,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )
                    }
                )
            }

            Row(modifier = Modifier.weight(3f)) {
                TextField(
                    value = viewModel.birthday_day.value,
                    onValueChange = {
                        if (it.length <= 2) {
                            viewModel.birthday_day.value = it
                            viewModel.birthday.value = viewModel.birthday_year.value + viewModel.birthday_month.value + viewModel.birthday_day.value
                            if (it.length == 2) {
                                keyboardController?.hide()
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),

//                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
//                    keyboardActions = KeyboardActions(onNext = {
//                        focusManager.moveFocus(FocusDirection.Down)
//                    }),
                    maxLines = 1,
                    modifier = Modifier.focusRequester(dayFocusRequest),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
//                        focusedLabelColor = Color.White,
                        cursorColor = Color.Black,
                    ),
                    textStyle = TextStyle(
                        fontSize = 30.sp, fontFamily = notosans_bold,
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),

                    placeholder = {
                        Text(
                            text = "04일",
                            fontSize = 30.sp,
                            fontFamily = notosans_bold,
                            color = Grey_100_CBC4C4,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )
                    }
                )


            }


        }




        Spacer(modifier = Modifier.weight(1f))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 20.dp, bottom = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "1/8",
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
                backgroundcolor = if (viewModel.birthday.value.length == 8) Button_Clicked  else Button_NoneClicked
            ) {
                if (viewModel.birthday.value.length == 8) {
                    navController.navigate(SIGNUPSCREEN_2_GENDER)
//                    Log.d(TAG, "SignUpScreen_1_birthday: ${viewModel.birthday.value}")
                } else {
                    Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()
                }

            }
        }//Box

    }


}

@Composable
fun CommonSignDescription() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_blue_circle),
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


