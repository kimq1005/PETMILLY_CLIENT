package com.llama.petmilly_client.presentation.shelterscreen

import android.content.Intent
import android.opengl.Visibility
import android.util.Log
import android.view.View
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
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
import com.llama.petmilly_client.presentation.findanimalscreen.ImageTestData
import com.llama.petmilly_client.presentation.homescreen.HomeActivity
import com.llama.petmilly_client.presentation.loginscreen.CustomDialog
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.*
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
@ExperimentalFoundationApi
fun AnimalInfoDetailScreen(
    navController: NavController,
    viewModel: ShelterViewModel = viewModel(),
) {

    val context = LocalContext.current
    viewModel.setanimalinfovalue()
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
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
                        painter = painterResource(id = R.drawable.img_test_puppy),
                        contentDescription = null,
                        modifier = Modifier
                            .height(130.dp)
                            .width(130.dp)
                            .background(color = Color.Blue)
                            .align(Alignment.CenterStart),
                        contentScale = ContentScale.Crop
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
                        Text(
                            text = "\uD83D\uDC49 ????????? ?????? ????????????",
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
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = if (viewModel.testBoolean.value) viewModel.animalspecies.value else "${viewModel.animalspecies.value}(??????) ",
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
                            text = "??????",
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
                        text = "${viewModel.animalspecies.value} / ${viewModel.animalweight.value}kg/ ${viewModel.animalage.value} ??????",
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
                    Text(
                        text = "?????????????????? ???????????????",
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Black_60_Transfer,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                }
            }//Row


            Text(
                text = "?????????", modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 30.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
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
                        text = "?????????/?????? ",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "?????????O/1??? ?????? ?????? ",
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
                        text = "??????",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "???????????? ?????????. ?????? ????????? ??? ??? ????????? ?????? ?????? ??? ??????????????? ???????????????.",
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
                        text = "?????????",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "?????? ?????? ?????? ?????????.",
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
                        text = "??????",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "???????????? 15kg????????? ???????????????. ???????????? ???????????? ????????????/?????? ?????? ????????? ???????????? ?????????.",
                        color = Color.DarkGray,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

            }//Column


            if (viewModel.isjudge.value == 1) {

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
                            text = "????????? ???????????? : 23.01.01 ~ 23.01.07",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF3050F6),
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        Text(
                            text = "????????? ???????????? : 23.08.01 ~ 23.01.10",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 5.dp)

                        )
                        Text(
                            text = "* ??????????????? ?????? ??? ?????? ??? ??? ?????? ??? ????????? ?????? ??????????????????.",
                            fontWeight = FontWeight.Bold,
                            color = Color.LightGray,
                            fontSize = 11.sp
                        )

                    }//Column
                }//Row
            }


            if (viewModel.isjudge.value != 2) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "?????? ??????", modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 10.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    SpacerHeight(dp = 6.dp)

                    Divider(color = Color.Black)

                    Column(modifier = Modifier.background(color = Pink_5_Transfer)) {
                        SpacerHeight(dp = 8.dp)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, bottom = 10.dp)
                        ) {
                            Text(
                                text = "???????????? ",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "???????????? ",
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
                                text = "????????????",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "??????/ ??????",
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
                                text = "????????????",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "2???",
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
                                text = "????????????",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "??? ?????? ????????? ?????????????????? ??????????????? ???(#2???2??? #2???3???)\n" +
                                        "??? ?????? ???????????? ????????? 2?????? 1??? ?????? ???????????? ??? ???????????????????????????????????????????????? ???????????? ????????????????????? ?????????",
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
                                text = "???????????? ????????????",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "???  ?????? ??? ?????????????????? ?????? ????????? ???",
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
                                text = "???????????? ?????????",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.width(80.dp)
                            )

                            Text(
                                text = "??? ?????? ????????? ????????? ?????? ?????? ???",
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        }

                    }//Column


                }//Column

            }

            Text(
                text = "?????????", modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 21.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 7.dp, start = 20.dp, end = 20.dp),
                color = Color.Black
            )

            val imageTestData = listOf(
                ImageTestData(R.drawable.img_test_puppy),
                ImageTestData(R.drawable.img_test_puppy),
                ImageTestData(R.drawable.img_test_puppy),
                ImageTestData(R.drawable.img_test_puppy),
                ImageTestData(R.drawable.img_test_puppy),
                ImageTestData(R.drawable.img_test_puppy)
            )




            LazyColumn(
                modifier = Modifier
                    .height(160.dp)
                    .padding(horizontal = 21.dp)
            ) {
                items(imageTestData.chunked(4)) { items ->
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,

                        ) {
                        items.forEach { item ->
                            PicktureItems(
                                image = item.image,
                                modifier = Modifier
                                    .height(70.dp)
                                    .width(70.dp)
                            )
//                            SpacerWidth(dp = 11.dp)
                        }

                    }

                    SpacerHeight(dp = 7.dp)

                }
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
                    //?????? ????????? ???????????????
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





