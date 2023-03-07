package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.presentation.dialog.AlmostCompletedDialog
import com.llama.petmilly_client.presentation.dialog.SetAlomostCompletedDialog
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.*
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun ShelterDetail_species_Screen(
    navController: NavController,
    viewModel: ShelterDetailViewModel,
    activity: ShelterDetailActivity,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        ShelterDetailTitleBar(title = "임보처구해요", ismenu = false, clickBack = { activity.finish() }) {
//            activity.finish()
            viewModel.onShownAlmostCompetedDialog()
        }

        ShelterDetailSuvTitle("주인공의 정보를\n입력해주세요.")

        Spacer(modifier = Modifier.height(50.dp))

        ShelterBtn(species = "강아지", viewModel)


        Spacer(modifier = Modifier.height(16.dp))

        ShelterBtn(species = "고양이", viewModel)

        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(55.dp),
            backgroundcolor = if (viewModel.species.value != "") Button_Clicked else Button_NoneClicked
        ) {
            navController.navigate(Common.SHELTERDETAIL_1_PROFILE_SCREEN)
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
fun ShelterBtn(species: String, viewModel: ShelterDetailViewModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 35.dp, end = 50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (viewModel.species.value == species) {
            CheckedCheckBox(clickcolor = Category_Cliked)
        } else {
            NoneCheckBox(nonecheckcolor = Color.White)
        }

        ButtonShapeScreen(
            title = species,
            textcolor = if (viewModel.species.value == species) Color.White else Color.Black,
            fontSize = 15,
            modifier = Modifier
                .padding(start = 10.dp)
                .height(55.dp)
                .fillMaxWidth(),
            backgroundcolor = if (viewModel.species.value == species) Category_Cliked else Button_NoneClicked,
            shape = RoundedCornerShape(19.dp),
            textAlign = TextAlign.Start,
            fontFamily = if (viewModel.pickup.value == species) notosans_bold else notosans_regular
        ) {
            viewModel.species.value = species
        }

    }//Row
}
