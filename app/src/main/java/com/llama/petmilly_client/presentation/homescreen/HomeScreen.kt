package com.llama.petmilly_client.presentation.homescreen

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.data.model.LibraryDTO.Row
import com.llama.petmilly_client.presentation.MainViewModel
import com.llama.petmilly_client.presentation.homescreen.items.CategoryItems
import com.llama.petmilly_client.presentation.shelterscreen.ShelterActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.NaverMap
import com.naver.maps.map.compose.*
import com.naver.maps.map.overlay.Marker
import llama.test.jetpack_dagger_plz.utils.Common.SAFESHELTER_COMPOSABLE
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import ted.gun0912.clustering.clustering.TedClusterItem
import ted.gun0912.clustering.geometry.TedLatLng
import ted.gun0912.clustering.naver.TedNaverClustering
import java.util.Random
import javax.inject.Inject

private val naverMap: NaverMap? = null

@Composable
//fun HomeScreen(viewModel: HomeViewModel = hiltViewModel())
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val context = LocalContext.current
    viewModel.getlibrary()

    val (search, setsearch) = rememberSaveable {
        mutableStateOf(" ")
    }

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

        val listState = rememberLazyListState()
        var selectedBoolean by remember {
            mutableStateOf(false)
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),

        ) {
            viewModel.setcategory()

            items(viewModel.categorytest) { categorylist ->
//                Row {
//                    Text(
//                        text = categorylist.title,
//                        modifier = Modifier
//                            .background(
//                                if (selectedBoolean) Color.Blue else Color.Red
//                            )
//                            .selectable(selected = selectedBoolean,
//                                onClick = {
//                                    selectedBoolean = !selectedBoolean
//                                    Log.d(TAG, "HomeScreen: $selectedBoolean, ${categorylist.title}")
//                                })
//                    )
//
//                    Spacer(modifier = Modifier.width(10.dp))
//
//                }

                CategoryItems(categoryTest = categorylist){

                }

            }

        }

        NaverItemsSet(viewModel.wowman)
    }

}

@Composable
private fun NaverItemsSet(list: List<Row>) {
    Log.d(TAG, "NaverItemsSet: $list")
    val items = remember { mutableStateListOf<ClusterItem>() }
    LaunchedEffect(Unit) {
        if (list != null) {
            for (i in list) {
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
                    .markerClickListener { marker ->

                        val intent = Intent(context, ShelterActivity::class.java)
                        context.startActivity(intent)
                        marker.itemTitle
                    }
                    .clusterClickListener { cluster ->

                        val totalclusteritems = cluster.items //클러스터링 전체의 아이템
                        val clusterposition = cluster.position //클러스터링의 포지션

                        Log.d(TAG, "MapClustering: $totalclusteritems")
//                        val intent = Intent(context, ShelterActivity::class.java).apply {
//                            putExtra(SAFESHELTER_COMPOSABLE, SAFESHELTER_COMPOSABLE)
//                        }
//                        context.startActivity(intent)


                    }
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

@Preview
@Composable
fun MAPSCREENPREVIEW() {
    HomeScreen()
}


private val POSITION = LatLng(37.5666102, 126.9783881)

