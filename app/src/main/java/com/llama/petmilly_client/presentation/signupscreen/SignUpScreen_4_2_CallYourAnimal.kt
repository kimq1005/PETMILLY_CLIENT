package com.llama.petmilly_client.presentation.signupscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.*
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_4_3_CALLYOUTANIMAL_First

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen_4_2_CallYourAnimal(navController: NavController, viewModel: SignUpViewModel) {

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        TitleBar(title = "", ismenu = false, clickBack = {
            navController.popBackStack()
        }) {
        }

        CommonSignDescription()
//

        Text(
            text = "반려동물에 대해\n알려주세요!",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
            fontFamily =  notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.numberofanimal.value == "1마리와 함께 살고 있어요.") {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "1마리와 함께 살고 있어요.",
                textcolor = if (viewModel.numberofanimal.value == "1마리와 함께 살고 있어요.") Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.numberofanimal.value == "1마리와 함께 살고 있어요.") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (viewModel.numberofanimal.value == "1마리와 함께 살고 있어요.") notosans_bold else notosans_regular
            ) {
                viewModel.numberofanimal.value = "1마리와 함께 살고 있어요."
            }

        }//Row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.numberofanimal.value == "2마리와 함께 살고 있어요.") {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "2마리와 함께 살고 있어요.",
                textcolor = if (viewModel.numberofanimal.value == "2마리와 함께 살고 있어요.") Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.numberofanimal.value == "2마리와 함께 살고 있어요.") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (viewModel.numberofanimal.value == "2마리와 함께 살고 있어요.") notosans_bold else notosans_regular
            ) {
                viewModel.numberofanimal.value = "2마리와 함께 살고 있어요."
            }

        }//Row


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.numberofanimal.value == "3마리와 함께 살고 있어요.") {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "3마리와 함께 살고 있어요.",
                textcolor = if (viewModel.numberofanimal.value == stringResource(id = R.string.test_string)) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.numberofanimal.value == "3마리와 함께 살고 있어요.") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (viewModel.numberofanimal.value == "3마리와 함께 살고 있어요.") notosans_bold else notosans_regular
            ) {
                viewModel.numberofanimal.value = "3마리와 함께 살고 있어요."
            }
        }//Row


        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(55.dp),
            backgroundcolor = Button_Clicked
        ) {
            navController.navigate(SIGNUPSCREEN_4_3_CALLYOUTANIMAL_First)
        }

    }// Column


}

