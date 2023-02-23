package com.llama.petmilly_client.presentation.moveservicscreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.certificationscreen.CertificationActivity
import com.llama.petmilly_client.presentation.dialog.AdoptionApplicationDialog
import com.llama.petmilly_client.presentation.dialog.AdoptionCompletedDialog
import com.llama.petmilly_client.presentation.findanimalscreen.FindAnimalDetailImage
import com.llama.petmilly_client.presentation.findanimalscreen.ImageTestData
import com.llama.petmilly_client.presentation.homescreen.items.BorderCategoryItems
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common

class MoveServiceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: MoveServiceViewModel = hiltViewModel()
            TitleBar(title = "이동봉사 찾아요", ismenu = false, clickBack = { finish() }) {

            }

            NavHost(navController = navController, startDestination = "hi") {
                composable("hi") {
                    MoveServiceListScreen(viewModel = viewModel, navController = navController)

                }

                composable("wow") {

                }


            }

        }
    }
}

@Composable
fun MoveServiceListScreen(viewModel: MoveServiceViewModel, navController: NavController) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                viewModel.setcategory()

                items(viewModel.categorytest) { categorylist ->
                    Row {
                        if (viewModel.categorytest.indexOf(categorylist) == 0) {
                            Spacer(modifier = Modifier.padding(start = 15.dp))
                            BorderCategoryItems(title = categorylist.title) {

                            }


                        } else {
                            BorderCategoryItems(title = categorylist.title) {

                            }
                        }

                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }

            }//LazyRow

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 7.dp)
            ) {

                val moveservicemodel = listOf(
                    Moveservicemodel(
                        "경기 화성시 -> 강서구 화곡동",
                        "라마/ 2살/ 10kg",
                        "2/28(월) - 15시",
                        "5시간 전"
                    ),
                    Moveservicemodel(
                        "경기 화성시 -> 강서구 화곡동",
                        "라마/ 2살/ 10kg",
                        "2/28(월) - 15시",
                        "6시간 전"
                    ),
                    Moveservicemodel(
                        "경기 화성시 -> 강서구 화곡동",
                        "라마/ 2살/ 10kg",
                        "2/28(월) - 15시",
                        "7시간 전"
                    ),
                    Moveservicemodel(
                        "경기 화성시 -> 강서구 화곡동",
                        "라마/ 2살/ 10kg",
                        "2/28(월) - 15시",
                        "8시간 전"
                    )

                )


                items(moveservicemodel) { item ->
                    Moveserviceitems(
                        movelocation = item.movelocation,
                        animalinfo = item.animalinfo,
                        moveday = item.moveday,
                        time = item.time
                    ) {
                        navController.navigate("wow")
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                }


            }

        }//Column
    }
}

@Composable
fun MoveServiceDetailScreen(viewModel: MoveServiceViewModel, navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            LazyRow(modifier = Modifier.padding(horizontal = 10.dp)) {
                val imageTestData = listOf(
                    ImageTestData(R.drawable.img_test_puppy),
                    ImageTestData(R.drawable.img_test_puppy),
                    ImageTestData(R.drawable.img_test_puppy)
                )
                items(imageTestData) { item ->
                    FindAnimalDetailImage(image = item.image)
                    Spacer(modifier = Modifier.width(9.dp))

                }
            }

            Text(
                text = "이동봉사로 새로운 행복을 전해주세요.",
                modifier = Modifier
                    .padding(top = 20.dp, start = 27.dp)
                    .background(color = Color(0xFFFFF2DA)),
                fontSize = 16.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black,
                textAlign = TextAlign.Center
            )


            Spacer(modifier = Modifier.height(10.dp))

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp), color = Color.Black
            )


            Column {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .background(color = Pink_5_Transfer)
                        .padding(vertical = 10.dp)
                ) {
                    Text(
                        text = "\uD83D\uDE97 출발지역",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "경기 화성시 화성동",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                    ,
                    color = Black_30_Transfer
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .background(color = Pink_5_Transfer)
                        .padding(vertical = 10.dp)
                ) {
                    Text(
                        text = "\uD83D\uDE97 도착지역",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "서울특별시 강서구 화곡동",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }



                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp), color = Color.Black
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .background(color = Pink_5_Transfer)
                        .padding(vertical = 10.dp)
                ) {
                    Text(
                        text = "⏰ 이동날짜",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "1/18 수요일 -  17시",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp), color = Color.Black
                )

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "프로필",
                    modifier = Modifier
                        .padding(top = 20.dp, start = 27.dp)
                        .background(color = Color(0xFFFFF2DA)),
                    fontSize = 16.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(6.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp), color = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 27.dp)
                ) {
                    Text(
                        text = "이름 / 성별",
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
                        text = "망고/암컷",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(1.dp)
                        .padding(horizontal = 20.dp), color = Black_30_Transfer
                )

                Spacer(modifier = Modifier.height(10.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 27.dp)
                ) {
                    Text(
                        text = "나이",
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
                        text = "5개월",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp), color = Black_30_Transfer
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 27.dp)
                ) {
                    Text(
                        text = "몸무게",
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
                        text = "3kg",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }


                Spacer(modifier = Modifier.height(10.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp), color = Black_30_Transfer
                )

                Spacer(modifier = Modifier.height(10.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 27.dp)
                ) {
                    Text(
                        text = "한마디",
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
                        text = "파보치료 끝나고 니키네 임보집으로 가야해요. 병원에서도 빨리 퇴원하라고 하는데 이동 좀 도와주세요.",
                        color = Black_60_Transfer,
                        fontSize = 13.sp,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }



            }//Column

        }

        Image(
            painter = painterResource(id = R.drawable.img_chat_contact),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 40.dp, end = 15.dp)
                .width(55.dp)
                .height(55.dp)
                .clickable {

                }
        )

    }


}

data class Moveservicemodel(
    val movelocation: String,
    val animalinfo: String,
    val moveday: String,
    val time: String,
)

@Preview
@Composable
fun SERVICETEST() {
    val navController = rememberNavController()
    val viewModel: MoveServiceViewModel = hiltViewModel()
    MoveServiceDetailScreen(viewModel, navController)
}