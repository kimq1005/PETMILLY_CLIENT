package com.llama.petmilly_client.presentation.signupscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.login.SignUpScreen_1
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_1
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_2
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_3

@AndroidEntryPoint
class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = SIGNUPSCREEN_1 ){
                composable(SIGNUPSCREEN_1){
                    SignUpScreen_1(navController = navController)
                }

                composable(SIGNUPSCREEN_2){

                }

                composable(SIGNUPSCREEN_3){

                }

            }
        }

    }
}