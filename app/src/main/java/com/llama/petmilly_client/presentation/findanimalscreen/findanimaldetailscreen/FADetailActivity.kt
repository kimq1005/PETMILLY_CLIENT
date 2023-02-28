package com.llama.petmilly_client.presentation.findanimalscreen.findanimaldetailscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import llama.test.jetpack_dagger_plz.utils.Common

class FADetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: FADetailViewModel = hiltViewModel()

            NavHost(
                navController = navController,
                startDestination = Common.FADETAILSCREEN_1_DETAILINFO
            ) {
                composable(Common.FADETAILSCREEN_1_DETAILINFO) {
                    FADetailScreen_1_DetailInfo(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@FADetailActivity
                    )
                }

                composable(Common.FADETAILSCREEN_2_DETAILINFO) {
                    FADetailScreen_2_DetailInfo(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@FADetailActivity
                    )
                }

                composable(Common.FADETAILSCREEN_3_COMMENT_ISOPEN) {
                    FADetailScreen_3_Comment_IsOpen(
                        navController = navController,
                        viewModel = viewModel,
                        activity = this@FADetailActivity
                    )
                }



            }
        }
    }
}

