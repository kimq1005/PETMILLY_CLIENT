package com.llama.petmilly_client.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.presentation.homescreen.HomeScreen
import com.llama.petmilly_client.presentation.loginscreen.LoginScreen
import com.llama.petmilly_client.ui.theme.PET_MILLY_CLIENTTheme
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common.HOMESCREEN
import llama.test.jetpack_dagger_plz.utils.Common.LOGINSCREEN
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = LOGINSCREEN){
                composable(route = LOGINSCREEN){
                    LoginScreen(navController)
                }

                composable(route = HOMESCREEN){
                    HomeScreen(navController)
                }
            }
        }
    }
}

@Composable
fun TestScreen(viewModel: MainViewModel= hiltViewModel()){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {  viewModel.testapi() }) {
            Text(text = "눌러눌러")
        }
    }

}