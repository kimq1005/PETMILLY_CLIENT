package com.llama.petmilly_client.presentation.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.Cancle
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ChatRoomDialog(
    onCompleted: () -> Unit,
    onAlarmOff: () -> Unit,
    onBenUser: () -> Unit,
    onReport: () -> Unit,
    onFavoriteChatRoom: () -> Unit,
    onExitChatRoom: () -> Unit,
    onDismiss: () -> Unit,
) {
    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp)
        ) {

            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                Card(
                    elevation = 5.dp,
                    modifier = Modifier
                        .padding(35.dp)
                    , shape = RoundedCornerShape(7.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        
                        Spacer(modifier = Modifier.padding(top = 20.dp))

                        Text(
                            text = "완료(귀가) 처리",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )

                        )

                        Spacer(modifier = Modifier.height(20.dp))
                        Divider(
                            modifier = Modifier.padding(horizontal = 20.dp),
                            color = Black_30_Transfer
                        )


                        Text(
                            text = "알람 끄기",
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable {
                                    onAlarmOff()
                                },
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )

                        )

                        Text(
                            text = "차단하기",
                            modifier = Modifier
                                .padding(top = 25.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable {
                                    onBenUser()
                                },
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )

                        )

                        Text(
                            text = "신고하기",
                            modifier = Modifier
                                .padding(top = 25.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable {
                                    onReport()
                                },
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )

                        Spacer(modifier = Modifier.height(25.dp))
                        Divider(
                            modifier = Modifier.padding(horizontal = 20.dp),
                            color = Black_30_Transfer
                        )


                        Text(
                            text = "채팅방 즐겨찾기",
                            modifier = Modifier
                                .padding(top = 25.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable {
                                    onReport()
                                },
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )


                        Text(
                            text = "채팅방 나가기",
                            modifier = Modifier
                                .padding(top = 25.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable {
                                    onReport()
                                },
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                    }

                }//Card

                //
                ButtonScreen(
                    title = "취소",
                    textcolor = Color.White,
                    fontSize = 15,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 35.dp, end = 35.dp, bottom = 35.dp)
                        .height(50.dp),
                    backgroundcolor = Button_Clicked
                ) {
                    onDismiss()

                }
            }//Colum

        }

    }
}

@Preview
@Composable
fun ASDASDASDA() {
    ChatRoomDialog(
        onDismiss = {},
        onAlarmOff = {},
        onBenUser = {},
        onCompleted = {},
        onExitChatRoom = {},
        onReport = {
        },
        onFavoriteChatRoom = {}
    )
}

