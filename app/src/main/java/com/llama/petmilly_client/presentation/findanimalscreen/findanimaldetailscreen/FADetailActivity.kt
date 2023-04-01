package com.llama.petmilly_client.presentation.findanimalscreen.findanimaldetailscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.FADETAILSCREEN_5_COMMENT_ISOPEN

@AndroidEntryPoint
class FADetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: FADetailViewModel = hiltViewModel()

            NavHost(
                navController = navController,
                startDestination = Common.FADETAILSCREEN_1_ANIMALTYPE
            ) {
                composable(Common.FADETAILSCREEN_1_ANIMALTYPE) {
                    FADetailScreen_1_AnmialType(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@FADetailActivity
                    )
                }


                composable(Common.FADETAILSCREEN_2_PROFILE_1) {
                    FADetail_2_Profile_1_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@FADetailActivity
                    )
                }


                composable(Common.FADETAILSCREEN_2_PROFILE_2) {
                    FADetail_2_Profile_2_Screen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@FADetailActivity
                    )
                }

                composable(Common.FADETAILSCREEN_3_DETAILINFO) {
                    FADetailScreen_3_DetailInfo(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@FADetailActivity
                    )
                }

                composable(Common.FADETAILSCREEN_4_DETAILINFO) {
                    FADetailScreen_4_DetailInfo(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@FADetailActivity
                    )
                }

                composable(Common.FADETAILSCREEN_5_COMMENT_ISOPEN) {
                    FADetailScreen_5_Comment_IsOpen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@FADetailActivity
                    )
                }



            }
        }
    }
}

