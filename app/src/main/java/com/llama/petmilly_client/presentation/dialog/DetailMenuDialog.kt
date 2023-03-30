package com.llama.petmilly_client.presentation.dialog

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
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.SpacerHeight
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MoveServiceDetailDialog(
    onModifiy: () -> Unit,
    onDelete: () -> Unit,
    onUp: () -> Unit,
    onComplete:()->Unit,
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
                        .fillMaxWidth(0.75f)
                    , shape = RoundedCornerShape(7.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {



                        Text(
                            text = "수정 하기",
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable {
                                    onModifiy()
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
                            text = "삭제 하기",
                            modifier = Modifier
                                .padding(top = 25.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable {
                                    onDelete()
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
                            text = "끌올",
                            modifier = Modifier
                                .padding(top = 25.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable {
                                    onUp()
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

//                        Divider(
//                            modifier = Modifier.padding(horizontal = 20.dp),
//                            color = Black_30_Transfer
//                        )


                        Text(
                            text = "완료(귀가) 하기",
                            modifier = Modifier
                                .padding(top=25.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable {
                                    onComplete()
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

                SpacerHeight(dp = 10.dp)
                //
                ButtonScreen(
                    title = "취소",
                    textcolor = Color.White,
                    fontSize = 15,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
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
fun ADFAFAFG(){
    MoveServiceDetailDialog(
        onDismiss = {},
        onComplete = {},
        onDelete = {},
        onModifiy = {},
        onUp = {}
    )
}
