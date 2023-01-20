package com.llama.petmilly_client.presentation.homescreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.data.model.LibraryDTO.Row
import com.llama.petmilly_client.presentation.MainViewModel
import com.llama.petmilly_client.presentation.homescreen.items.CategoryItems
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.NaverMap
import com.naver.maps.map.compose.*
import com.naver.maps.map.overlay.Marker
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import ted.gun0912.clustering.clustering.TedClusterItem
import ted.gun0912.clustering.geometry.TedLatLng
import ted.gun0912.clustering.naver.TedNaverClustering
import java.util.Random

private val naverMap: NaverMap? = null

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {

    val (search, setsearch) = rememberSaveable {
        mutableStateOf(" ")
    }

    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {

                OutlinedTextField(
                    value = search,
                    onValueChange = setsearch,
                    modifier = Modifier.fillMaxWidth()
                )

                Image(
                    painter = painterResource(id = R.drawable.baseline_search_24),
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
            ) {
                viewModel.setcategory()

                items(viewModel.categorytest) { categorylist ->
                    Row {
                        CategoryItems(categoryTest = categorylist) {
                            Log.d(TAG, "HomeScreen: ${categorylist.title}")
                        }

                    }


                }

            }

//            Test(viewModel)
            NaverItemsSet(viewModel)
//            MapClustering(viewModel.items)
//            NaverMapMan(viewModel)
        }

    }
}

@Composable
fun Test(viewModel: HomeViewModel){
    viewModel.getlibrary()

}

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun NaverMapMan(viewModel: HomeViewModel) {
    val seoul = LatLng(37.532600, 127.024612)
    val context = LocalContext.current
    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        // 카메라 초기 위치를 설정합니다.
        position = CameraPosition(seoul, 11.0)
    }


    Box() {
        NaverMap(
            cameraPositionState = cameraPositionState
        ) {
            val list2 = viewModel.yeahman.observeAsState().value

            if(list2 !=null){
                for (i in list2) {
                    val postion = LatLng(i.XCNTS.toDouble(), i.YDNTS.toDouble())
                    Marker(
                        state = MarkerState(position = postion)
                    )
                }
            }


        }
    }

}

@Composable
private fun NaverItemsSet(viewModel: HomeViewModel) {
    viewModel.getlibrary()
    val items = remember { mutableStateListOf<ClusterItem>() }
    LaunchedEffect(Unit) {
        val list2 = viewModel.yeahman.value
        if (list2 != null) {
            for (i in list2) {
                val postion = LatLng(i.XCNTS.toDouble(), i.YDNTS.toDouble())
                items.add(ClusterItem(postion, "asdasd", "Asdasdsad"))
            }
        }
    }
    MapClustering(items = items)
}

@OptIn(ExperimentalNaverMapApi::class)
@Composable
private fun MapClustering(items: List<ClusterItem>) {
    val seoul = LatLng(37.532600, 127.024612)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition(seoul, 10.0)
    }

    NaverMap(
        cameraPositionState = cameraPositionState
    ) {
        val context = LocalContext.current
        var clusterManager by remember { mutableStateOf<TedNaverClustering<ClusterItem>?>(null) }
        DisposableMapEffect(items) { map ->
            if (clusterManager == null) {
                clusterManager = TedNaverClustering.with<ClusterItem>(context, map)
                    .make()
            }
            clusterManager?.addItems(items)
            onDispose {
                clusterManager?.clearItems()
            }

        }
    }
}

data class ClusterItem(
    val itemPostion: LatLng,
    val itemTitle: String,
    val itemSnippet: String,
) : TedClusterItem {
    override fun getTedLatLng(): TedLatLng {
        return TedLatLng(
            latitude = itemPostion.latitude,
            longitude = itemPostion.longitude
        )
    }

}

private val POSITION = LatLng(37.5666102, 126.9783881)

