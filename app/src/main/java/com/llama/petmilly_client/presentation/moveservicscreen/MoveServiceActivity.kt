package com.llama.petmilly_client.presentation.moveservicscreen

import android.app.Activity
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
import androidx.compose.ui.layout.ContentScale
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
import com.llama.petmilly_client.presentation.moveservicscreen.moveservicedetail.MoveServiceDetailActivity
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

            NavHost(navController = navController, startDestination = Common.MOVESERVICE_LIST_SCREEN) {
                composable(Common.MOVESERVICE_LIST_SCREEN) {
                    MoveServiceListScreen(viewModel = viewModel, navController = navController,this@MoveServiceActivity)

                }

                composable(Common.MOVESERVICE_Detail_SCREEN) {
                    MoveServiceDetailScreen(viewModel = viewModel, navController = navController )
                }


            }

        }
    }
}

@Composable
fun MoveServiceListScreen(viewModel: MoveServiceViewModel, navController: NavController,activity:Activity) {
    val context = LocalContext.current
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)

        ) {

            TitleBar(title = "???????????? ?????????", ismenu = false, clickBack = { activity.finish() }) {

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
                        "?????? ????????? -> ????????? ?????????",
                        "??????/ 2???/ 10kg",
                        "2/28(???) - 15???",
                        "5?????? ???"
                    ),
                    Moveservicemodel(
                        "?????? ????????? -> ????????? ?????????",
                        "??????/ 2???/ 10kg",
                        "2/28(???) - 15???",
                        "6?????? ???"
                    ),
                    Moveservicemodel(
                        "?????? ????????? -> ????????? ?????????",
                        "??????/ 2???/ 10kg",
                        "2/28(???) - 15???",
                        "7?????? ???"
                    ),
                    Moveservicemodel(
                        "?????? ????????? -> ????????? ?????????",
                        "??????/ 2???/ 10kg",
                        "2/28(???) - 15???",
                        "8?????? ???"
                    )

                )


                items(moveservicemodel) { item ->
                    Moveserviceitems(
                        movelocation = item.movelocation,
                        animalinfo = item.animalinfo,
                        moveday = item.moveday,
                        time = item.time
                    ) {
                        navController.navigate(Common.MOVESERVICE_Detail_SCREEN)
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

@Composable
fun MoveServiceDetailScreen(viewModel: MoveServiceViewModel, navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column {

            TitleBar(title = "???????????? ?????????", ismenu = false, clickBack = { navController.popBackStack() }) {

            }

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
                text = "??????????????? ????????? ????????? ???????????????.",
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
                        text = "\uD83D\uDE97 ????????????",
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
                        text = "?????? ????????? ?????????",
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
                        text = "\uD83D\uDE97 ????????????",
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
                        text = "??????????????? ????????? ?????????",
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
                        text = "??? ????????????",
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
                        text = "1/18 ????????? -  17???",
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
                    text = "?????????",
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
                        text = "?????? / ??????",
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
                        text = "??????/??????",
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
                        text = "??????",
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
                        text = "5??????",
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
                        text = "?????????",
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
                        text = "?????????",
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
                        text = "???????????? ????????? ????????? ??????????????? ????????????. ??????????????? ?????? ??????????????? ????????? ?????? ??? ???????????????.",
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