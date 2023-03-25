package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.dialog.SetAlomostCompletedDialog
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.ui.theme.Grey_100_CBC4C4
import com.llama.petmilly_client.ui.theme.Grey_50_CBC4C4
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ShelterDetail_8_Application_Period_Screen(
    navController: NavController,
    viewModel: ShelterDetailViewModel,
    activity: Activity,
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    SetAlomostCompletedDialog(
        viewModel.isAlmostCompletedDialog, onDismiss = {
            viewModel.onDismissAlmostCompetedDialog()
        },
        activity = activity
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        ShelterDetailTitleBar(
            title = "임보처구해요",
            ismenu = false,
            clickBack = { navController.popBackStack() }) {
            viewModel.onShownAlmostCompetedDialog()
        }

        ShelterDetailSuvTitle("신청서 접수기간\n희망 시 입력해주세요.")

        Spacer(modifier = Modifier.height(28.dp))


        Text(
            text = "신청서 접수기간(선택)",
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

            TextField(
                value = viewModel.apstartyear.value,
                modifier = Modifier.weight(5f),
                onValueChange = {
                    viewModel.apstartyear.value = it
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
                        text = "23-02-28",
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


            TextField(
                value = viewModel.apendyear.value,
                modifier = Modifier.weight(5f),
                onValueChange = {
                    viewModel.apendyear.value = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
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
                        text = "23-06-10",
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

        Spacer(modifier = Modifier.height(33.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .background(color = Color(0xFFECF2FF)),

            ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 25.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.img_puppy),
                    contentDescription = null,
                    modifier = Modifier
                        .width(50.dp)
                        .height(40.dp)
                        .align(Alignment.CenterStart)
                )

                Image(
                    painter = painterResource(id = R.drawable.img_puppy_star),
                    contentDescription = null,
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = 20.dp)
                )

            }

            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxHeight(), verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "* 임보/입양신청서 접수기간 설정 시",
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,
                )
                Text(
                    text = " 해당 기간 내 신청서 접수 받을 수 있으며,",
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,

                    )

                Text(
                    text = " 작성자분의 심사를 통해 선별할 수 있습니다.",
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,

                    )

            }//Column
        }//Row

        Spacer(modifier = Modifier.height(19.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(61.dp)
                .background(color = Color(0xFFECF2FF)),

            ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 25.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.img_puppy),
                    contentDescription = null,
                    modifier = Modifier
                        .width(50.dp)
                        .height(40.dp)
                        .align(Alignment.CenterStart)
                )

                Image(
                    painter = painterResource(id = R.drawable.img_puppy_star),
                    contentDescription = null,
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = 20.dp)
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxHeight(), verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "* 기간 미설정 시,",
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,
                )
                Text(
                    text = " 수시로 채팅으로 문의받을 수 있습니다.",
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,


                    )

            }//Column
        }//Row

        Spacer(modifier = Modifier.weight(1f))



        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {
            ButtonScreen(
                title = "완료",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = Color.Black
            ) {
                viewModel.posttemporaryprotection()
                activity.finish()
            }


        }
    }

    LaunchedEffect(context){
        setObserve(viewModel, lifecycleOwner, activity, context)
    }
}

private fun setObserve(
    viewModel: ShelterDetailViewModel,
    lifecycleOwner: LifecycleOwner,
    activity: Activity,
    context: Context,
) {
    viewModel.setcompleted.observe(lifecycleOwner, Observer {
        activity.finish()
    })

//    viewModel.setnotcompleted.observe(lifecycleOwner, Observer {
//        Toast.makeText(context, "$it 에러가 발생했습니다. 잠시후 재시도 해주세요.", Toast.LENGTH_SHORT).show()
//    })
}





