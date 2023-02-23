package com.llama.petmilly_client.presentation.findanimalscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.presentation.shelterscreen.AnimalInfoDetailScreen
import com.llama.petmilly_client.presentation.shelterscreen.SafeShelterListScreen
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import llama.test.jetpack_dagger_plz.utils.Common

class FindAnimalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: FindAnimalViewModel = hiltViewModel()

            Column {


                NavHost(
                    navController = navController,
                    startDestination = Common.FINDANIMAL_LIST_SCREEN
                ) {
                    composable(route = Common.FINDANIMAL_LIST_SCREEN) {
                        FindAnimalListScreen(navController = navController, viewModel,this@FindAnimalActivity)
                    }

                    composable(Common.FINDANIMAL_DETAIL_SCREEN) {
                        FindAnimalDetailScreen(navController = navController)
                    }

                    composable(Common.FINDANIMAL_COMMENT_SCREEN) {
                        FindAnimalCommentScreen(
                            navController = navController,
                            viewModel = viewModel
                        )
                    }
                }
            }

        }
    }
}