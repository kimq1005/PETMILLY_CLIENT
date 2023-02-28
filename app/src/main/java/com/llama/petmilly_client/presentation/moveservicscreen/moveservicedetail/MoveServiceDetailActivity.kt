package com.llama.petmilly_client.presentation.moveservicscreen.moveservicedetail

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common

class MoveServiceDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val viewModel: MoveServiceDetailViewModel = hiltViewModel()

            NavHost(
                navController = navController,
                startDestination = Common.MOVESERVICEDETAILSCREEN_1_INPUT
            ) {
                composable(route = Common.MOVESERVICEDETAILSCREEN_1_INPUT) {
                    MoveServiceDetailScreen_1_Input(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@MoveServiceDetailActivity
                    )
                }
                
                composable(route = Common.MOVESERVICEDETAILSCREEN_2_INPUT){
                    MoveServiceDetailScreen_2_Input(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@MoveServiceDetailActivity
                    )
                }
            }
        }
    }
}

@Composable
fun MoveServiceDetailScreen_1_Input(
    navController: NavController,
    viewModel: MoveServiceDetailViewModel,
    activity: Activity,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ShelterDetailTitleBar(
            title = "이동봉사 찾아요",
            ismenu = false,
            clickBack = { activity.finish() }) {
            activity.finish()
        }

        MoveServiceDetailSuvTitle("이동봉사 정보를\n입력해주세요.")

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "이동봉사 정보",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            TextField(
                value = viewModel.movestartplace.value,
                onValueChange = { viewModel.movestartplace.value = it },
                modifier = Modifier
                    .weight(8.5f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = if (viewModel.movestartplace.value == "") TextField_BackgroudColor else Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,

                    ),
                placeholder = { Text(text = "이동봉사 출발지") }
            )


            Image(
                painter = painterResource(id = R.drawable.img_comment_location),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .height(45.dp)
                    .width(45.dp),
                contentScale = ContentScale.Crop
            )
        }//Row

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            TextField(
                value = viewModel.movearriveplace.value,
                onValueChange = { viewModel.movearriveplace.value = it },
                modifier = Modifier
                    .weight(8.5f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = if (viewModel.movearriveplace.value == "") TextField_BackgroudColor else Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,

                    ),
                placeholder = { Text(text = "이동봉사 도착지") }
            )


            Image(
                painter = painterResource(id = R.drawable.img_comment_location),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .height(45.dp)
                    .width(45.dp),
                contentScale = ContentScale.Crop
            )
        }//Row

        Spacer(modifier = Modifier.weight(1f))

        val ischeck = viewModel.movestartplace.value != "" && viewModel.movearriveplace.value != ""

        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                .height(55.dp),
            backgroundcolor = if (ischeck) Color.Black else Button_NoneClicked

        ) {
            if (ischeck) {
                        navController.navigate(Common.MOVESERVICEDETAILSCREEN_2_INPUT)
            } else {

            }
        }
    }

}

@Composable
fun MoveServiceDetailScreen_2_Input(
    navController: NavController,
    viewModel: MoveServiceDetailViewModel,
    activity:Activity
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        ShelterDetailTitleBar(
            title = "이동봉사 찾아요",
            ismenu = false,
            clickBack = { navController.popBackStack() }) {
                activity.finish()
        }

        MoveServiceDetailSuvTitle("이동봉사 정보를\n입력해주세요.")

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "신청서 접수기간(선택)",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = viewModel.moveserviceday.value,
                onValueChange = { viewModel.moveserviceday.value = it },
                modifier = Modifier
                    .weight(8.5f)
                    .padding(horizontal = 10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,
                ),
                textStyle = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),

                placeholder = {
                    Text(
                        text = "23년 02월 04일",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.LightGray
                    )
                }
            )

            Image(
                painter = painterResource(id = R.drawable.img_shelter_plus),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .height(45.dp)
                    .width(45.dp),
                contentScale = ContentScale.Crop
            )
        }//Row

        Spacer(modifier = Modifier.height(70.dp))

        Text(
            text = "특이사항 (선택)",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = viewModel.movesiginificant.value,
            onValueChange = { viewModel.movesiginificant.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .height(80.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = if (viewModel.movesiginificant.value == "") TextField_BackgroudColor else Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = {
                Text(
                    text = "특이사항 및 어필할 수 있는 한마디를 입력해주세요."
                )
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        val ischeck = viewModel.moveserviceday.value != "" && viewModel.movesiginificant.value != ""


        ButtonScreen(
            title = "완료",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                .height(55.dp),
            backgroundcolor = if (ischeck) Color.Black else Button_NoneClicked

        ) {
            if (ischeck) {
                //이동봉사 찾아요 완료
                activity.finish()
                
            } else {

            }
        }


    }
}


@Composable
fun MoveServiceDetailSuvTitle(text: String) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_jong),
                contentDescription = null,
                modifier = Modifier
                    .width(44.dp)
                    .height(44.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = stringResource(id = R.string.moveservicesuvtitle),
                fontSize = 13.sp,
                color = Color.Black,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = text,
            modifier = Modifier.padding(start = 40.dp),
            fontSize = 30.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black
        )

    }

}
