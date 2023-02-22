package com.llama.petmilly_client.presentation.shelterscreen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.utils.notosans_bold
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common.ANIMALINFO_DETAIL
import llama.test.jetpack_dagger_plz.utils.Common.SAFESHELTER_COMPOSABLE
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@AndroidEntryPoint
class ShelterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                val navController = rememberNavController()
                Column {

                    TitleBar(
                        title = "임보처 구해요",
                        ismenu = false,
                        clickBack = {
                            val SafeShelterListScreen =
                                navController.currentBackStackEntry?.destination?.route
                            if (SafeShelterListScreen == SAFESHELTER_COMPOSABLE) {
                                finish()
                            } else {
                                navController.popBackStack(
                                    route = SAFESHELTER_COMPOSABLE,
                                    inclusive = false
                                )
                            }
                        }) {

                    }

//                    val route = intent.getStringExtra(SAFESHELTER_COMPOSABLE).toString()
                    NavHost(
                        navController = navController,
                        startDestination = SAFESHELTER_COMPOSABLE
                    ) {
                        composable(route = SAFESHELTER_COMPOSABLE) {
                            SafeShelterListScreen(navController = navController)
                        }

                        composable(ANIMALINFO_DETAIL) {
                            AnimalInfoDetailScreen(navController = navController)
                        }
                    }
                }


            }
        }
    }
}


@Composable
fun TitleBar(
    title: String,
    ismenu: Boolean,
    clickBack: () -> Unit,
    clickMenu: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp),
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .align(Alignment.CenterStart)
                .clickable {
                    clickBack()
                }
        )

        Text(
            text = title,
            fontSize = 17.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center),
        )

        AnimatedVisibility(visible = ismenu, modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)

                    .clickable {
                        clickMenu()
                    },

                )
        }


    }
}