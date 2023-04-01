package com.llama.petmilly_client.presentation.findanimalscreen.findanimaldetailscreen

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.dialog.SetAlomostCompletedDialog
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen.ImageTestUriData
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.ui.theme.Grey_50_CBC4C4
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.*
import llama.test.jetpack_dagger_plz.utils.Common
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.IOException


@Composable
fun FADetail_2_Profile_1_Screen(
    navController: NavController,
    viewModel: FADetailViewModel,
    activity: Activity
) {
    SetAlomostCompletedDialog(
        viewModel.isAlmostCompletedDialog, onDismiss = {
            viewModel.onDismissAlmostCompetedDialog()
        },
        activity = activity
    )

    val context = LocalContext.current
    val bitmapState = remember {
        mutableStateOf<Bitmap?>(null)
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ShelterDetailTitleBar(
            title = "우리아이 찾아요",
            ismenu = false,
            clickBack = { navController.popBackStack() }) {
            viewModel.onShownAlmostCompetedDialog()
        }

        FADetailSuvTitle("주인공의 프로필을\n" +
                "입력해주세요.")
        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "이름",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))


        TextField(
            value = viewModel.name.value,
            onValueChange = { viewModel.name.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = { Text(text = "주인공의 이름을 적어주세요.") }
        )


        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "성별",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        val transparentGray = Color.Gray.copy(alpha = 0.2f)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ButtonScreen_HOUSE(
                title = "수컷",
                textcolor = if (viewModel.gender.value == "수컷") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.gender.value == "수컷") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                enabled = true
            ) {
                viewModel.gender.value = "수컷"
            }


            ButtonScreen_HOUSE(
                title = "암컷",
                textcolor = if (viewModel.gender.value == "암컷") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.gender.value == "암컷") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                enabled = true
            ) {
                viewModel.gender.value = "암컷"
            }

            ButtonScreen_HOUSE(
                title = "모름",
                textcolor = if (viewModel.gender.value == "모름") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.gender.value == "모름") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                enabled = true
            ) {
                viewModel.gender.value = "모름"
            }


        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "사진첨부",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        SpacerHeight(dp = 8.dp)

        val imageTestUriData = remember { mutableStateListOf<ImageTestUriData>() }


        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
        ) { uri ->
            try {
                val inputStream = context.contentResolver.openInputStream(uri!!)
                val requestBody = RequestBody.create("image/*".toMediaTypeOrNull(), inputStream!!.readBytes())
                val multipleBody=  MultipartBody.Part.createFormData("files", "image", requestBody)

                bitmapState.value = BitmapFactory.decodeStream(inputStream)
                viewModel.uploadimage(uri)
                viewModel.updateFiles(multipleBody)

            } catch (e: IOException) {
                Log.d(Common.TAG, " Uri Call Error: $e")
            }
        }

        Row(Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.img_comment_camera),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(47.dp)
                    .width(47.dp)
                    .clickable {
                        launcher.launch("image/*")
                    }
            )

            SpacerWidth(dp = 10.dp)

            LazyRow() {
                items(viewModel.imageTestUriData) { items ->
                    PicktureUriItems(
                        items.uri,
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp),
                        ondelete = {
                            val inputStream = context.contentResolver.openInputStream(items.uri!!)
                            val requestBody = RequestBody.create("image/*".toMediaTypeOrNull(), inputStream!!.readBytes())
                            val multipleBody=  MultipartBody.Part.createFormData("files", "image", requestBody)

                            viewModel.deleteimage(items.uri)
                            viewModel.deleteFiles(multipleBody)
                        }
                    )
                    SpacerWidth(dp = 10.dp)

                }
            }
        }








        Spacer(modifier = Modifier.weight(1f))



        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {

            val ischeck = viewModel.name.value != "" && viewModel.gender.value != ""
            ButtonScreen(
                title = "다음",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = if (ischeck) Color.Black else Color.LightGray

            ) {
                if (ischeck) {
                    navController.navigate(Common.FADETAILSCREEN_2_PROFILE_2)
                }
            }

            Text(
                text = "1/4", fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = if (ischeck) Color.White else Grey_50_CBC4C4,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
            )

        }


    }
}


@Composable
fun FADetail_2_Profile_2_Screen(
    navController: NavController,
    viewModel: FADetailViewModel,
    activity: Activity
) {

    SetAlomostCompletedDialog(
        viewModel.isAlmostCompletedDialog, onDismiss = {
            viewModel.onDismissAlmostCompetedDialog()
        },
        activity = activity
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        ShelterDetailTitleBar(
            title = "우리아이 찾아요",
            ismenu = false,
            clickBack = { navController.popBackStack() }) {
            viewModel.onShownAlmostCompetedDialog()
        }

        FADetailSuvTitle("주인공의 프로필을\n" +
                "입력해주세요.")
        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "몸무게",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            TextField(
                value = viewModel.weight.value,
                onValueChange = { viewModel.weight.value = it },
                modifier = Modifier
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = { Text(text = "몸무게를 적어주세요") }
            )


            Text(
                text = " kg",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 18.sp,
                color = Color.Black
            )


        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "품종",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = viewModel.breed.value,
            onValueChange = { viewModel.breed.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            enabled = viewModel.breed.value != "모르겠어요",
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),

            placeholder = { Text(text = "예)믹스견 / 포메라니안 / 진도") }
        )
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.padding(start = 27.dp)) {
//            CheckedCheckBox(clickcolor = Category_Cliked)
            IDontKnowCheckBox(onclick = { string ->
                viewModel.breed.value = string
            })
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "모르겠어요", fontSize = 12.sp, fontFamily = notosans_regular, style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color(0xFF050505)
            )
        }//Row


        Spacer(modifier = Modifier.height(40.dp))


        Text(
            text = "나이",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            TextField(
                value = viewModel.age.value,
                onValueChange = { viewModel.age.value = it },
                modifier = Modifier
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,
                ),
                enabled = viewModel.age.value != "모르겠어요",
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                placeholder = { Text(text = "예) 2개월 = 0.2 / 2살 = 2") }
            )


            Text(
                text = " 살 추정",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 18.sp,
                color = Color.Black
            )

        }//Row

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.padding(start = 27.dp)) {

//            CheckedCheckBox(clickcolor = Category_Cliked)
            IDontKnowCheckBox(onclick = { string ->
                viewModel.age.value = string
            })
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "모르겠어요", fontSize = 12.sp, fontFamily = notosans_regular, style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color(0xFF050505)
            )
        }//Row


        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {

            val ischeck =
                viewModel.weight.value != "" && viewModel.age.value != "" && viewModel.breed.value != ""

            ButtonScreen(
                title = "다음",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = if (ischeck) Color.Black else Color.LightGray

            ) {
                if (ischeck) {
                    navController.navigate(Common.FADETAILSCREEN_3_DETAILINFO)
                }
            }

            Text(
                text = "2/4", fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = if (ischeck) Color.White else Grey_50_CBC4C4,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
            )

        }

    }
}