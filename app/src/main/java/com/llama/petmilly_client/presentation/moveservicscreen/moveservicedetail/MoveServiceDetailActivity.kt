package com.llama.petmilly_client.presentation.moveservicscreen.moveservicedetail

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Grey_100_CBC4C4
import com.llama.petmilly_client.ui.theme.Grey_50_CBC4C4
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import llama.test.jetpack_dagger_plz.utils.Common


private lateinit var progressDialog: ProgressDialog
@AndroidEntryPoint
class MoveServiceDetailActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressDialog = ProgressDialog(this, R.style.ProgressBarDialog)
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.setCancelable(false)

        setContent {
            val navController = rememberNavController()
            val viewModel: MoveServiceDetailViewModel = hiltViewModel()

            NavHost(
                navController = navController,
                startDestination = Common.MOVESERVICEDETAILSCREEN_1_ANIMALTYPE
            ) {
                composable(Common.MOVESERVICEDETAILSCREEN_1_ANIMALTYPE) {
                    MoveServiceDetail_1_AnimalTypes_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@MoveServiceDetailActivity
                    )
                }

                composable(Common.MOVESERVICEDETAILSCREEN_2_PROFILE_1) {
                    MoveServiceDetail_2_Profile_1_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@MoveServiceDetailActivity
                    )
                }

                composable(Common.MOVESERVICEDETAILSCREEN_2_PROFILE_2) {
                    MoveServiceDetail_2_Profile_2_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@MoveServiceDetailActivity
                    )
                }

                composable(route = Common.MOVESERVICEDETAILSCREEN_3_INPUT) {
                    MoveServiceDetailScreen_3_Input(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@MoveServiceDetailActivity
                    )
                }

                composable(route = Common.MOVESERVICEDETAILSCREEN_4_INPUT) {
                    MoveServiceDetailScreen_4_Input(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@MoveServiceDetailActivity
                    )
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}

@Composable
fun MoveServiceDetailScreen_3_Input(
    navController: NavController,
    viewModel: MoveServiceDetailViewModel,
    activity: Activity,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ShelterDetailTitleBar(
            title = "이동봉사 찾아요",
            ismenu = false,
            clickBack = { activity.finish() }) {
            activity.finish()
        }

        MoveServiceDetailSuvTitle("이동봉사 정보를\n입력해주세요.")

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "이동봉사 정보",
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
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            TextField(
                value = viewModel.startAddress.value,
                onValueChange = { viewModel.startAddress.value = it },
                modifier = Modifier
                    .weight(8.5f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,
                ),
                textStyle = TextStyle(
                    fontFamily = notosans_regular,
                    fontSize = 15.sp,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                placeholder = {
                    Text(
                        text = "이동봉사 출발지",
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
                painter = painterResource(id = R.drawable.img_comment_location),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .height(45.dp)
                    .width(45.dp),
                contentScale = ContentScale.Crop
            )
        }//Row

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            TextField(
                value = viewModel.endAddress.value,
                onValueChange = { viewModel.endAddress.value = it },
                modifier = Modifier
                    .weight(8.5f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,
                ),
                textStyle = TextStyle(
                    fontFamily = notosans_regular,
                    fontSize = 15.sp,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                placeholder = {
                    Text(
                        text = "이동봉사 도착지",
                        fontFamily = notosans_regular,
                        fontSize = 15.sp,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                    )
                }
            )


            Image(
                painter = painterResource(id = R.drawable.img_comment_location),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .height(45.dp)
                    .width(45.dp),
                contentScale = ContentScale.Crop
            )
        }//Row

        Spacer(modifier = Modifier.weight(1f))

        val ischeck = viewModel.startAddress.value != "" && viewModel.endAddress.value != ""

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {

            ButtonScreen(
                title = "다음",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = if (ischeck) Color.Black else Button_NoneClicked

            ) {
                if (ischeck) {
                    navController.navigate(Common.MOVESERVICEDETAILSCREEN_4_INPUT)
                }
            }

            Text(
                text = "3/4", fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = if (ischeck) Color.White else Grey_50_CBC4C4,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
            )

        }

    }

}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MoveServiceDetailScreen_4_Input(
    navController: NavController,
    viewModel: MoveServiceDetailViewModel,
    activity: Activity,
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val monthFocusRequest = remember { FocusRequester() }
    val dayFocusRequest = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        ShelterDetailTitleBar(
            title = "이동봉사 찾아요",
            ismenu = false,
            clickBack = { navController.popBackStack() }) {
            activity.finish()
        }

        MoveServiceDetailSuvTitle("이동봉사 정보를\n입력해주세요.")

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "이동봉사 희망날짜",
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
                    value = viewModel.move_year.value,
                    onValueChange = {
                        if (it.length <= 2) {
                            viewModel.move_year.value = it
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
                    value = viewModel.move_month.value,
                    onValueChange = {
                        if (it.length <= 2) {
                            viewModel.move_month.value = it

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
                    value = viewModel.move_day.value,
                    onValueChange = {
                        if (it.length <= 2) {
                            viewModel.move_day.value = it
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
            text = "특이사항 (선택)",
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

        TextField(
            value = viewModel.etc.value,
            onValueChange = { viewModel.etc.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .height(80.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
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
                    text = "특이사항 및 어필할 수 있는 한마디를 입력해주세요.",
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

        Spacer(modifier = Modifier.weight(1f))
        viewModel.hopeDate.value = "${viewModel.move_year.value}-${viewModel.move_month.value}-${viewModel.move_day.value}"
        val ischeck = viewModel.hopeDate.value != ""


        ButtonScreen(
            title = "완료",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                .height(55.dp),
            backgroundcolor = if (ischeck) Color.Black else Button_NoneClicked

        ) {
            if (ischeck) {
                viewModel.postmoveservicepost()
            }
        }

    }

    LaunchedEffect(context) {
        setObserve(
            activity,
            viewModel,
            lifecycleOwner
        )
    }
}

private fun setObserve(
    activity: Activity,
    viewModel: MoveServiceDetailViewModel,
    lifecycleOwner: LifecycleOwner,

    ) {

    viewModel.showProgress.observe(lifecycleOwner, Observer {
        progressDialog.show()
    })

    viewModel.closeProgress.observe(lifecycleOwner, Observer {
        progressDialog.dismiss()
    })

    viewModel.setfinsh.observe(lifecycleOwner, Observer {
        activity.finish()
    })
}


@Composable
fun MoveServiceDetailSuvTitle(text: String) {
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
                text = stringResource(id = R.string.moveservicesuvtitle),
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
