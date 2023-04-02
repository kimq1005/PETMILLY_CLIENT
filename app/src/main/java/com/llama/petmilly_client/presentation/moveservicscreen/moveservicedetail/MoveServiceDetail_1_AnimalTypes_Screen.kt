package com.llama.petmilly_client.presentation.moveservicscreen.moveservicedetail

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.llama.petmilly_client.presentation.dialog.SetAlomostCompletedDialog
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen.ShelterDetailSuvTitle
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.*
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun MoveServiceDetail_1_AnimalTypes_Screen(
    navController: NavController,
    viewModel: MoveServiceDetailViewModel,
    activity : Activity
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        ShelterDetailTitleBar(title = "이동봉사 찾아요", ismenu = false, clickBack = { activity.finish() }) {
//            activity.finish()
            viewModel.onShownAlmostCompetedDialog()
        }

        MoveServiceDetailSuvTitle("주인공의 정보를\n입력해주세요.")
        Spacer(modifier = Modifier.height(50.dp))

        MoveServiceBtn(species = "강아지", viewModel)


        Spacer(modifier = Modifier.height(16.dp))

        MoveServiceBtn(species = "고양이", viewModel)

        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(55.dp),
            backgroundcolor = if (viewModel.animalTypes.value != "") Button_Clicked else Button_NoneClicked
        ) {
            navController.navigate(Common.MOVESERVICEDETAILSCREEN_2_PROFILE_1)
        }


        SetAlomostCompletedDialog(
            viewModel.isAlmostCompletedDialog, onDismiss = {
                viewModel.onDismissAlmostCompetedDialog()
            },
            activity = activity
        )
    }//Column

}

@Composable
fun MoveServiceBtn(species: String, viewModel: MoveServiceDetailViewModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 35.dp, end = 50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (viewModel.animalTypes.value == species) {
            CheckedCheckBox(clickcolor = Category_Cliked)
        } else {
            NoneCheckBox(nonecheckcolor = Color.White)
        }

        ButtonShapeScreen(
            title = species,
            textcolor = if (viewModel.animalTypes.value == species) Color.White else Color.Black,
            fontSize = 15,
            modifier = Modifier
                .padding(start = 10.dp)
                .height(55.dp)
                .fillMaxWidth(),
            backgroundcolor = if (viewModel.animalTypes.value == species) Category_Cliked else Button_NoneClicked,
            shape = RoundedCornerShape(19.dp),
            textAlign = TextAlign.Start,
            fontFamily = if(viewModel.animalTypes.value == species) notosans_bold else notosans_regular
        ) {
            viewModel.animalTypes.value = species
        }

    }//Row
}
