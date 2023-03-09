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
import androidx.compose.runtime.Composable
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
            text = "OOO님,\n가족구성원에 대해\n알려주세요!",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp, start = 40.dp, end = 40.dp, bottom = 30.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(text = "*  실 거주기준으로 입력해주세요.", fontSize = 13.sp, color = Color.Black)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.familyInfo.value.contains(FamilyInfo("부모님", false))) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            val familyInfoList = viewModel.familyInfo.value
            val isFamilyInfoExist = familyInfoList.any { it.role == "부모님" && !it.isFlexible }

            ButtonShapeScreen(
                title = "부모님(아빠/엄마)",
                textcolor = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "부모님",
                            false
                        )
                    )
                ) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (isFamilyInfoExist) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "부모님",
                            false
                        )
                    )
                ) notosans_bold else notosans_regular
            ) {
                if (viewModel.familyInfo.value.contains(FamilyInfo("부모님", false))) {
                    viewModel.deletefamilyInfo(FamilyInfo("부모님", false))
                } else {
                    viewModel.addFamilyInfo(FamilyInfo("부모님", false))
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
            if (viewModel.familyInfo.value.contains(FamilyInfo("형제자매", false))) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "형제자매(언니/누나/형/동생)",
                textcolor = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "형제자매",
                            false
                        )
                    )
                ) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "형제자매",
                            false
                        )
                    )
                ) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "형제자매",
                            false
                        )
                    )
                ) notosans_bold else notosans_regular
            ) {

                if (viewModel.familyInfo.value.contains(FamilyInfo("형제자매", false))) {
                    viewModel.deletefamilyInfo(FamilyInfo("형제자매", false))
                } else {
                    viewModel.addFamilyInfo(FamilyInfo("형제자매", false))
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
            if (viewModel.familyInfo.value.contains(FamilyInfo("배우자", false))) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "배우자(남편/부인)",
                textcolor = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "배우자",
                            false
                        )
                    )
                ) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "배우자",
                            false
                        )
                    )
                ) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "배우자",
                            false
                        )
                    )
                ) notosans_bold else notosans_regular
            ) {

                if (viewModel.familyInfo.value.contains(FamilyInfo("배우자", false))) {
                    viewModel.deletefamilyInfo(FamilyInfo("배우자", false))
                } else {
                    viewModel.addFamilyInfo(FamilyInfo("배우자", false))
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
            if (viewModel.familyInfo.value.contains(FamilyInfo("본인", false))) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "본인",
                textcolor = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "본인",
                            false
                        )
                    )
                ) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "본인",
                            false
                        )
                    )
                ) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "본인",
                            false
                        )
                    )
                ) notosans_bold else notosans_regular
            ) {

                if (viewModel.familyInfo.value.contains(FamilyInfo("본인", false))) {
                    viewModel.deletefamilyInfo(FamilyInfo("본인", false))
                } else {
                    viewModel.addFamilyInfo(FamilyInfo("본인", false))
                }

                Log.d(TAG, "SignUpScreen_8_1_callworkingtime: ${viewModel.familyInfo}")

//                if(viewModel.famillylist.contains("본인")){
//                    viewModel.famillylist.remove("본인")
//                }else{
//                    viewModel.famillylist.add("본인")
//                }
            }

        }//Row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.familyInfo.value.contains(FamilyInfo("그외", false))) {
                CheckedCheckBox(clickcolor = Category_Cliked)
            } else {
                NoneCheckBox(nonecheckcolor = Color.White)
            }

            ButtonShapeScreen(
                title = "그외",
                textcolor = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "그외",
                            false
                        )
                    )
                ) Color.White else Color.Black,
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(55.dp)
                    .fillMaxWidth(),
                backgroundcolor = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "그외",
                            false
                        )
                    )
                ) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Start,
                fontFamily = if (viewModel.familyInfo.value.contains(
                        FamilyInfo(
                            "그외",
                            false
                        )
                    )
                ) notosans_bold else notosans_regular
            ) {

                if (viewModel.familyInfo.value.contains(FamilyInfo("그외", false))) {
                    viewModel.deletefamilyInfo(FamilyInfo("그외", false))
                } else {
                    viewModel.addFamilyInfo(FamilyInfo("그외", false))
                }

                Log.d(TAG, "SignUpScreen_8_1_callworkingtime: ${viewModel.familyInfo}")
            }

        }//Row


        Spacer(modifier = Modifier.weight(1f))

        val check = viewModel.familyInfo.value.size > 0

        ButtonScreen(
            title = "완료",
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
                Toast.makeText(context, "아직 체크하지 않은 항목이 있습니다.", Toast.LENGTH_LONG).show()

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

