package com.llama.petmilly_client.presentation.signupscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.login.SignUpScreen_name
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpScreen_4_1_iswithanimal
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_1_BIRTHDAY
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_2_GENDER
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_3_JOB
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_4_1_ISWITHANIMAL
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_4_2_CALLYOUTANIMAL
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_5_ISTEMPORARYCARE
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_6_ISALLERGY
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_7_CALLYOURHOUSE
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_8_CALLWORKINGTIME
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_COMPLETED
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_NAME

@AndroidEntryPoint
class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = SIGNUPSCREEN_NAME ){
                composable(SIGNUPSCREEN_NAME){
                    SignUpScreen_name(navController)
                }

                composable(SIGNUPSCREEN_1_BIRTHDAY){
                    SignUpScreen_1_birthday(navController = navController)
                }

                composable(SIGNUPSCREEN_2_GENDER){
                    SignUpScreen_2_gender(navController = navController)
                }

                composable(SIGNUPSCREEN_3_JOB){
                    SignUpScreen_3_job(navController = navController)
                }

                composable(SIGNUPSCREEN_4_1_ISWITHANIMAL){
                    SignUpScreen_4_1_iswithanimal(navController = navController)
                }

                composable(SIGNUPSCREEN_4_2_CALLYOUTANIMAL){
                    SignUpScreen_4_2_CallYourAnimal(navController = navController)
                }
                composable(SIGNUPSCREEN_5_ISTEMPORARYCARE){
                    SignUpScreen_5_istemporarycare(navController = navController)
                }
                composable(SIGNUPSCREEN_6_ISALLERGY){
                    SignUpScreen_6_isallergy(navController = navController)
                }

                composable(SIGNUPSCREEN_7_CALLYOURHOUSE){
                    SignUpScreen_7_callyourhouse(navController = navController)
                }

                composable(SIGNUPSCREEN_8_CALLWORKINGTIME){
                    SignUpScreen_8_callworkingtime(navController = navController)
                }

                composable(SIGNUPSCREEN_COMPLETED){
                    SignUpScreen_completed(navController = navController)
                }



            }
        }

    }
}