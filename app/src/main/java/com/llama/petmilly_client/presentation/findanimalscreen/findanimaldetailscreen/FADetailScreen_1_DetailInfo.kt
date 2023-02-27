package com.llama.petmilly_client.presentation.findanimalscreen.findanimaldetailscreen

import android.app.Activity
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
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.moveservicscreen.moveservicedetail.MoveServiceDetailSuvTitle
import com.llama.petmilly_client.presentation.moveservicscreen.moveservicedetail.MoveServiceDetailViewModel
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun FADetailScreen_1_DetailInfo(navController: NavController, viewModel: FADetailViewModel,activity:Activity) {

    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {

        ShelterDetailTitleBar(
            title = "우리아이 찾아요",
            ismenu = false,
            clickBack = { navController.popBackStack() }
        ) {
            activity.finish()
        }

        FADetailSuvTitle("실종 당시 정보를\n상세히 입력해주세요.")

        Spacer(modifier = Modifier.height(36.dp))


        Text(
            text = "실종일시",
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

     
        TextField(
            value = viewModel.missingday.value,
            onValueChange = { viewModel.missingday.value = it },
            modifier = Modifier
                .fillMaxWidth()
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
                    text = "23년 02월 04일 10시",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray
                )
            }
        )


        Spacer(modifier = Modifier.height(70.dp))

        Text(
            text = "실종지역",
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
        
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 26.dp)) {

            TextField(
                value = viewModel.missinglocation.value,
                onValueChange = { viewModel.missinglocation.value = it },
                modifier = Modifier
                    .weight(8.5f)
                    .height(80.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = if (viewModel.missinglocation.value == "") TextField_BackgroudColor else Color.White,
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

        }



        Spacer(modifier = Modifier.weight(1f))

        val ischeck = viewModel.missingday.value != "" && viewModel.missingday.value != ""


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
//                        navController.navigate(Common.SIGNUPSCREEN_4_3_CALLYOUTANIMAL_First)
            } else {

            }
        }

    }


}

@Composable
fun FADetailSuvTitle(text: String) {
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
                text = stringResource(id = R.string.fasubtitle),
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

@Preview
@Composable
fun FAPReview(){
    val navController = rememberNavController()
    val viewModel:FADetailViewModel = hiltViewModel()
    FADetailScreen_3_Comment_IsOpen(navController = navController, viewModel = viewModel)
}
