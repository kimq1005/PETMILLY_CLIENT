package com.llama.petmilly_client.presentation.signupscreen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.ButtonShapeScreen
import com.llama.petmilly_client.utils.CheckedCheckBox
import com.llama.petmilly_client.utils.NoneCheckBox
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_COMPLETED

@Composable
fun SignUpScreen_8_1_callworkingtime(navController: NavController, viewModel: SignUpViewModel) {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        TitleBar(title = "", ismenu = false, clickBack = {
            navController.popBackStack()
        }) {
        }

        CommonSignDescription()

        Text(
            text = "OOO님,\n가족구성원에 대해\n알려주세요!",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(text = "*  실 거주기준으로 입력해주세요.", fontSize = 13.sp, color = Color.Black,)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.famillylist.contains("부모님")) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "부모님(아빠/엄마)",
                textcolor = if (viewModel.famillylist.contains("부모님")) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.famillylist.contains("부모님")) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start
            ) {

                if(viewModel.famillylist.contains("부모님")){
                    viewModel.famillylist.remove("부모님")
                }else{
                    viewModel.famillylist.add("부모님")
                }
            }

        }//Row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.famillylist.contains("부모님")) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "형제자매(언니/누나/형/동생)",
                textcolor = if (viewModel.famillylist.contains("부모님")) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.famillylist.contains("부모님")) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start
            ) {
                if(viewModel.famillylist.contains("형제자매")){
                    viewModel.famillylist.remove("형제자매")
                }else{
                    viewModel.famillylist.add("형제자매")
                }
            }

        }//Row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.famillylist.contains("배우자")) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "배우자(남편/부인)",
                textcolor = if (viewModel.famillylist.contains("배우자")) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.famillylist.contains("배우자")) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start
            ) {
                if(viewModel.famillylist.contains("배우자")){
                    viewModel.famillylist.remove("배우자")
                }else{
                    viewModel.famillylist.add("배우자")
                }
            }

        }//Row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.famillylist.contains("본인")) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "본인",
                textcolor = if (viewModel.famillylist.contains("본인")) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.famillylist.contains("본인")) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start
            ) {
                if(viewModel.famillylist.contains("본인")){
                    viewModel.famillylist.remove("본인")
                }else{
                    viewModel.famillylist.add("본인")
                }
            }

        }//Row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.famillylist.contains("그외")) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "그외",
                textcolor = if (viewModel.famillylist.contains("그외")) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.famillylist.contains("그외")) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start
            ) {
                if(viewModel.famillylist.contains("그외")){
                    viewModel.famillylist.remove("그외")
                }else{
                    viewModel.famillylist.add("그외")
                }
            }

        }//Row


        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "완료",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(55.dp),
            backgroundcolor = Button_Clicked
        ) {
            if(viewModel.famillylist.isEmpty()){
                Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()
            }else{
                navController.navigate(SIGNUPSCREEN_COMPLETED)
            }
        }
    }
}
