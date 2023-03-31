package com.llama.petmilly_client.presentation.myprofilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.*


@Composable
fun MyProfileScreen(navController: NavController) {

    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(color = Color.White)
        )

        TitleBar(title = "", ismenu = true, clickBack = { }) {

        }

        Row(
            modifier = Modifier
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {

            SpacerWidth(dp = 29.dp)

            Image(
                painter = painterResource(id = R.drawable.img_testcat_2),
                contentDescription = null,
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop
            )
            SpacerWidth(dp = 16.dp)

            Column(
                verticalArrangement = Arrangement.Center
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "llama",
                        fontSize = 20.sp,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Color.Black
                    )

                    SpacerWidth(dp = 10.dp)

                    Image(
                        painter = painterResource(id = R.drawable.img_go),
                        contentDescription = null,
                        modifier = Modifier
                            .height(15.dp)
                            .width(15.dp),
                    )
                }

                SpacerHeight(dp = 3.dp)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "동네인증", color = Color.Black,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 13.sp
                    )

                    SpacerWidth(dp = 5.dp)

                    Image(
                        painter = painterResource(id = R.drawable.img_checkcircle_green),
                        contentDescription = null,
                        modifier = Modifier
                            .height(18.dp)
                            .width(18.dp)
                    )

                }
                SpacerHeight(dp = 13.dp)

                Text(
                    text = "입양 수가 많으면 애니멀호더로 의심될 수 있습니다.",
                    modifier = Modifier
                        .background(
                            color = Color(0xFFF5F5F5),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(horizontal = 7.dp, vertical = 3.dp),
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,
                    fontSize = 10.sp
                )


            }//Column

        }//Row

        SpacerHeight(dp = 20.dp)

        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Divider(modifier = Modifier.weight(1.5f), color = Color.Black)

            Box(
                modifier = Modifier
                    .weight(9f)
                    .height(62.dp)
                    .background(color = Color(0xFFECF2FF), shape = RoundedCornerShape(2.dp)),
            ) {
                CircleView(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(x = (-3).dp), color = Color.Black
                )

                Row(
                    Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "입양",
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                        Text(
                            text = "0건",
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                    }//Column

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "임보",
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                        Text(
                            text = "0건",
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                    }//Column

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "이동봉사",
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                        Text(
                            text = "0건",
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                    }//Column
                }

                Image(
                    painter = painterResource(id = R.drawable.img_exclamation_mark_circle_blue),
                    contentDescription = null,
                    modifier = Modifier
                        .height(15.dp)
                        .width(15.dp)
                        .align(Alignment.TopEnd)
                        .padding(top = 4.dp, end = 4.dp),
                    contentScale = ContentScale.Crop

                )

                CircleView(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = 3.dp), color = Color.Black
                )
            }

            Divider(modifier = Modifier.weight(1.5f), color = Color.Black)

        }//Row

        SpacerHeight(dp = 20.dp)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 50.dp)
        ) {
            Text(
                text = "펫밀리", color = Color.Black, fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp
            )

            SpacerWidth(dp = 6.dp)

            Image(
                painter = painterResource(id = R.drawable.img_exclamation_mark_circle_blue),
                contentDescription = null,
                modifier = Modifier
                    .height(15.dp)
                    .width(15.dp)
                    .padding(top = 4.dp, end = 4.dp),
                contentScale = ContentScale.Crop

            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "신뢰도 수치예요 :) 신고가 많을수록 수치는 낮아져요.",
                modifier = Modifier
                    .background(
                        color = Color(0xFFF5F5F5),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(horizontal = 7.dp, vertical = 3.dp),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black,
                fontSize = 10.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }//Row

        SpacerHeight(dp = 12.dp)


        BarGraph(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .requiredHeight(15.dp)
                .background(Color(0xFFFAEBFE), shape = RoundedCornerShape(13.dp)), percentage = 10f
        )

        SpacerHeight(dp = 20.dp)


        Column(
            Modifier
                .background(color = Color(0xFF80FDFCE1))
                .weight(1f)
        ) {

            SpacerHeight(dp = 16.dp)

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "\uD83D\uDCCC 작성 게시물", fontFamily = notosans_bold, style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.img_go), contentDescription = null,
                    modifier = Modifier
                        .height(15.dp)
                        .width(15.dp)
                )


            }//Row

            SpacerHeight(dp = 40.dp)

            Text(
                text = "게시물이 아직 없어요",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp,
                color = Black_30_Transfer,
                textAlign = TextAlign.Center
            )


            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "\uD83D\uDC8C 구조 이야기", fontFamily = notosans_bold, style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.img_go), contentDescription = null,
                    modifier = Modifier
                        .height(15.dp)
                        .width(15.dp)
                )


            }//Row

            SpacerHeight(dp = 40.dp)

            Text(
                text = "게시물이 아직 없어요",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp,
                color = Black_30_Transfer,
                textAlign = TextAlign.Center
            )



            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "\uD83E\uDDB4 임보 스토리", fontFamily = notosans_bold, style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.img_go), contentDescription = null,
                    modifier = Modifier
                        .height(15.dp)
                        .width(15.dp)
                )


            }//Row

            SpacerHeight(dp = 40.dp)

            Text(
                text = "게시물이 아직 없어요",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp,
                color = Black_30_Transfer,
                textAlign = TextAlign.Center
            )


        }


    }//Column

}

@Composable
fun NickNameChangeScreen(navController: NavController, viewModel: ProfileViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TitleBar(title = "닉네임 수정", ismenu = false, clickBack = { navController.popBackStack() }) {

        }

        Text(
            text = "닉네임", fontSize = 15.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black,
            modifier = Modifier.padding(start = 44.dp)
        )

//        SpacerHeight(dp = 10.dp)

        ClearableTextField(
            value = viewModel.changenickname.value,
            onValueChange = { newText -> viewModel.changenickname.value = newText },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp)
        )

        Spacer(modifier = Modifier.weight(1f))



        val ischeck = viewModel.changenickname.value != ""


        ButtonScreen(
            title = "저장하기",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                .height(55.dp),
            backgroundcolor = if (ischeck) Color.Black else Button_NoneClicked

        ) {
            if (ischeck) {
//                        navController.navigate(Common.SIGNUPSCREEN_4_3_CALLYOUTANIMAL_First)
            } else {

            }
        }


    }

}

@Composable
fun ClearableTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val textFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.White,
        focusedIndicatorColor = Color.Black,
        unfocusedIndicatorColor = Color.Black
    )

    var text by remember { mutableStateOf(value) }
    TextField(
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        singleLine = true,
        modifier = modifier,
        textStyle = LocalTextStyle.current.copy(textDecoration = TextDecoration.None),
        trailingIcon = {
            if (text.isNotEmpty()) {
                IconButton(onClick = { text = "" }) {
                    Icon(Icons.Filled.Clear, contentDescription = null)
                }
            }
        },
        colors = textFieldColors,


        )

}

@Preview
@Composable
fun MyProfileScreenPreview() {
    val navController = rememberNavController()
    val viewModel: ProfileViewModel = hiltViewModel()
//    MyProfileScreen(navController, viewModel)
    NickNameChangeScreen(navController, viewModel)
}
