package com.llama.petmilly_client.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.presentation.homescreen.MapClusteringScreen
import com.llama.petmilly_client.presentation.loginscreen.LoginScreen
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common.LOGINSCREEN
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
//            LoginScreen(navController = navController)

            MapClusteringScreen(){}

//            NavHost(navController = navController, startDestination = LOGINSCREEN) {
//                composable(route = LOGINSCREEN) {
//                    LoginScreen(navController)
//                }
//
//                composable(route = HOMESCREEN){
//                    HomeScreen(navController)
//                    Log.d(TAG, "onCreate: yeah")
//
//                }
//            }
//            }
        }


    }

}