package com.llama.petmilly_client.presentation.homescreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.chatscreen.ChatEntityScreen
import com.llama.petmilly_client.presentation.chatscreen.ChatScreen
import com.llama.petmilly_client.presentation.favoritescreen.FavoriteScreen
import com.llama.petmilly_client.presentation.myprofilescreen.MyProfileScreen
import com.llama.petmilly_client.presentation.notificationscreen.NotificationScreen
import com.llama.petmilly_client.ui.theme.Category_Cliked
import llama.test.jetpack_dagger_plz.utils.Common.TAG

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
    object Home : BottomNavItem("펫밀리", R.drawable.img_petmilly_home_2, "home")
    object Chatting : BottomNavItem("채팅", R.drawable.img_petmilly_chatting, "my_network")
    object Heart : BottomNavItem("관심", R.drawable.img_petmilly_heart_menu_2, "add_post")
    object Notification : BottomNavItem("알림", R.drawable.img_petmilly_notification, "notification")
    object Person : BottomNavItem("MY", R.drawable.img_petmilly_person, "my")
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }

        composable(BottomNavItem.Chatting.screen_route) {
            ChatEntityScreen()

        }
        composable(BottomNavItem.Heart.screen_route) {
            FavoriteScreen(navController = navController)
        }

        composable(BottomNavItem.Notification.screen_route) {
            NotificationScreen(navController = navController)
        }
        composable(BottomNavItem.Person.screen_route) {
            MyProfileScreen(navController = navController)
        }


    }

}


@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Chatting,
        BottomNavItem.Heart,
        BottomNavItem.Notification,
        BottomNavItem.Person
    )

    androidx.compose.material.BottomNavigation(
        contentColor = Color.Black,
        backgroundColor = Color.White,
        modifier = Modifier
        ,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(

                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Category_Cliked,
                unselectedContentColor = Color.Black.copy(0.3f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}