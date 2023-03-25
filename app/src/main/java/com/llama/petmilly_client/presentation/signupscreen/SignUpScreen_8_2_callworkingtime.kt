package com.llama.petmilly_client.presentation.signupscreen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.llama.petmilly_client.data.model.additonal.reponse.FamilyInfo
import com.llama.petmilly_client.presentation.MainViewModel
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.*
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun SignUpScreen_8_2_callworkingtime(navController: NavController, viewModel: SignUpViewModel) {

    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TitleBar(title = "", ismenu = false, clickBack = {
            viewModel.familyInfo.value.clear()
            navController.popBackStack()
        }) {
        }

        CommonSignDescription()

        Text(
            text = "집에 상주하시거나\n유동적 출근이신 분이\n계시나요?",
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
            text = "*  실 거주기준으로 입력해주세요.",
            fontSize = 13.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 40.dp),
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )


        )

        LazyColumn() {
            items(viewModel.familyInfo.value) {
                CheckFamilyItem(viewModel = viewModel, familyInfo = it)
            }

        }


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
//            navController.navigate(Common.SIGNUPSCREEN_COMPLETED)
            viewModel.postadditionalinfo()

//            Log.d(TAG, "SignUpScreen_8_2_callworkingtime: ${viewModel.additionalResponse}")
        }
    }

    LaunchedEffect(context){
        setObserve(viewModel,lifecycleOwner,navController)
    }
}


private fun setObserve(
    viewModel: SignUpViewModel,
    lifecycleOwner: LifecycleOwner,
    navController: NavController,
) {
    viewModel.setIntent.observe(lifecycleOwner, Observer {
        navController.navigate(Common.SIGNUPSCREEN_COMPLETED)
    })
}


/**
 * 1. lazycolumn으로 familyinfo.value 불러와서 띄워줌, 필요한것 **/
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
//            onclick()
            viewModel.updateFamilyInfo(familyInfo.copy(isFlexible = mycheck))
//            Log.d(TAG, "CheckFamilyItem: ${viewModel.familyInfo.value}")
            //클릭을 하면 클릭한 아이템의 familyInfo의 , isFlexble이 true false로 바껴야 돼
        }

    }//Row
}