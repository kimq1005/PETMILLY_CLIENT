package com.llama.petmilly_client.presentation.shelterscreen

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.certificationscreen.CertificationActivity
import com.llama.petmilly_client.presentation.dialog.AdoptionApplicationDialog
import com.llama.petmilly_client.presentation.dialog.AdoptionCompletedDialog
import com.llama.petmilly_client.presentation.findanimalscreen.ImageTestData
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.*
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
@ExperimentalFoundationApi
fun AnimalInfoDetailScreen(
    navController: NavController,
    viewModel: ShelterViewModel,
    id: String,
) {

    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {

        LaunchedEffect(context) {
            viewModel.id.value = id.toInt()
            viewModel.gettemporarydetail()
        }

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Box() {

                    Image(
                        painter = if (viewModel.thumbnail_detail.value != "") rememberImagePainter(
                            data = viewModel.thumbnail_detail.value
                        ) else painterResource(id = R.drawable.mainicon_png),
                        contentDescription = null,
                        modifier = Modifier
                            .height(127.dp)
                            .width(127.dp)
                            .background(color = Color.Blue)
                            .align(Alignment.CenterStart),
                        contentScale = ContentScale.Crop
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_none_heart),
                        contentDescription = null,
                        modifier = Modifier
                            .height(31.dp)
                            .width(31.dp)
                            .align(Alignment.TopStart)
                            .padding(start = 8.dp, top = 8.dp),
                        contentScale = ContentScale.Crop
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
                        Text(
                            text = "\uD83D\uDC49 ${viewModel.charmAppeal_detail.value}",
                            modifier = Modifier
                                .background(
                                    color = Name_Speech_Bubble,
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(vertical = 5.dp, horizontal = 8.dp),
                            fontSize = 12.sp,
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = if (viewModel.isCompleted_detail.value) viewModel.name_detail.value else "${viewModel.name_detail.value} ",
                            fontSize = 16.sp,
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black
                        )

                        SpacerWidth(dp = 5.dp)
                        Text(
                            text = viewModel.gender_detail.value,
                            fontSize = 13.sp,
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Black_60_Transfer,
                            modifier = Modifier.align(Alignment.Bottom)
                        )
                    }


                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "${viewModel.breed_detail.value} / ${viewModel.weight_detail.value}kg/ ${viewModel.age_detail.value}",
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.background(color = Background_FDFCE1),
                        color = Black_60_Transfer,
                        fontSize = 13.sp

                    )

                    Row() {
                        Text(
                            text = "현재위치지역",
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            fontSize = 13.sp,
                            color = Black_60_Transfer,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        Text(
                            text = " ${viewModel.shortName_detail.value}",
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            fontSize = 13.sp,
                            color = Black_60_Transfer,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )

                    }

                }
            }//Row


            Text(
                text = "프로필", modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 30.dp),
                fontSize = 16.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, start = 20.dp, end = 20.dp), color = Color.Black
            )

            Column(modifier = Modifier.padding(horizontal = 20.dp)) {

                SpacerHeight(dp = 10.dp)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, bottom = 10.dp)
                ) {
                    Text(
                        text = "중성화/접종 ",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "${viewModel.neutered_detail.value} / ${viewModel.inoculation_detail.value} ",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 15.dp),
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
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
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = viewModel.health_detail.value,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Black_60_Transfer,
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
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = viewModel.skill_detail.value,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Black_60_Transfer,
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
                        text = "성격 및 특징",
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = viewModel.character_detail.value,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

            }//Column


            if (!viewModel.isCompleted_detail.value) {
                SpacerHeight(dp = 16.dp)

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
                            text = "신청서 접수기간 : 23.04.12 ~ 23.04.21",
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color(0xFF3050F6),
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        Text(
                            text = "신청서 심사기간 : 23.04.02 ~ 23.04.10",
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 5.dp)

                        )
                        Text(
                            text = "* 임보신청서 심사 후 확정 시 앱 알림 및 채팅을 통해 안내드립니다.",
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Black_60_Transfer,
                            fontSize = 11.sp
                        )

                    }//Column
                }//Row
            }


            if (!viewModel.isCompleted_detail.value) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "임보 정보", modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 10.dp),
                        fontSize = 16.sp,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Color.Black
                    )

                    SpacerHeight(dp = 6.dp)

                    Divider(color = Color.Black)

                    Column(
                        modifier = Modifier
                            .background(color = Pink_5_Transfer)

                    ) {
                        SpacerHeight(dp = 8.dp)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, bottom = 10.dp)
                        ) {
                            Text(
                                text = "픽업방법 ",
                                fontSize = 13.sp,
                                fontFamily = notosans_bold,
                                style = TextStyle(
                                    platformStyle = PlatformTextStyle(
                                        includeFontPadding = false
                                    )
                                ),
                                color = Black_60_Transfer,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = viewModel.pickUp_detail.value,
                                fontFamily = notosans_regular,
                                style = TextStyle(
                                    platformStyle = PlatformTextStyle(
                                        includeFontPadding = false
                                    )
                                ),
                                color = Black_60_Transfer,
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
                                text = "임보조건",
                                fontFamily = notosans_bold,
                                style = TextStyle(
                                    platformStyle = PlatformTextStyle(
                                        includeFontPadding = false
                                    )
                                ),
                                color = Black_60_Transfer,
                                fontSize = 13.sp,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "✅ 출퇴근 용이하신 분",
                                fontFamily = notosans_regular,
                                style = TextStyle(
                                    platformStyle = PlatformTextStyle(
                                        includeFontPadding = false
                                    )
                                ),
                                color = Black_60_Transfer,
                                fontSize = 13.sp,
                                modifier = Modifier.width(200.dp)
                            )

//                            LazyColumn(
//                                modifier = Modifier
//                                    .padding(start = 15.dp)
//                                    .heightIn(0.dp, 100.dp)
//                            ) {
////                                ProtectionConditionItems()
//                                items(viewModel.ProtectionCondition) { items ->
//                                    ProtectionConditionItems(items.content, true)
//                                }
//
//                            }


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
                                text = "이런분을\n희망해요",
                                fontFamily = notosans_bold,
                                style = TextStyle(
                                    platformStyle = PlatformTextStyle(
                                        includeFontPadding = false
                                    )
                                ),
                                color = Black_60_Transfer,
                                fontSize = 13.sp,
                                modifier = Modifier.width(80.dp)
                            )


                            Text(
                                text = "✅ 2주에 1회 병원통원 가능하신분",
                                fontFamily = notosans_regular,
                                style = TextStyle(
                                    platformStyle = PlatformTextStyle(
                                        includeFontPadding = false
                                    )
                                ),
                                color = Black_60_Transfer,
                                fontSize = 13.sp,
                                modifier = Modifier.width(200.dp)
                            )

//                            LazyColumn(
//                                modifier = Modifier
//                                    .padding(start = 15.dp)
//                                    .heightIn(0.dp, 100.dp)
//                            ) {
////
//                                items(viewModel.ProtectionHope) { items ->
//                                    ProtectionConditionItems(items.content, true)
//                                }
//
//                            }

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
                                fontFamily = notosans_bold,
                                style = TextStyle(
                                    platformStyle = PlatformTextStyle(
                                        includeFontPadding = false
                                    )
                                ),
                                color = Black_60_Transfer,
                                fontSize = 13.sp,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "❌ 집을 비우는 시간이 너무 기신 분",
                                fontFamily = notosans_regular,
                                style = TextStyle(
                                    platformStyle = PlatformTextStyle(
                                        includeFontPadding = false
                                    )
                                ),
                                color = Black_60_Transfer,
                                fontSize = 13.sp,
                                modifier = Modifier.width(200.dp)
                            )
//                            LazyColumn(
//                                modifier = Modifier
//                                    .padding(start = 15.dp)
//                                    .heightIn(0.dp, 100.dp)
//                            ) {
////
//                                items(viewModel.ProtectionNo) { items ->
//                                    ProtectionConditionItems(items.content, false)
//                                }
//
//                            }

                        }

                    }//Column


                }//Column

            }

            if (viewModel.photoUrl_detail.isNotEmpty()) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, start = 21.dp, bottom = 20.dp),
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.img_record),
                        contentDescription = null,
                        modifier = Modifier
                            .height(23.dp)
                            .width(23.dp),
                        contentScale = ContentScale.Crop
                    )
                    
                    SpacerWidth(dp = 12.dp)


                    Text(
                        text = "사진첩",
                        fontSize = 16.sp,
                        color = Color.Black,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontFamily = notosans_bold

                    )
                }


                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 7.dp, start = 20.dp, end = 20.dp),
                    color = Color.Black
                )



                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier
                        .heightIn(min = 0.dp, max = 200.dp)
                        .padding(horizontal = 21.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(viewModel.photoUrl_detail) { item ->
                        Image(
                            painter = rememberImagePainter(data = item.photoUrl),
                            contentDescription = null,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .height(70.dp)
                                .width(70.dp),
                            contentScale = ContentScale.Crop
                        )

                    }
                }

            }else{
                SpacerHeight(dp = 20.dp)
            }


        }//Column

        if (viewModel.isjudge.value == 0) {
            Image(
                painter = painterResource(id = R.drawable.img_chat_contact),
                contentDescription = null,

                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 40.dp, end = 15.dp)
                    .width(55.dp)
                    .height(55.dp)
                    .clickable {
//                        viewModel.onConfirmClick()
                    }
            )
        } else if (viewModel.isjudge.value == 1) {
            Image(
                painter = painterResource(id = R.drawable.img_shelter_icon_aplication),
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
        }


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
                },
                ischatroom = false
            )
        }

        if (viewModel.isAdoptionApplicationDialogShown) {
            AdoptionCompletedDialog(
                onDismiss = { viewModel.onAdoptionDialogDismissDialog() },
                onConfirm = { Log.d(TAG, "AnimalInfoDetailScreen: wow") })
        }

    }//Box

}

@Composable
fun ProtectionConditionItems(
    text: String,
    yesorno: Boolean,
) {
    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
        Text(text = if (yesorno) "✅ " else "❌ ")

        Text(
            text = text,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            fontSize = 13.sp,
            color = Black_60_Transfer,
            maxLines = 1,
        )
    }


}





