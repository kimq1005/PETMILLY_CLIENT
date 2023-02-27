package com.llama.petmilly_client.presentation.signupscreen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.ButtonShapeScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen_4_3_CallYourAnimal_Second(navController: NavController, viewModel: SignUpViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {

        val context = LocalContext.current
        val keyboardController = LocalSoftwareKeyboardController.current
        val focusManager = LocalFocusManager.current

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
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "[둘째에 대한 정보를 입력해주세요]",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Category_Cliked,
            modifier = Modifier.padding(start = 30.dp, top = 25.dp)
        )

        TextField(
            value = viewModel.animalkind.value,
            onValueChange = { viewModel.animalkind.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 5.dp)
                .height(55.dp)
                .clickable {
                    viewModel.checkCallYourAnimal()
                },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
                viewModel.checkCallYourAnimal()
                focusManager.moveFocus(FocusDirection.Down)
            }),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = if (viewModel.animalkind.value == "") TextField_BackgroudColor else Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = { Text(text = "품종을 입력해주세요") }
        )

        TextField(
            value = viewModel.animalage.value,
            onValueChange = { viewModel.animalage.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 25.dp)
                .height(55.dp)
                .clickable {
                    viewModel.checkCallYourAnimal()
                },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                viewModel.checkCallYourAnimal()
                keyboardController?.hide()
            }),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = if (viewModel.animalage.value == "") TextField_BackgroudColor else Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = { Text(text = "나이를 입력해주세요") }
        )

        Text(
            text = "반려동물 성별을 선택해주세요",
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, bottom = 2.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 30.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonShapeScreen(
                title = "수컷",
                textcolor = if(viewModel.animalgender.value =="수컷") Color.White else Color.Black,
                fontSize = 18,
                modifier = Modifier.weight(1f).height(55.dp),
                backgroundcolor = if(viewModel.animalgender.value =="수컷") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                fontFamily = if(viewModel.animalgender.value =="수컷") notosans_bold else notosans_regular
            ) {
                viewModel.animalgender.value = "수컷"
                viewModel.checkCallYourAnimal()
            }

            Spacer(modifier = Modifier.width(10.dp))

            ButtonShapeScreen(
                title = "암컷",
                textcolor = if(viewModel.animalgender.value =="암컷") Color.White else Color.Black,
                fontSize = 18,
                modifier = Modifier.weight(1f).height(55.dp),
                backgroundcolor = if(viewModel.animalgender.value =="암컷") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                fontFamily =  if(viewModel.animalgender.value =="암컷") notosans_bold else notosans_regular
            ) {
                viewModel.animalgender.value = "암컷"
                viewModel.checkCallYourAnimal()

            }
        }//Row


        Text(
            text = "중성화 여부를 선택해주세요",
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, bottom = 2.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .clickable {
                    viewModel.checkCallYourAnimal()
                },
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonShapeScreen(
                title = "중성화 O",
                textcolor = if (viewModel.isneuteringsurgery.value) Color.White else Color.Black,
                fontSize = 18,
                modifier = Modifier.weight(1f).height(55.dp),
                backgroundcolor = if (viewModel.isneuteringsurgery.value) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                fontFamily = if (viewModel.isneuteringsurgery.value) notosans_bold else notosans_regular
            ) {
                viewModel.isneuteringsurgery.value = true
                viewModel.checkCallYourAnimal()

            }

            Spacer(modifier = Modifier.width(10.dp))

            ButtonShapeScreen(
                title = "중성화 X",
                textcolor = if (viewModel.isneuteringsurgery.value) Color.Black else Color.White,
                fontSize = 18,
                modifier = Modifier.weight(1f).height(55.dp),
                backgroundcolor = if (!viewModel.isneuteringsurgery.value) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                fontFamily =  if (!viewModel.isneuteringsurgery.value) notosans_bold else notosans_regular
            ) {
                viewModel.isneuteringsurgery.value = false
                viewModel.checkCallYourAnimal()

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

            if(viewModel.numberofanimal.value==2){
                navController.navigate(Common.SIGNUPSCREEN_4_3_CALLYOUTANIMAL_Third)
            }else{
                navController.navigate(Common.SIGNUPSCREEN_5_ISTEMPORARYCARE)
            }
        }
    }//Column
}