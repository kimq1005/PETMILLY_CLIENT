package com.llama.petmilly_client.presentation.shelterscreen

import android.content.Intent
import android.opengl.Visibility
import android.util.Log
import android.view.View
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.certificationscreen.CertificationActivity
import com.llama.petmilly_client.presentation.dialog.AdoptionApplicationDialog
import com.llama.petmilly_client.presentation.dialog.AdoptionCompletedDialog
import com.llama.petmilly_client.presentation.homescreen.HomeActivity
import com.llama.petmilly_client.presentation.loginscreen.CustomDialog
import com.llama.petmilly_client.ui.theme.Name_Speech_Bubble
import com.llama.petmilly_client.ui.theme.Purple700
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun AnimalInfoDetailScreen(
    navController: NavController,
    viewModel: ShelterViewModel = viewModel(),
) {

    val context = LocalContext.current
    viewModel.setanimalinfovalue()
    val scrollState = rememberScrollState()

    Box {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
        ) {


            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
                Box() {

                    Text(
                        " ",
                        modifier = Modifier
                            .height(130.dp)
                            .width(130.dp)
                            .background(color = Color.Blue)
                            .align(Alignment.CenterStart),
                    )

                    Image(
                        painter = painterResource(id = R.drawable.baseline_heart_broken_24),
                        contentDescription = null,
                        modifier = Modifier
                            .height(31.dp)
                            .width(31.dp)
                            .align(Alignment.TopStart)
                            .padding(start = 8.dp, top = 8.dp)
                    )
                }


                Column(
                    modifier = Modifier
                        .height(130.dp)
                        .padding(start = 15.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp)
                    ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.img_name_speech_bubble_rectangle),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .height(20.dp)
//                            .width(20.dp)
//                            .padding(start = 10.dp)
//                    )
//

                        Text(
                            text = "\uD83D\uDC49 미소가 이쁜 감자예요",
                            modifier = Modifier
                                .background(
                                    color = Name_Speech_Bubble,
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(vertical = 5.dp, horizontal = 8.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {

//                        viewModel.onDismissDialog()
                        Text(
                            text = if (viewModel.testBoolean.value) viewModel.animalspecies.value else "${viewModel.animalspecies.value}(완료) ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Text(
                            text = "수컷",
                            fontSize = 13.sp,
                            color = Color.Gray,
                            modifier = Modifier.align(Alignment.Bottom)
                        )
                    }


                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "${viewModel.animalspecies.value} / ${viewModel.animalweight.value}kg/ ${viewModel.animalage.value} 추정",
                        color = Color.DarkGray,
                        fontSize = 13.sp

                    )
                    Text(
                        text = "현재위치지역 어디어디동",
                        color = Color.DarkGray,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                }
            }//Row


            Text(
                text = "프로필", modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 30.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp), color = Color.Black
            )

            Column(modifier = Modifier.padding(20.dp)) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, bottom = 10.dp)
                ) {
                    Text(
                        text = "중성화/접종 ",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "중성화O/1차 접종 완료 ",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp), color = Color.LightGray
                )



                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, bottom = 10.dp)
                ) {
                    Text(
                        text = "성격",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "소심하고 순해요. 아직 아가라 알 순 없지만 기를 살려 줄 임보분이면 좋겠습니다.",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp), color = Color.LightGray
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, bottom = 10.dp)
                ) {
                    Text(
                        text = "개인기",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "앉아 까지 가능 합니다.",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp), color = Color.LightGray
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, bottom = 10.dp)
                ) {
                    Text(
                        text = "특징",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "성견되면 15kg대까지 추정되어요. 왕크니까 왕귀엽죠 스케일링/건강 여기 자유로 쓰게할까 고민중.",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp), color = Color.LightGray
                )
            }//Column


            if(!viewModel.testBoolean.value){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
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
                            text = "신청서 접수기간 : 23.01.01 ~ 23.01.07",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF3050F6),
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        Text(
                            text = "신청서 심사기간 : 23.08.01 ~ 23.01.10",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 5.dp)

                        )
                        Text(
                            text = "* 입양신청서 심사 후 확정 시 앱 알림 및 채팅을 통해 안내드립니다.",
                            fontWeight = FontWeight.Bold,
                            color = Color.LightGray,
                            fontSize = 11.sp
                        )

                    }//Column
                }//Row
            }

            
            //임보처 구해요 완료
            if (viewModel.testBoolean.value) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "임보 정보", modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 10.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp, bottom = 10.dp), color = Color.Black
                    )

                    Column() {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, bottom = 10.dp)
                        ) {
                            Text(
                                text = "픽업방법 ",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "직접픽업 ",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        }

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp), color = Color.LightGray
                        )



                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, bottom = 10.dp)
                        ) {
                            Text(
                                text = "희망지역",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "서울/ 경기",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        }

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp), color = Color.LightGray
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, bottom = 10.dp)
                        ) {
                            Text(
                                text = "임보기간",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "2달",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        }

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 5.dp), color = Color.LightGray
                        )


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, bottom = 10.dp)
                        ) {
                            Text(
                                text = "임보조건",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "✅ 서울 성북동 연계병원에서 픽업가능한 분(#2월2일 #2월3일)\n" +
                                        "✅ 서울 성북동의 연계병 2주에 1번 통원 가능능한 분 체크무늬는추가추가해서하도록하고 작성할때 플러스버튼으로 적용용",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        }

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 5.dp), color = Color.LightGray
                        )


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, bottom = 10.dp)
                        ) {
                            Text(
                                text = "이런분을 희망해요",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "✅  응급 시 연계병원으로 이동 가능한 분",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        }

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 5.dp), color = Color.LightGray
                        )


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, bottom = 10.dp)
                        ) {
                            Text(
                                text = "이런분은 안돼요",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "❌ 집을 비우는 시간이 너무 기신 분",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        }

                    }//Column

                    Text(
                        text = "사진첩", modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, start = 10.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp, bottom = 10.dp), color = Color.Black
                    )
                }//Column
            }


        }//Column


        Image(
            painter = painterResource(id = R.drawable.img_chat_contact),
            contentDescription = null,

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 40.dp, end = 15.dp)
                .width(55.dp)
                .height(55.dp)
                .clickable {
                    viewModel.onConfirmClick()
                }
        )

        if (viewModel.isDialogShown) {
            AdoptionApplicationDialog(
                onDismiss = { viewModel.onDismissDialog() },
                onConfirm = {
                    //동의 신청서 다이얼로그
                    viewModel.onDismissDialog()
                    viewModel.onAdoptionDialogConfirmClick()
                },
                onModify = {
                    val intent = Intent(context, CertificationActivity::class.java)
                    context.startActivity(intent)
                }
            )
        }

        if (viewModel.isAdoptionApplicationDialogShown) {
            AdoptionCompletedDialog(
                onDismiss = { viewModel.onAdoptionDialogDismissDialog() },
                onConfirm = { Log.d(TAG, "AnimalInfoDetailScreen: wow") })

        }

    }//Box

}


@Preview
@Composable
fun Woy() {
    val navController = rememberNavController()
    AnimalInfoDetailScreen(navController)
}


@Composable
fun ButtonExample() {
    Box() {
        Image(painter = painterResource(id = R.drawable.img_name_speech_bubble),
            contentDescription = null,
            modifier = Modifier
                .clickable { })
    }
}
