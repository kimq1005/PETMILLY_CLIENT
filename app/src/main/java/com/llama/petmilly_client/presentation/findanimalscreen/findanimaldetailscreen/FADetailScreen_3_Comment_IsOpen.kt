package com.llama.petmilly_client.presentation.findanimalscreen.findanimaldetailscreen

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen.ShelterBtn
import com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen.ShelterDetailViewModel
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.*

@Composable
fun FADetailScreen_3_Comment_IsOpen(navController: NavController, viewModel: FADetailViewModel, activity:Activity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ShelterDetailTitleBar(
            title = "우리아이 찾아요",
            ismenu = false,
            clickBack = { navController.popBackStack() }
        ) {
            activity.finish()
        }

        FADetailSuvTitle("제보(댓글) 공개 여부를\n설정해주세요.")

        Spacer(modifier = Modifier.height(36.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 35.dp, end = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.isopencomment.value) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "모두가 찾을 수 있도록 공개할게요.",
                textcolor = if (viewModel.isopencomment.value) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.isopencomment.value) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (viewModel.isopencomment.value) notosans_bold else notosans_regular

            ) {
                viewModel.isopencomment.value = true
            }

        }//Row


        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 35.dp, end = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!viewModel.isopencomment.value) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "안전을 위해 저만 볼수있게 비공개할게요.",
                textcolor = if (!viewModel.isopencomment.value) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (!viewModel.isopencomment.value) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (!viewModel.isopencomment.value) notosans_bold else notosans_regular
            ) {
                viewModel.isopencomment.value = false
            }

        }//Row

        Spacer(modifier = Modifier.height(38.dp))
        IsOpenCommentText(viewModel)


        Spacer(modifier = Modifier.weight(1f))


        ButtonScreen(
            title = "완료",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                .height(55.dp),
            backgroundcolor = Color.Black

        ) {
            //우이아이 찾아요 글쓰기 완료
            activity.finish()

        }


    }
}

@Composable
fun IsOpenCommentText(viewModel: FADetailViewModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .background(color = Color(0xFFECF2FF)),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_main_puppy),
            contentDescription = null,
            modifier = Modifier
                .width(50.dp)
                .height(40.dp)
                .align(Alignment.CenterVertically)
                .padding(start = 20.dp)
        )

        SpacerWidth(dp = 15.dp)

        Text(
            text = if (viewModel.isopencomment.value) "*  공개 시 제보된 위치가 게시물에 노출되며,\n    펫밀리 사용자 모두 확인할 수 있습니다." else "*  비공개 시 제보 내용은 미노출되며,\n   작성자만 확인할 수 있습니다.",
            fontSize = 13.sp,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterVertically)
        )


    }//Row
}

