package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.icu.text.CaseMap.Title
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.SHELTERDETAIL_SPECIES_SCREEN
@AndroidEntryPoint
class ShelterDetailActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: ShelterDetailViewModel = hiltViewModel()

            NavHost(
                navController = navController,
                startDestination = Common.SHELTERDETAIL_SPECIES_SCREEN
            ) {
                composable(SHELTERDETAIL_SPECIES_SCREEN){
                    ShelterDetail_species_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@ShelterDetailActivity
                    )
                }

                composable(Common.SHELTERDETAIL_1_PROFILE_SCREEN) {
                    ShelterDetail_1_profile_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@ShelterDetailActivity
                    )
                }

                composable(Common.SHELTERDETAIL_2_PROFILE_SCREEN){
                    ShelterDetail_2_profile_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@ShelterDetailActivity
                    )
                }

                composable(Common.SHELTERDETAIL_3_PROFILE_SCREEN){
                    ShelterDetail_3_profile_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@ShelterDetailActivity
                    )
                }

                composable(Common.SHELTERDETAIL_4_PROFILE_SCREEN){
                    ShelterDetail_4_profile_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@ShelterDetailActivity
                    )
                }

                composable(Common.SHELTERDETAIL_5_CONDITION_SCREEN){
                    ShelterDetail_5_conditons_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@ShelterDetailActivity
                    )
                }

                composable(Common.SHELTERDETAIL_6_CONDITION_SCREEN){
                    ShelterDetail_6_conditons_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@ShelterDetailActivity
                    )
                }

                composable(Common.SHELTERDETAIL_7_CHARMAPPEAL_SCREEN){
                    ShelterDetail_CharmAppeal_7_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@ShelterDetailActivity
                    )
                }


                composable(Common.SHELTERDETAIL_8_APPLICATION_SCREEN){
                    ShelterDetail_8_Application_Period_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@ShelterDetailActivity
                    )
                }
            }

        }
    }
}

@Composable
fun ShelterDetailSuvTitle(text: String) {

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_jong),
                contentDescription = null,
                modifier = Modifier
                    .width(44.dp)
                    .height(44.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = stringResource(id = R.string.sheltersuvtitle),
                fontSize = 13.sp,
                color = Color.Black,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = text,
            modifier = Modifier.padding(start = 40.dp),
            fontSize = 30.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black
        )

    }

}


