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
import com.llama.petmilly_client.presentation.settingscreen.SettingPreview
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SecessionDialog(
    onDismiss: () -> Unit,
    onSecession: () -> Unit,
) {
    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {

        Card(
            elevation = 5.dp,
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(0.41f)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {

                Image(
                    painter = painterResource(id = R.drawable.img_cancle),
                    contentDescription = null,
                    modifier = Modifier
                        .height(35.dp)
                        .width(35.dp)
                        .align(Alignment.End)
                        .padding(top = 16.dp, end = 16.dp)
                        .clickable { onDismiss() },
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.padding(top = 30.dp))


                Text(
                    text = "정말 탈퇴하시겠습까?",
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
                    )

                )

                Spacer(modifier = Modifier.height(45.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .background(
                            color = Color(0xFF26b5b3b3),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(17.dp)
                ) {

                    Text(
                        text = "탈퇴 시 데이터는 저장되지않으며, \n재가입 시 연동되지 않습니다.",
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


                Spacer(modifier = Modifier.weight(1f))

                ButtonScreen(
                    title = "탈퇴하기",
                    textcolor = Color.White,
                    fontSize = 15,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp, bottom = 35.dp)
                        .height(50.dp),
                    backgroundcolor = Button_Clicked
                ) {
                    onSecession()

                }


            }
        }

    }

}

@Preview
@Composable
fun SettingDialogPreview() {
    SecessionDialog(
        onDismiss = {},
        onSecession = {}
    )
}

