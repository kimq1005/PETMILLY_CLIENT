package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.annotation.SuppressLint
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
            title = "??????????????????",
            ismenu = false,
            clickBack = { navController.popBackStack() }) {
            viewModel.onShownAlmostCompetedDialog()
        }

        ShelterDetailSuvTitle("???????????? ????????????\n??????????????????.")

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "??????",
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
                backgroundColor = if (viewModel.animalname.value == "") TextField_BackgroudColor else Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = { Text(text = "???????????? ????????? ???????????????.") }
        )


        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "??????",
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
                title = "??????",
                textcolor = if (viewModel.animalsex.value == "??????") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.animalsex.value == "??????") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center
            ) {
                viewModel.animalsex.value = "??????"
            }

//            TextScreen_HOUSE(
//                title = "??????",
//                textcolor = if (viewModel.animalsex.value == "??????") Color.White else Color.Black,
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
                title = "??????",
                textcolor = if (viewModel.animalsex.value == "??????") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.animalsex.value == "??????") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center
            ) {
                viewModel.animalsex.value = "??????"
            }

            ButtonScreen_HOUSE(
                title = "??????",
                textcolor = if (viewModel.animalsex.value == "??????") Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(55.dp),
                backgroundcolor = if (viewModel.animalsex.value == "??????") Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center
            ) {
                viewModel.animalsex.value = "??????"
            }


        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "????????????",
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
                val inputStrem = context.contentResolver.openInputStream(uri!!)
                bitmapState.value = BitmapFactory.decodeStream(inputStrem)
                viewModel.uploadimage(uri)

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
                            viewModel.deleteimage(items.uri)
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
                title = "??????",
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