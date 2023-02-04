package com.llama.petmilly_client.presentation

import android.content.Context
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.llama.petmilly_client.data.model.LibraryDTO.Row
import com.llama.petmilly_client.presentation.homescreen.ClusterItem
import com.llama.petmilly_client.presentation.homescreen.HomeViewModel
import com.llama.petmilly_client.utils.ButtonScreen
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapOptions
import com.naver.maps.map.compose.Marker
import com.naver.maps.map.compose.NaverMapComposable
import com.naver.maps.map.overlay.Marker
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import ted.gun0912.clustering.naver.TedNaverClustering

private var navermapyeah: NaverMap? = null
private var myMarker: Marker? = null
private var tedNaverClustering: TedNaverClustering<ClusterItem>? = null


@Composable
fun TestMapViewScreen(list: List<Row>) {
    val map = naverMapComposable()
    val context = LocalContext.current

    Column(Modifier.fillMaxSize()) {
        ButtonScreen(
            title = "마커삭제",
            textcolor = Color.Black,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            backgroundcolor = Color.White
        ) {

            tedNaverClustering?.clearItems()
        }

        ButtonScreen(
            title = "마커 생성",
            textcolor = Color.Black,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            backgroundcolor = Color.White
        ) {

            setcluestring(context, list)
        }



        AndroidView(
            factory = { map },
            update = { mapview ->
                mapview.getMapAsync { navermap ->
                    navermapyeah = navermap
                    val seoul = LatLng(37.5666805, 126.9784147)
                    val camPos = CameraPosition(
                        seoul,
                        9.0
                    )

                    navermapyeah?.cameraPosition = camPos

//                    val items = mutableListOf<ClusterItem>()
//                    for(i in list){
//                        val postion = LatLng(i.XCNTS.toDouble(), i.YDNTS.toDouble())
//                        items.add(ClusterItem(postion,"asd","asdasd"))
//                    }
//
//                    tedNaverClustering = TedNaverClustering.with<ClusterItem>(context = context, navermapyeah!!)
//                        .items(items)
//                        .markerClickListener {
//
//                        }
//                        .clusterClickListener {
//
//                        }
//                        .make()

                }
            }
        )
    }
}

@Composable
fun naverMapComposable(): MapView {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val coroutineScope = rememberCoroutineScope()

    val mapView = remember {
        MapView(context)
    }

    val lifecycleObserver = remember {
        LifecycleEventObserver { source, event ->
            // CoroutineScope 안에서 호출해야 정상적으로 동작합니다.
            coroutineScope.launch {
                when (event) {
                    Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
                    Lifecycle.Event.ON_START -> mapView.onStart()
                    Lifecycle.Event.ON_RESUME -> mapView.onResume()
                    Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                    Lifecycle.Event.ON_STOP -> mapView.onStop()
                    Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
                }
            }
        }
    }

    DisposableEffect(true) {
        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
        }
    }
    return mapView
}

fun setcluestring(context:Context, list: List<Row>): TedNaverClustering<ClusterItem>?{
    val items = mutableListOf<ClusterItem>()
    for (i in list) {
        val postion = LatLng(i.XCNTS.toDouble(), i.YDNTS.toDouble())
        items.add(ClusterItem(postion, "asd", "asdasd"))
    }
    tedNaverClustering = TedNaverClustering.with<ClusterItem>(context = context, navermapyeah!!)
        .items(items)
        .markerClickListener {

        }
        .clusterClickListener {

        }
        .clusterAnimation(false)
        .make()
    return tedNaverClustering
}

