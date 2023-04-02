package com.llama.petmilly_client.presentation.findanimalscreen

import android.app.ProgressDialog
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common

private lateinit var progressDialog: ProgressDialog

@Composable
fun CommentTitlebar(
    clickBack: () -> Unit,
) {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp),
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .align(Alignment.CenterStart)
                .clickable {
                    clickBack()
                }
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 10.dp)
        ) {
            Text(
                text = "댓글",
                fontSize = 17.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Text(
                text = "우리아이 찾아요",
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )


        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FindAnimalCommentScreen(navController: NavController, viewModel: FindAnimalViewModel) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        CommentTitlebar {
            navController.popBackStack()
        }

        val context = LocalContext.current
        val lifecycleOwner = LocalLifecycleOwner.current
        val monthFocusRequest = remember { FocusRequester() }
        val dayFocusRequest = remember { FocusRequester() }
        val keyboardController = LocalSoftwareKeyboardController.current


        progressDialog = ProgressDialog(context, R.style.ProgressBarDialog)
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.setCancelable(false)

        Text(
            text = "목격 위치 제보 (필수)",
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 35.dp),
            fontFamily = notosans_bold,
            color = Black_60_Transfer
        )
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            TextField(
                value = viewModel.sightingAddress.value,
                onValueChange = { viewModel.sightingAddress.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(53.dp)
                    .weight(8f)
                    .clickable {

                    },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = {
//                    focusManager.moveFocus(FocusDirection.Down)
                }),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,

                    ),
                placeholder = { Text(text = "목격장소의 위치를 적어주세요.") }
            )

            Image(
                painter = painterResource(id = R.drawable.img_comment_location),
                contentDescription = null,
                modifier = Modifier
                    .height(45.dp)
                    .width(45.dp)
                    .weight(2f)
                    .align(Alignment.CenterVertically),
            )

        }

        Spacer(modifier = Modifier.height(7.dp))

        TextField(
            value = viewModel.comment.value,
            onValueChange = { viewModel.comment.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .height(53.dp)
                .clickable {

                },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
//                    focusManager.moveFocus(FocusDirection.Down)
            }),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = { Text(text = "목격장소를 상세히 설명해주세요.") }
        )

        Spacer(modifier = Modifier.height(55.dp))

        Text(
            text = "목격 날짜/시간 (필수)",
            fontSize = 14.sp,
            fontFamily = notosans_bold,
            modifier = Modifier.padding(start = 35.dp),
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Black_60_Transfer
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

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "사진인증 (선택)",
            fontSize = 14.sp,
            fontFamily = notosans_bold,
            modifier = Modifier.padding(start = 35.dp),
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Black_60_Transfer
        )

        Spacer(modifier = Modifier.height(7.dp))
        Image(
            painter = painterResource(id = R.drawable.img_comment_camera),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 40.dp)
                .height(47.dp)
                .width(47.dp)

        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "* 작성자분의 댓글 제보 비공개  요청으로,\n" +
                    "제보해주신 댓글은 게시물 작성자에게만 공개됩니다.",
            modifier = Modifier.padding(horizontal = 35.dp),
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            fontSize = 13.sp,
            color = Black_60_Transfer
        )

        Spacer(modifier = Modifier.height(22.dp))
        viewModel.sightingDate.value =
            "${viewModel.missing_year.value}-${viewModel.missing_month.value}-${viewModel.missing_day.value}"
        val ischeck =
            viewModel.sightingAddress.value != "" && viewModel.comment.value != "" && viewModel.sightingDate.value != ""

        ButtonScreen(
            title = "제보 완료",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(horizontal = 35.dp),
            backgroundcolor = Button_Clicked
        ) {
            if (ischeck) {
                viewModel.postfindmypetcomment()

            }

        }

        Spacer(modifier = Modifier.height(25.dp))

        LaunchedEffect(context) {
            setObserve(viewModel, lifecycleOwner, navController)
        }

    }//Box
}

private fun setObserve(
    viewModel: FindAnimalViewModel,
    lifecycleOwner: LifecycleOwner,
    navController: NavController,
) {

    viewModel.showProgress.observe(lifecycleOwner, Observer {
        progressDialog.show()
    })

    viewModel.closeProgress.observe(lifecycleOwner, Observer {
        progressDialog.dismiss()
    })

    viewModel.setIntent.observe(lifecycleOwner, Observer {
        navController.popBackStack()
    })
}
