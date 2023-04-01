package com.llama.petmilly_client.presentation.findanimalscreen.findanimaldetailscreen

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Grey_100_CBC4C4
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FADetailScreen_3_DetailInfo(
    navController: NavController,
    viewModel: FADetailViewModel,
    activity: Activity,
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val monthFocusRequest = remember { FocusRequester() }
    val dayFocusRequest = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {

        ShelterDetailTitleBar(
            title = "우리아이 찾아요",
            ismenu = false,
            clickBack = { activity.finish() }
        ) {
            activity.finish()
        }

        FADetailSuvTitle("실종 당시 정보를\n상세히 입력해주세요.")

        Spacer(modifier = Modifier.height(36.dp))


        Text(
            text = "실종일시",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ) {
            Row(modifier = Modifier.weight(2f)) {

                TextField(
                    value = viewModel.missing_year.value,
                    onValueChange = {
                        if (it.length <= 2) {
                            viewModel.missing_year.value = it
                            if (it.length == 2) {
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
                            text = "21년",
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


            Row(modifier = Modifier.weight(2f)) {
                TextField(
                    value = viewModel.missing_month.value,
                    onValueChange = {
                        if (it.length <= 2) {
                            viewModel.missing_month.value = it

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

            Row(modifier = Modifier.weight(2f)) {
                TextField(
                    value = viewModel.missing_day.value,
                    onValueChange = {
                        if (it.length <= 2) {
                            viewModel.missing_day.value = it
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



            Image(
                painter = painterResource(id = R.drawable.img_shelter_plus),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .height(35.dp)
                    .width(35.dp),
                contentScale = ContentScale.Crop
            )


        }


        Spacer(modifier = Modifier.height(70.dp))

        Text(
            text = "실종지역",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {

            TextField(
                value = viewModel.missingAddress.value,
                onValueChange = { viewModel.missingAddress.value = it },
                modifier = Modifier
                    .weight(8.5f)
                    .height(52.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor ,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,

                    ),
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = notosans_regular,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                placeholder = {
                    Text(
                        text = "실종지역을 입력해주세요.",
                        fontSize = 15.sp,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
                    )
                }
            )

            Image(
                painter = painterResource(id = R.drawable.img_shelter_plus),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .height(45.dp)
                    .width(45.dp),
                contentScale = ContentScale.Crop
            )

        }



        Spacer(modifier = Modifier.weight(1f))
        viewModel.missingDate.value = "${viewModel.missing_year.value}-${viewModel.missing_month.value}-${viewModel.missing_day.value}"

        val ischeck = viewModel.missingDate.value != "" && viewModel.missingAddress.value != ""


        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                .height(55.dp),
            backgroundcolor = if (ischeck) Color.Black else Button_NoneClicked

        ) {
            if (ischeck) {
                navController.navigate(Common.FADETAILSCREEN_4_DETAILINFO)
            }
        }

    }


}

@Composable
fun FADetailSuvTitle(text: String) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_jong),
                contentDescription = null,
                modifier = Modifier
                    .width(44.dp)
                    .height(44.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = stringResource(id = R.string.fasubtitle),
                fontSize = 13.sp,
                color = Color.Black,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = text,
            modifier = Modifier.padding(start = 40.dp),
            fontSize = 30.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black
        )

    }

}
