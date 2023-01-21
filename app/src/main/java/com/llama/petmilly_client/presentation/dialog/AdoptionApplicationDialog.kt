package com.llama.petmilly_client.presentation.dialog

import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
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


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AdoptionApplicationDialog(
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
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(0.70f)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "입양 신청서",
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "가입 시 정보가 맞습니까?\n OR 아래 정보로 제출하시겠습니까?",
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.view_margin_16dp))
                        .background(Purple200)
                        .padding(dimensionResource(id = R.dimen.view_margin_10dp))

                ) {
                    Text(text = "닉네임 / 성함")
                    Text(text = "직업 ")
                    Text(text = "사는지역")
                    Text(text = "반려동물 유무")
                    Text(text = "임보 경험")
                    Text(text = "가족관계")
                    Text(text = "가족구성원")
                    Text(text = "알러지")
                    Text(text = "실내환경")
                    Text(text = "관심분야")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "수정하기", fontSize = 18.sp, modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.weight(1f))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {
                    Button(
                        onClick = { onDismiss() },
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp, end = 5.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Button_NoneClicked)


                    ) {
                        Text(
                            text = "취소",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Button(
                        onClick = { onConfirm() },
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 5.dp, end = 20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Button_Clicked)

                    ) {
                        Text(
                            text = "동의 및 제출",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview(){
    AdoptionApplicationDialog(onDismiss = { }) {
        
    }
}
