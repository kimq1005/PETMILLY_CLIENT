package com.llama.petmilly_client.presentation.dialog

import android.hardware.lights.Light
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Black_Half_Transfer
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Purple200
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AdoptionApplicationDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    onModify: () -> Unit,
    ischatroom: Boolean,
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(if(!ischatroom) 0.80f else 0.70f)
        ) {

            Column() {

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

                Spacer(modifier = Modifier.height(5.dp))

                Image(
                    painter = painterResource(id = R.drawable.img_shelter_application),
                    contentDescription = null,
                    modifier = Modifier
                        .height(27.dp)
                        .width(27.dp)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "??????/?????? ?????????",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                    color = Color.Black,
                    fontFamily = notosans_bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                        .background(
                            color = Color(0xFF26b5b3b3),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 20.dp, start = 20.dp, end = 20.dp)

                ) {
                    AplicationTextRow("??????/??????", "?????????", modifier = Modifier)
                    AplicationTextRow(
                        "????????????",
                        "961005",
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    AplicationTextRow(
                        "??????",
                        "??????????????? ?????????",
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    AplicationTextRow(
                        "????????????",
                        "????????? ????????? ?????????",
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    AplicationTextRow(
                        "??????????????????",
                        "??????(?????????)",
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "(?????????/9???/??????/?????????O)",
                        fontSize = 9.sp,
                        color = Color.Black,
                        textAlign = TextAlign.End
                    )
                    Divider(
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp)
                            .fillMaxWidth(), color = Color.LightGray
                    )

                    AplicationTextRow("???????????? ??????", "??????", modifier = Modifier)
                    AplicationTextRow("????????? ??????", "??????", modifier = Modifier.padding(top = 10.dp))
                    AplicationTextRow("????????????", "??????", modifier = Modifier.padding(top = 10.dp))

                    Divider(
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp)
                            .fillMaxWidth(), color = Color.LightGray
                    )

                    Row {
                        Text(
                            text = "???????????????",
                            fontSize = 12.sp,
                            fontFamily = notosans_bold,
                            color = Color.Black,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )

                        Text(
                            text = "(???????????????)",
                            fontSize = 12.sp,
                            fontFamily = notosans_regular,
                            color = Color.Black,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )

                    }
                    AplicationTextRow(
                        "????????????",
                        "?????????,??????",
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    AplicationTextRow(
                        "????????????",
                        "??????",
                        modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
                    )

                }

                if (!ischatroom) {
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = stringResource(id = R.string.modifiy),
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onModify()
                            }
                            .padding(end = 20.dp),
                        textAlign = TextAlign.End,
                        fontFamily = notosans_regular,
                        style = TextStyle(textDecoration = TextDecoration.Underline),
                        color = Color(0xFF1793ED)

                    )

                    Spacer(modifier = Modifier.weight(1f))


                    ButtonScreen(
                        title = "?????? ??? ??????",
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


            }
        }
    }
}

@Composable
fun AplicationTextRow(text_first: String, text_second: String, modifier: Modifier) {
    Row(modifier = modifier) {
        Text(
            text = text_first,
            fontFamily = notosans_regular,
            fontSize = 13.sp,
            color = Black_Half_Transfer,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )


        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = text_second,
            fontSize = 13.sp,
            color = Color.Black,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )

        )
    }//Row
}


@Preview
@Composable
fun Preview() {
    AdoptionApplicationDialog(onDismiss = {}, onConfirm = {}, onModify = {}, true)

}
