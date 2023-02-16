package com.llama.petmilly_client.presentation.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Purple200
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.Cancle
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AdoptionCompletedDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Card(
            elevation = 5.dp,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.53f)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Cancle(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 8.dp, top = 8.dp)
                        .clickable {
                            onDismiss()
                        }
                )

                Image(
                    painter = painterResource(id = R.drawable.img_blue_circle_check),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(45.dp)
                        .width(45.dp)

                )

                Text(
                    text = "신청이 완료되었어요.",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )

                )

                Spacer(modifier = Modifier.height(17.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                        .background(
                            color = Color(0xFF26b5b3b3),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(17.dp)
                ) {

                    Text(
                        text = "신청 결과는 앱 푸시로 안내드릴게요 \uD83D\uDE0A\n" +
                                "원활한 커뮤니케이션을 위해\n" +
                                "알림을 반드시  켜주세요.",
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center,
                        fontFamily = notosans_regular,
                        fontSize = 14.sp,
                        color = Color.Black,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "*미응답 시, 취소될 수 있으니 주의해주시기 바랍니다.",
                    fontSize = 12.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    textAlign = TextAlign.Center
                )


                Spacer(modifier = Modifier.weight(1f))
//
                Column {
                    ButtonScreen(
                        title = "☝️ 앱 알림 설정",
                        textcolor = Color.White,
                        fontSize = 15,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                            .height(50.dp),
                        backgroundcolor = Button_Clicked
                    ) {
                        onConfirm()

                    }

                    ButtonScreen(
                        title = "✌️ 휴대폰 알림설정",
                        textcolor = Color.White,
                        fontSize = 15,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                            .height(50.dp),
                        backgroundcolor = Button_Clicked
                    ) {
                        onConfirm()

                    }
                }
//                ButtonScreen(
//                    title = "앱 알림 설정",
//                    textcolor = Color.White,
//                    fontSize = 16,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp),
//                    backgroundcolor = Button_Clicked
//                ) {
//                    onConfirm()
//                }
            }
        }
    }
}


@Preview
@Composable
fun ADADADAD(){
    AdoptionCompletedDialog(onConfirm = {}, onDismiss = {})
}