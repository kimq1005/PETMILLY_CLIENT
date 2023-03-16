package com.llama.petmilly_client.presentation.signupscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.data.model.additonal.reponse.CompanionAnimalInfo
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
fun SignUpScreen_4_3_CallYourAnimal_Third(
    navController: NavController,
    viewModel: SignUpViewModel,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

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
            fontFamily =  notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black
        )

        Text(
            text = "[마지막으로, 셋째에 대한 정보를 입력해주세요]",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Category_Cliked,
            modifier = Modifier.padding(start = 30.dp, top = 25.dp)
        )

        TextField(
            value = viewModel.breed_animal.value,
            onValueChange = { viewModel.breed_animal.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 5.dp)
                .height(55.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = { Text(text = "품종을 입력해주세요") }
        )

        TextField(
            value = viewModel.age_animal.value,
            onValueChange = { viewModel.age_animal.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 25.dp)
                .height(55.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            }),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
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
                textcolor = if (viewModel.gender_animal.value == "수컷") Color.White else Color.Black,
                fontSize = 18,
                modifier = Modifier
                    .weight(1f)
                    .height(55.dp),
                backgroundcolor = if (viewModel.gender_animal.value == "수컷") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                fontFamily = if (viewModel.gender_animal.value == "수컷") notosans_bold else notosans_regular
            ) {
                viewModel.gender_animal.value = "수컷"
            }

            Spacer(modifier = Modifier.width(10.dp))

            ButtonShapeScreen(
                title = "암컷",
                textcolor = if (viewModel.gender_animal.value == "암컷") Color.White else Color.Black,
                fontSize = 18,
                modifier = Modifier
                    .weight(1f)
                    .height(55.dp),
                backgroundcolor = if (viewModel.gender_animal.value == "암컷") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                fontFamily = if (viewModel.gender_animal.value == "암컷") notosans_bold else notosans_regular
            ) {
                viewModel.gender_animal.value = "암컷"

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
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonShapeScreen(
                title = "중성화O",
                textcolor = if (viewModel.neutered_animal.value == "중성화O") Color.White else Color.Black,
                fontSize = 18,
                modifier = Modifier
                    .weight(1f)
                    .height(55.dp),
                backgroundcolor = if (viewModel.neutered_animal.value == "중성화O") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                fontFamily = if (viewModel.neutered_animal.value == "중성화O") notosans_bold else notosans_regular
            ) {
                viewModel.neutered_animal.value = "중성화O"
            }

            Spacer(modifier = Modifier.width(10.dp))

            ButtonShapeScreen(
                title = "중성화X",
                textcolor = if (viewModel.neutered_animal.value == "중성화X") Color.White else Color.Black,
                fontSize = 18,
                modifier = Modifier
                    .weight(1f)
                    .height(55.dp),
                backgroundcolor = if (viewModel.neutered_animal.value == "중성화X") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                fontFamily = if (viewModel.neutered_animal.value == "중성화X") notosans_bold else notosans_regular
            ) {
                viewModel.neutered_animal.value = "중성화X"

            }
        }//Row

        Spacer(modifier = Modifier.weight(1f))

        val check =
            viewModel.breed_animal.value != "" && viewModel.age_animal.value != "" && viewModel.gender_animal.value != "" && viewModel.neutered_animal.value != ""

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

            if (check) {

                if (viewModel.companionAnimalInfo.size > 2) {
                    viewModel.companionAnimalInfo[2] = CompanionAnimalInfo(
                        breed = viewModel.breed_animal.value,
                        age = viewModel.age_animal.value.toInt(),
                        gender = viewModel.gender_animal.value,
                        neutered = viewModel.neutered_animal.value
                    )
                    viewModel.companionAnimalInfo.removeLast()
                }

                viewModel.companionAnimalInfo.add(
                    CompanionAnimalInfo(
                        breed = viewModel.breed_animal.value,
                        age = viewModel.age_animal.value.toInt(),
                        gender = viewModel.gender_animal.value,
                        neutered = viewModel.neutered_animal.value
                    )
                )

                Log.d(
                    Common.TAG,
                    "SignUpScreen_4_3_CallYourAnimal_First: ${viewModel.companionAnimalInfo}"
                )

                viewModel.clearanimalcheck()
                navController.navigate(Common.SIGNUPSCREEN_5_ISTEMPORARYCARE)


            } else {
                Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()

            }

        }
    }//Column
}