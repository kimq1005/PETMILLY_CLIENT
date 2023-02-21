package com.llama.petmilly_client.presentation.findanimalscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

            TitleBar(
                title = "우리아이 찾아요",
                ismenu = false,
                clickBack = { navController.popBackStack() }) {
            }

            NavHost(navController = navController, startDestination = Common.SAFESHELTER_COMPOSABLE) {
                composable(route = Common.SAFESHELTER_COMPOSABLE) {
                    SafeShelterListScreen(navController = navController)
                }

                composable(Common.ANIMALINFO_DETAIL) {
                    AnimalInfoDetailScreen(navController = navController)
                }
            }
        }
    }
}