package com.llama.petmilly_client.presentation.signupscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.login.SignUpScreen_name
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpScreen_4_1_iswithanimal
import com.llama.petmilly_client.presentation.signupscreen.viewmodel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_1_BIRTHDAY
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_2_GENDER
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_3_JOB
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_4_1_ISWITHANIMAL
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_4_2_CALLYOUTANIMAL
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_4_3_CALLYOUTANIMAL_First
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_4_3_CALLYOUTANIMAL_Second
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_4_3_CALLYOUTANIMAL_Third
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_5_ISTEMPORARYCARE
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_6_ISALLERGY
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_7_CALLYOURHOUSE
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_8_2_CALLWORKINGTIME
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_8_CALLWORKINGTIME
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_COMPLETED
import llama.test.jetpack_dagger_plz.utils.Common.SIGNUPSCREEN_NAME

@AndroidEntryPoint
class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel :SignUpViewModel = hiltViewModel()
            NavHost(navController = navController, startDestination = SIGNUPSCREEN_NAME ){
                composable(SIGNUPSCREEN_NAME){
                    SignUpScreen_name(navController,viewModel)
                }

                composable(SIGNUPSCREEN_1_BIRTHDAY){
                    SignUpScreen_1_birthday(navController = navController,viewModel)
                }

                composable(SIGNUPSCREEN_2_GENDER){
                    SignUpScreen_2_gender(navController = navController, viewModel)
                }

                composable(SIGNUPSCREEN_3_JOB){
                    SignUpScreen_3_job(navController = navController, viewModel)
                }

                composable(SIGNUPSCREEN_4_1_ISWITHANIMAL){
                    SignUpScreen_4_1_iswithanimal(navController = navController,viewModel)
                }

                composable(SIGNUPSCREEN_4_2_CALLYOUTANIMAL){
                    SignUpScreen_4_2_CallYourAnimal(navController = navController,viewModel)
                }

                composable(SIGNUPSCREEN_4_3_CALLYOUTANIMAL_First){
                    SignUpScreen_4_3_CallYourAnimal_First(navController = navController,viewModel)
                }

                composable(SIGNUPSCREEN_4_3_CALLYOUTANIMAL_Second){
                    SignUpScreen_4_3_CallYourAnimal_Second(navController = navController,viewModel)
                }

                composable(SIGNUPSCREEN_4_3_CALLYOUTANIMAL_Third){
                    SignUpScreen_4_3_CallYourAnimal_Third(navController = navController,viewModel)
                }

                composable(SIGNUPSCREEN_5_ISTEMPORARYCARE){
                    SignUpScreen_5_istemporarycare(navController = navController,viewModel)
                }
                composable(SIGNUPSCREEN_6_ISALLERGY){
                    SignUpScreen_6_isallergy(navController = navController,viewModel)
                }

                composable(SIGNUPSCREEN_7_CALLYOURHOUSE){
                    SignUpScreen_7_callyourhouse(navController = navController,viewModel)
                }

                composable(SIGNUPSCREEN_8_CALLWORKINGTIME){
                    SignUpScreen_8_1_callworkingtime(navController = navController,viewModel)
                }

                composable(SIGNUPSCREEN_8_2_CALLWORKINGTIME){
                    SignUpScreen_8_2_callworkingtime(
                        navController = navController,
                        viewModel = viewModel
                    )
                }

                composable(SIGNUPSCREEN_COMPLETED){
                    SignUpScreen_completed(navController = navController,viewModel)
                }

            }
        }

    }
}