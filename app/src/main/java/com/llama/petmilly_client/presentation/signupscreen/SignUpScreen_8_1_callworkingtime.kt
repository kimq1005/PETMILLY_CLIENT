package com.llama.petmilly_client.presentation.signupscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.data.model.additonal.reponse.FamilyInfo
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.*
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_COMPLETED
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun SignUpScreen_8_1_callworkingtime(navController: NavController, viewModel: SignUpViewModel) {

    val context = LocalContext.current
    val scrollState = rememberScrollState()


    var parentscheck by remember {
        mutableStateOf(false)
    }

    var brocheck by remember {
        mutableStateOf(false)
    }

    var spousecheck by remember {
        mutableStateOf(false)
    }

    var mecheck by remember {
        mutableStateOf(false)
    }

    var anothercheck by remember {
        mutableStateOf(false)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = Color.White)
    ) {
        TitleBar(title = "", ismenu = false, clickBack = {
            navController.popBackStack()
        }) {
        }

        CommonSignDescription()

        Text(
            text = "OOO???,\n?????????????????? ??????\n???????????????!",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(text = "*  ??? ?????????????????? ??????????????????.", fontSize = 13.sp, color = Color.Black)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (parentscheck) CheckedCheckBox(clickcolor = Category_Cliked) else NoneCheckBox(
                nonecheckcolor = Color.White
            )

            ButtonShapeScreen(
                title = "?????????(??????/??????)",
                textcolor = if (parentscheck) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (parentscheck) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (parentscheck) notosans_bold else notosans_regular
            ) {

                if (parentscheck) {
                    parentscheck = false
                    viewModel.deletefamilyInfo(FamilyInfo("?????????", false))

                } else {
                    parentscheck = true
                    viewModel.addFamilyInfo(FamilyInfo("?????????", false))
                }

            }

        }//Row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (brocheck) CheckedCheckBox(clickcolor = Category_Cliked) else NoneCheckBox(
                nonecheckcolor = Color.White
            )

            ButtonShapeScreen(
                title = "????????????(??????/??????/???/??????)",
                textcolor = if (brocheck) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (brocheck) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "????????????",
                            false
                        )
                    )
                ) notosans_bold else notosans_regular
            ) {

                if (brocheck) {
                    brocheck = false
                    viewModel.deletefamilyInfo(FamilyInfo("????????????", false))

                } else {
                    brocheck = true
                    viewModel.addFamilyInfo(FamilyInfo("????????????", false))
                }

                Log.d(TAG, "SignUpScreen_8_1_callworkingtime: ${viewModel.familyInfo}")

            }

        }//Row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (spousecheck) CheckedCheckBox(clickcolor = Category_Cliked) else NoneCheckBox(
                nonecheckcolor = Color.White
            )


            ButtonShapeScreen(
                title = "?????????(??????/??????)",
                textcolor = if (spousecheck) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (spousecheck)
                    Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (spousecheck) notosans_bold else notosans_regular
            ) {

                if (spousecheck) {
                    spousecheck = false
                    viewModel.deletefamilyInfo(FamilyInfo("?????????", false))

                } else {
                    spousecheck = true
                    viewModel.addFamilyInfo(FamilyInfo("?????????", false))
                }


            }

        }//Row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (mecheck) CheckedCheckBox(clickcolor = Category_Cliked) else NoneCheckBox(
                nonecheckcolor = Color.White
            )

            ButtonShapeScreen(
                title = "??????",
                textcolor = if (mecheck) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (mecheck) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (mecheck) notosans_bold else notosans_regular
            ) {


                if (mecheck) {
                    mecheck = false
                    viewModel.deletefamilyInfo(FamilyInfo("??????", false))

                } else {
                    mecheck = true
                    viewModel.addFamilyInfo(FamilyInfo("??????", false))
                }

            }

        }//Row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (anothercheck) CheckedCheckBox(clickcolor = Category_Cliked) else NoneCheckBox(
                nonecheckcolor = Color.White
            )


            ButtonShapeScreen(
                title = "??????",
                textcolor = if (anothercheck) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (anothercheck) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (anothercheck) notosans_bold else notosans_regular
            ) {

                if (anothercheck) {
                    anothercheck = false
                    viewModel.deletefamilyInfo(FamilyInfo("??????", false))

                } else {
                    anothercheck = true
                    viewModel.addFamilyInfo(FamilyInfo("??????", false))
                }


            }

        }//Row

        SpacerHeight(dp = 53.dp)

        Spacer(modifier = Modifier.weight(1f))


        val check = viewModel.familyInfo.value.size > 0

        ButtonScreen(
            title = "??????",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(55.dp),
            backgroundcolor = if (check) Button_Clicked else Button_NoneClicked
        ) {
            if (check) {
                Log.d(TAG, "SignUpScreen_8_1_callworkingtime: ${viewModel.familyInfo.value}")
//                navController.navigate(SIGNUPSCREEN_COMPLETED)
            } else {
                Toast.makeText(context, "?????? ???????????? ?????? ????????? ????????????.", Toast.LENGTH_LONG).show()

            }
        }
    }
}

@Preview
@Composable
fun AFAEFAF() {
    val viewModel: SignUpViewModel = hiltViewModel()
    val navController = rememberNavController()
    SignUpScreen_8_1_callworkingtime(navController, viewModel)
}


@Composable
fun CheckFamilyItem(
    viewModel: SignUpViewModel,
    familyInfo: FamilyInfo,
) {

    var mycheck by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (mycheck) CheckedCheckBox(clickcolor = Category_Cliked) else NoneCheckBox(
            nonecheckcolor = Color.White
        )

        ButtonShapeScreen(
            title = familyInfo.role,
            textcolor = if (mycheck) Color.White else Color.Black,
            fontSize = 15,
            modifier = Modifier
                .padding(start = 10.dp)
                .height(55.dp)
                .fillMaxWidth(),
            backgroundcolor = if (mycheck) Category_Cliked else Button_NoneClicked,
            shape = RoundedCornerShape(19.dp),
            textAlign = TextAlign.Start,
            fontFamily = if (mycheck) notosans_bold else notosans_regular
        ) {
            mycheck = !mycheck

            viewModel.updateFamilyInfo(familyInfo.copy(isFlexible = mycheck))
            //????????? ?????? ????????? ???????????? familyInfo??? , isFlexble??? true false??? ????????? ???
        }

    }//Row
}

//            if (check) {
//                check = false
//                viewModel.deletefamilyInfo(FamilyInfo(familyInfo.role, false))
//
//            } else {
//                check = true
//                viewModel.addFamilyInfo(FamilyInfo(familyInfo.role, true))
//            }

