package com.llama.petmilly_client.presentation.homescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.presentation.homescreen.HomeScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            Scaffold(bottomBar = {
                BottomNavigation(navController =navController)
            }) {
             NavigationGraph(navController = navController)   
            }
//            HomeScreen(navController)
        }
    }
}

@Composable
fun Test(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "HEllo")
    }
}
