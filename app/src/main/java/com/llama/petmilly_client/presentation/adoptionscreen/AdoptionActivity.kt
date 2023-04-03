package com.llama.petmilly_client.presentation.adoptionscreen

import android.app.Activity
import android.os.Bundle
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.llama.petmilly_client.presentation.findanimalscreen.FindAnimalDetailImage
import com.llama.petmilly_client.presentation.findanimalscreen.ImageTestData
import com.llama.petmilly_client.presentation.homescreen.items.BorderCategoryItems
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common

class AdoptionActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: AdoptionViewModel = hiltViewModel()

            NavHost(navController = navController, startDestination = Common.ADOPTION_LIST_SCREEN) {
                composable(Common.ADOPTION_LIST_SCREEN) {
                    AdoptionListScreen(
                        viewModel = viewModel,
                        navController = navController,
                        activity = this@AdoptionActivity
                    )

                }

                composable(Common.ADOPTION_Detail_SCREEN) {
                    AdoptionDetailScreen(navController = navController, viewModel = viewModel)
                }

            }

        }
    }
}

@Composable
fun AdoptionListScreen(
    navController: NavController,
    viewModel: AdoptionViewModel,
    activity: Activity,
) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)

        ) {
            TitleBar(title = "입양공고", ismenu = false, clickBack = { activity.finish() }) {

            }

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                viewModel.setcategory()

                items(viewModel.categorytest) { categorylist ->
                    Row {
                        if (viewModel.categorytest.indexOf(categorylist) == 0) {
                            Spacer(modifier = Modifier.padding(start = 15.dp))
                            BorderCategoryItems(title = categorylist.title) { title, check ->

                            }


                        } else {
                            BorderCategoryItems(title = categorylist.title) { title, check ->

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

                val adoptionModel = listOf(
                    AdoptionModel(
                        image = R.drawable.img_test_puppy,
                        "감자",
                        "믹스 / 2개월/ 1kg",
                        "1차완료/ 중성화0",
                        "1시간 전"
                    ),
                    AdoptionModel(
                        image = R.drawable.img_testcat_2,
                        "망구",
                        "고양이 / 2살/ 10kg",
                        "1차완료/ 중성화X",
                        "1일 전"
                    ),
                    AdoptionModel(
                        image = R.drawable.img_test_dog4,
                        "샛별이",
                        "시바견 / 5살/ 12kg",
                        "1차완료/ 중성화0",
                        "5일 전"
                    ),

                    )


                items(adoptionModel) { item ->
                    AdoptionItems(
                        image = item.image,
                        name = item.name,
                        animalinfo = item.animalinfo,
                        isvaccination = item.isvaccination,
                        time = item.time
                    ) {
                        navController.navigate(Common.ADOPTION_Detail_SCREEN)
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                }


            }

        }//Column
    }
}

@Composable
fun AdoptionDetailScreen(navController: NavController, viewModel: AdoptionViewModel) {
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
                .background(Color.White)
        ) {

            TitleBar(
                title = "입양공고",
                ismenu = false,
                clickBack = { navController.popBackStack() }) {

            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 27.dp)
            ) {
                Box() {

                    Image(
                        painter = painterResource(id = R.drawable.img_test_puppy),
                        contentDescription = null,
                        modifier = Modifier
                            .height(130.dp)
                            .width(130.dp)
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
                            .padding(start = 8.dp, top = 8.dp)
                    )
                }


                Column(
                    modifier = Modifier
                        .height(130.dp)
                        .padding(start = 15.dp),
                    verticalArrangement = Arrangement.Center,
                ) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                    ) {
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
                            text = "감자",
                            fontSize = 16.sp,
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black
                        )

                        Text(
                            text = "수컷",
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
                        text = "믹스 / 1kg/ 2개월추정",
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Black_60_Transfer,
                        modifier = Modifier.background(color = Background_FDFCE1),
                        fontSize = 13.sp

                    )
                    Text(
                        text = "현재위치지역 매탄동",
                        fontFamily = notosans_bold,
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
                text = "프로필", modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 27.dp),
                fontSize = 16.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp), color = Color.Black
            )

            Spacer(modifier = Modifier.height(6.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 27.dp)
            ) {
                Text(
                    text = "중성화/접종 ",
                    fontSize = 13.sp,
                    color = Black_60_Transfer,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "중성화O/1차 접종 완료 ",
                    fontSize = 13.sp,
                    color = Black_60_Transfer,
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
                    .width(0.2.dp)
                    .padding(horizontal = 20.dp), color = Black_30_Transfer
            )

            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 27.dp)
            ) {
                Text(
                    text = "성격",
                    fontSize = 13.sp,
                    color = Black_60_Transfer,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "소심하고 순해요. 아직 아가라 알 순 없지만 기를 살려 줄 임보분이면 좋겠습니다.",
                    color = Black_60_Transfer,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontSize = 13.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(0.2.dp)
                    .padding(horizontal = 20.dp), color = Black_30_Transfer
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 27.dp)
            ) {
                Text(
                    text = "개인기",
                    color = Black_60_Transfer,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontSize = 13.sp,
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "앉아 까지 가능 합니다.",
                    color = Black_60_Transfer,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontSize = 13.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(0.2.dp)
                    .padding(horizontal = 20.dp), color = Black_30_Transfer
            )

            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 27.dp)
            ) {
                Text(
                    text = "특징",
                    color = Black_60_Transfer,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontSize = 13.sp,
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "성견되면 15kg대까지 추정되어요. 왕크니까 왕귀여워요!",
                    color = Black_60_Transfer,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontSize = 13.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "입양정보", modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 27.dp),
                fontSize = 16.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(6.dp))

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .background(color = Pink_5_Transfer)
            ) {

                Divider(
                    modifier = Modifier
                        .fillMaxWidth(), color = Color.Black
                )

                Spacer(modifier = Modifier.height(6.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 7.dp)
                ) {
                    Text(
                        text = "픽업방법 ",
                        fontSize = 13.sp,
                        color = Black_60_Transfer,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "직접픽업",
                        fontSize = 13.sp,
                        color = Black_60_Transfer,
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
                        .width(0.2.dp), color = Black_30_Transfer
                )

                Spacer(modifier = Modifier.height(10.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 7.dp)
                ) {
                    Text(
                        text = "희망지역",
                        fontSize = 13.sp,
                        color = Black_60_Transfer,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "서울, 경기",
                        color = Black_60_Transfer,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(0.2.dp), color = Black_30_Transfer
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 7.dp)
                ) {
                    Text(
                        text = "입양조건",
                        color = Black_60_Transfer,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 13.sp,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "✅ 서울 성북동 연계병원에서 픽업가능한 분(#2월2일 #2월3일)\n" +
                                "✅ 서울 성북동의 연계병 2주에 1번 통원 가능능한 분 체크무늬는추가추가해서하도록하고 작성할때 플러스버튼으로 적용용",
                        color = Black_60_Transfer,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(0.2.dp), color = Black_30_Transfer
                )

                Spacer(modifier = Modifier.height(10.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 7.dp)
                ) {
                    Text(
                        text = "이런분을 희망해요",
                        color = Black_60_Transfer,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 13.sp,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "✅  응급 시 연계병원으로 이동 가능한 분",
                        color = Black_60_Transfer,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(0.2.dp), color = Black_30_Transfer
                )

                Spacer(modifier = Modifier.height(10.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 7.dp, end = 7.dp, bottom = 10.dp)
                ) {
                    Text(
                        text = "이런분은 안돼요",
                        color = Black_60_Transfer,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 13.sp,
                        modifier = Modifier.width(80.dp)
                    )

                    Text(
                        text = "❌ 집을 비우는 시간이 너무 기신 분",
                        color = Black_60_Transfer,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

            }//Column


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

                }
        )


    }//Box

}

data class AdoptionModel(
    val image: Int,
    val name: String,
    val animalinfo: String,
    val isvaccination: String,
    val time: String,
)
