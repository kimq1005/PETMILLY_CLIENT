package com.llama.petmilly_client.presentation.homescreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.homescreen.items.CategoryItems
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.NaverMap
import com.naver.maps.map.compose.*
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun HomeScreen(navController: NavController) {

    val (search, setsearch) = rememberSaveable {
        mutableStateOf(" ")
    }
    val viewModel:HomeViewModel = viewModel()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)){

                OutlinedTextField(
                    value = search,
                    onValueChange =setsearch,
                    modifier = Modifier.fillMaxWidth()
                )

                Image(
                    painter = painterResource(id = R.drawable.baseline_search_24) ,
                    contentDescription = null,
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .padding(end = 5.dp)
                        .align(Alignment.CenterEnd)
                )
            }
            
            viewModel.setcategory()
//
//            LazyVerticalGrid(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                columns = GridCells.Fixed(4),
//              ){
//               items(viewModel.categorytest){ categorylist->
//                   Row{
//
//                       CategoryItems(categoryTest = categorylist ){
//                           Log.d(TAG, "HomeScreen: ${categorylist.title}")
//                       }
//
//                       Spacer(modifier = Modifier.width(5.dp))
//                   }
//
//               }
//            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ){
                viewModel.setcategory()

                items(viewModel.categorytest){ categorylist->
                    Row {
                        CategoryItems(categoryTest = categorylist) {
                            Log.d(TAG, "HomeScreen: ${categorylist.title}")
                        }

                    }


                }

            }

            NaverMapMan(modifier = Modifier)
        }

    }
}

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun NaverMapMan(modifier: Modifier){
    val seoul = LatLng(37.532600, 127.024612)
    val context = LocalContext.current
    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        // 카메라 초기 위치를 설정합니다.
        position = CameraPosition(seoul, 11.0)
    }

    Box(){
        NaverMap(
            cameraPositionState = cameraPositionState
        ){
            Marker(
                state = MarkerState(position = seoul)
            )
        }
    }

}



@Preview
@Composable
fun Test(){
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}