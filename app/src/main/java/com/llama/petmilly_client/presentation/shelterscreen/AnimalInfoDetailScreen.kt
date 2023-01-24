package com.llama.petmilly_client.presentation.shelterscreen

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.llama.petmilly_client.presentation.homescreen.HomeActivity
import com.llama.petmilly_client.presentation.loginscreen.CustomDialog

@Composable
fun AnimalInfoDetailScreen(
    navController: NavController,
    viewModel: ShelterViewModel = viewModel(),
) {

    val context = LocalContext.current
    viewModel.setanimalinfovalue()
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
            .fillMaxSize()
    ) {
        TitleBar(
            title = "임보처 구해요",
            ismenu = true,

            clickBack = {
                navController.popBackStack()
            },
            clickMenu = {

            }
        )


        Text(text = "한줄소개 (매력)")

        Row(modifier = Modifier.fillMaxWidth()) {
            Box() {
                Image(
                    painter = painterResource(id = R.drawable.baseline_person_24),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .align(Alignment.CenterStart)
                )

                Image(
                    painter = painterResource(id = R.drawable.baseline_heart_broken_24),
                    contentDescription = null,
                    modifier = Modifier
                        .height(35.dp)
                        .width(35.dp)
                        .align(Alignment.TopStart)
                )
            }

            Column {
                Text(
                    text = "${viewModel.animalname.value} / ${viewModel.animalgenter.value}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = "${viewModel.animalage.value}살", color = Color.Black)
                Text(
                    text = "${viewModel.animalspecies.value} / ${viewModel.animalweight.value}kg",
                    color = Color.Black
                )
                Text(text = "현재위치지역 어디어디동", color = Color.Black)
            }
        }

        Text(text = "심사기간: 23.1.1 ~23. 1.10")
        Text(text = "*심사기간동안 입양신청서 심사 후 확정 시 앱 알림 및 채팅을 통해 안내드립니다.")

        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "중성화 여부 :")
            Text(text = "접종 여부 :")
            Text(text = "성격 :")
            Text(text = "개인기 :")
            Text(text = "특징 :")
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp), color = Color.Black
        )

        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "픽업방법 : ")
            Text(text = "희망지역:")
            Text(text = "임보 희망 기간:")
            Text(text = "임보조건(입력값):")
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp), color = Color.Black
        )


        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "이런분을 희망해요")
            Text(text = "이런분은 안돼요")
        }

        Text(text = "갤러리 (사진, 동영상)")

        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.baseline_home_24),
            contentDescription = null,

            modifier = Modifier
                .align(Alignment.End)
                .width(50.dp)
                .height(50.dp)
                .clickable {
                    viewModel.onConfirmClick()
                }
        )

        if (viewModel.isDialogShown) {
            AdoptionApplicationDialog(
                onDismiss = { viewModel.onAdoptionDialogDismissDialog() },
                onConfirm = {
                        //동의 신청서 다이얼로그
                            viewModel.onAdoptionDialogConfirmClick()
                },
                onModify = {
                    val intent = Intent(context, CertificationActivity::class.java)
                    context.startActivity(intent)
                }
            )
        }
    }

}


@Preview
@Composable
fun PreviewTEST() {
    val navController = rememberNavController()
    AnimalInfoDetailScreen(navController = navController)
}