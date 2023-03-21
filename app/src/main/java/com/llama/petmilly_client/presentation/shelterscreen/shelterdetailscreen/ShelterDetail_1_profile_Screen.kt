package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.dialog.SetAlomostCompletedDialog
import com.llama.petmilly_client.presentation.findanimalscreen.ImageTestData
import com.llama.petmilly_client.presentation.shelterscreen.ShelterDetailTitleBar
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.*
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.io.IOException

@SuppressLint("Recycle")
@Composable
fun ShelterDetail_1_profile_Screen(
    navController: NavController,
    viewModel: ShelterDetailViewModel,
    activity: ShelterDetailActivity,
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
            title = "임보처구해요",
            ismenu = false,
            clickBack = { navController.popBackStack() }) {
            viewModel.onShownAlmostCompetedDialog()
        }

        ShelterDetailSuvTitle("주인공의 프로필을\n입력해주세요.")

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
            value = viewModel.animalname.value,
            onValueChange = { viewModel.animalname.value = it },
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
                textcolor = if (viewModel.animalsex.value == "수컷") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.animalsex.value == "수컷") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                enabled = true
            ) {
                viewModel.animalsex.value = "수컷"
            }

//            TextScreen_HOUSE(
//                title = "수컷",
//                textcolor = if (viewModel.animalsex.value == "수컷") Color.White else Color.Black,
//                fontSize = 20,
//                modifier = Modifier
//                    .background(color = Button_NoneClicked, shape = RoundedCornerShape(20.dp))
//                    .weight(1f)
//                    .height(55.dp)
//                ,
//                textAlign = TextAlign.Center,
//            ) {
//
//            }

            ButtonScreen_HOUSE(
                title = "암컷",
                textcolor = if (viewModel.animalsex.value == "암컷") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.animalsex.value == "암컷") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                enabled = true
            ) {
                viewModel.animalsex.value = "암컷"
            }

            ButtonScreen_HOUSE(
                title = "모름",
                textcolor = if (viewModel.animalsex.value == "모름") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.animalsex.value == "모름") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
                enabled = true
            ) {
                viewModel.animalsex.value = "모름"
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
                Log.d(TAG, " Uri Call Error: $e")
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
                        Log.d(TAG, "ShelterDetail_1_profile_Screen: $imageTestUriData")
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

            val ischeck = viewModel.animalname.value != "" && viewModel.animalsex.value != ""
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
                    navController.navigate(Common.SHELTERDETAIL_2_PROFILE_SCREEN)
                } else {

                }
            }

            Text(
                text = "1/8", fontSize = 13.sp,
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



data class ImageTestUriData(
    val uri: Uri,
)

@Preview
@Composable
fun EKUG() {

}