package com.llama.petmilly_client.presentation.moveservicscreen

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.dialog.MoveServiceDetailDialog
import com.llama.petmilly_client.presentation.findanimalscreen.FindAnimalDetailImage
import com.llama.petmilly_client.presentation.findanimalscreen.ImageTestData
import com.llama.petmilly_client.presentation.homescreen.items.BorderCategoryItems
import com.llama.petmilly_client.presentation.moveservicscreen.moveservicedetail.MoveServiceDetailActivity
import com.llama.petmilly_client.presentation.shelterscreen.ShelterViewModel
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.CommonObject.convertAddress
import com.llama.petmilly_client.utils.CommonObject.convertmoveservicetime
import com.llama.petmilly_client.utils.SpacerHeight
import com.llama.petmilly_client.utils.SpacerWidth
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.ID
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@AndroidEntryPoint
class MoveServiceActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: MoveServiceViewModel = hiltViewModel()

            NavHost(
                navController = navController,
                startDestination = Common.MOVESERVICE_LIST_SCREEN
            ) {
                composable(Common.MOVESERVICE_LIST_SCREEN) {
                    MoveServiceListScreen(
                        viewModel = viewModel,
                        navController = navController,
                        this@MoveServiceActivity
                    )

                }

                composable("${Common.MOVESERVICE_Detail_SCREEN}/{id}") {
                    val id = it.arguments?.getString(ID).toString()
                    MoveServiceDetailScreen(
                        viewModel = viewModel,
                        navController = navController,
                        id
                    )
                }


            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MoveServiceListScreen(
    viewModel: MoveServiceViewModel,
    navController: NavController,
    activity: Activity,
) {
    val context = LocalContext.current
    Box {

//        LaunchedEffect(context) {
//        }
        viewModel.getmoveservicepost()


        Log.d(TAG, "MoveServiceListScreen: 하윙")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)

        ) {

            TitleBar(title = "이동봉사 찾아요", ismenu = false, clickBack = { activity.finish() }) {

            }

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
//
                items(MainApplication.categorylist) { categorylist ->
                    Row {
                        if (MainApplication.categorylist.indexOf(categorylist) == 0) {
                            Spacer(modifier = Modifier.padding(start = 15.dp))
                            BorderCategoryItems(title = categorylist) { title, check ->
                                setmovservicepost(
                                    viewModel = viewModel,
                                    categorytitle = title,
                                    check = check

                                )
                            }


                        } else {
                            BorderCategoryItems(title = categorylist) { title, check ->
                                setmovservicepost(
                                    viewModel = viewModel,
                                    categorytitle = title,
                                    check = check
                                )

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


                items(viewModel.postDataList) { item ->
                    val startAddress = convertAddress(item.startAddress)
                    val endAddress = convertAddress(item.endAddress)
                    Moveserviceitems(
                        image = item.thumbnail.photoUrl,
                        startAddress = startAddress,
                        endAddress = endAddress,
                        animalinfo = "${item.name} / ${item.age}살 / ${item.weight}kg",
                        moveday = item.hopeDate!!,
                        time = item.name
                    ) {
                        navController.navigate(Common.MOVESERVICE_Detail_SCREEN + "/${item.id}")
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                }


            }

        }//Column

        Image(
            painter = painterResource(id = R.drawable.img_write),
            contentDescription = null,

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 40.dp, end = 15.dp)
                .width(50.dp)
                .height(50.dp)
                .clickable {
                    val intent = Intent(context, MoveServiceDetailActivity::class.java)
                    context.startActivity(intent)
                },
            contentScale = ContentScale.Crop
        )
    }//Box
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MoveServiceDetailScreen(
    viewModel: MoveServiceViewModel,
    navController: NavController,
    id: String,
) {
    Log.d(TAG, "MoveServiceDetailScreen: $id")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        val context = LocalContext.current
        var ismenu by remember {
            mutableStateOf(false)
        }
        LaunchedEffect(context) {
            viewModel.getmoveservicepostdetail(id.toInt())


        }



        Column {

            TitleBar(
                title = "이동봉사 찾아요",
                ismenu = true,
                clickBack = { navController.popBackStack() },
                clickMenu = {
                    viewModel.onMenuDialog()
                }
            )

            if (viewModel.ismenudialog) {
                MoveServiceDetailDialog(
                    onModifiy = {},
                    onDelete = {},
                    onUp = {},
                    onComplete = {},
                    onDismiss = {
                        viewModel.onDissmissMenuDialog()
                    })
            }


            LazyRow(modifier = Modifier.padding(horizontal = 10.dp)) {
                val imageTestData = listOf(
                    ImageTestData(R.drawable.img_test_dog_1),
                    ImageTestData(R.drawable.img_test_dog_2),
                    ImageTestData(R.drawable.img_test_dog_3)
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
                        modifier = Modifier
                            .width(80.dp)
                            .padding(start = 10.dp)
                    )

                    Text(
                        text = viewModel.startAddress_detail.value,
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
                        .padding(horizontal = 20.dp),
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
                        modifier = Modifier
                            .width(80.dp)
                            .padding(start = 10.dp)
                    )

                    Text(
                        text = viewModel.endAddress_detail.value,
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
                        modifier = Modifier
                            .width(80.dp)
                            .padding(start = 10.dp)
                    )

                    Text(
                        text = if (viewModel.moveday_detail.value != "") convertmoveservicetime(
                            viewModel.moveday_detail.value
                        ) else "",
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
                        .padding(top = 20.dp, start = 27.dp),
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
                        text = "${viewModel.name_detail.value} / ${viewModel.gender_detail.value}",
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
                        text = viewModel.age_detail.value,
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
                        text = viewModel.weight_detail.value,
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
                        text = viewModel.etc_detail.value,
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


private fun setmovservicepost(
    viewModel: MoveServiceViewModel,
    categorytitle: String,
    check: Boolean,
) {


    if (check) {
        viewModel.addcategorylist(categorytitle)
    } else {
        viewModel.deletecategorylist(categorytitle)
    }

    Log.d(TAG, "setpost: ${viewModel.categorylist}")
    viewModel.dog.value = viewModel.categorylist.contains("강아지")
    viewModel.cat.value = viewModel.categorylist.contains("고양이")
    viewModel.isComplete.value = !viewModel.categorylist.contains("petmily ❤️")

    if (viewModel.categorylist.isEmpty()) {
        viewModel.cat.value = null
        viewModel.dog.value = null
        viewModel.isComplete.value = null
        viewModel.weight.value = null
    }

//    viewModel.weight.clear()
//    //weight는 하나만 선택되게 해야함
//    if(viewModel.categorylist.contains("~7kg") && !viewModel.weight.contains("small")){
//        viewModel.weight.value = "small"
//    }
//
//    if(viewModel.categorylist.contains("7~15kg")  && !viewModel.weight.contains("middle")){
//        viewModel.weight.add("middle")
//    }
//
//    if(viewModel.categorylist.contains("15kg~") && !viewModel.weight.contains("big")){
//        viewModel.weight.add("big")
//    }


    viewModel.getmoveservicepost()
}

