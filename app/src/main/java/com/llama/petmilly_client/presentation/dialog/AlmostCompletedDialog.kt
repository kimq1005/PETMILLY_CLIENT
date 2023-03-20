package com.llama.petmilly_client.presentation.dialog

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen.ShelterDetailViewModel
import com.llama.petmilly_client.ui.theme.Black_80_Transfer
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.SpacerHeight
import com.llama.petmilly_client.utils.SpacerWidth
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AlmostCompletedDialog(
    onDismiss: () -> Unit,
    onExit: () -> Unit,
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            elevation = 5.dp,
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(0.47f)
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.img_cancle),
                    contentDescription = null,
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .align(Alignment.End)
                        .padding(top = 16.dp, end = 16.dp)
                        .clickable { onDismiss() },
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(5.dp))

                Image(
                    painter = painterResource(id = R.drawable.img_yello_trash),
                    contentDescription = null,
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop
                )

                SpacerHeight(dp = 16.dp)

                Text(
                    text = "거의 다 작성하셨어요!",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                )

                Spacer(modifier = Modifier.height(25.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                        .background(
                            color = Color(0xFF26b5b3b3),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(20.dp)

                ) {
                    Text(
                        text = "지금 나가면 작성하신 내용이 모두 사라져요!",
                        fontSize = 14.sp,
                        fontFamily = notosans_regular,
                        color = Black_80_Transfer,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    SpacerHeight(dp = 5.dp)

                    Text(
                        text = "재작성 시 처음부터 닫시 작성해야합니다.",
                        fontSize = 14.sp,
                        fontFamily = notosans_regular,
                        color = Black_80_Transfer,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }//Colimn

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, bottom = 40.dp)
                ) {
                    Text(
                        text = "이어서 쓰기",
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .background(
                                color = Category_Cliked,
                                shape = RoundedCornerShape(6.dp)
                            )
                            .padding(horizontal = 20.dp, vertical = 15.dp)
                            .weight(1f)
                            .clickable {
                                onDismiss()
                            },
                        textAlign = TextAlign.Center
                    )

                    SpacerWidth(dp = 7.dp)

                    Text(
                        text = "나가기",
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .background(
                                color = Color(0xFFDADADA),
                                shape = RoundedCornerShape(6.dp)
                            )
                            .padding(horizontal = 20.dp, vertical = 15.dp)
                            .weight(1f)
                            .clickable {
                                onExit()
                            },
                        textAlign = TextAlign.Center
                    )

                }

            }//Column

        }

    }
}

@Composable
fun SetAlomostCompletedDialog(
    isAlmostCompletedDialog: Boolean,
    onDismiss: () -> Unit,
    activity: Activity?,
) {
    if (isAlmostCompletedDialog) {
        AlmostCompletedDialog(
            onDismiss = {
                onDismiss()
            },
            onExit = {
                activity?.finish()
            }
        )
    }
}


//
//@Preview
//@Composable
//fun DKWO() {
//    AlmostCompletedDialog(
//        onContinue = {},
//        onDismiss = {},
//        onExit = {}
//    )
//}