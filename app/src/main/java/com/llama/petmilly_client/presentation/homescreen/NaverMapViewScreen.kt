package com.llama.petmilly_client.presentation.homescreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.llama.petmilly_client.R
import com.llama.petmilly_client.data.model.LibraryDTO.Row
import com.llama.petmilly_client.presentation.shelterscreen.ShelterActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.compose.*
import com.naver.maps.map.overlay.Marker
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import ted.gun0912.clustering.clustering.TedClusterItem
import ted.gun0912.clustering.geometry.TedLatLng
import ted.gun0912.clustering.naver.TedNaverClustering

private var navermapyeah: NaverMap? = null
private var myMarker: Marker? = null
private var tedNaverClustering: TedNaverClustering<ClusterItem>? = null


@Composable
fun NaverMapViewScreen(list: List<Row>) {
    val map = naverMapComposable()
    val context = LocalContext.current

    Column(Modifier.fillMaxSize()) {
//        ButtonScreen(
//            title = "마커삭제",
//            textcolor = Color.Black,
//            fontSize = 15,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp),
//            backgroundcolor = Color.White
//        ) {
//
//            tedNaverClustering?.clearItems()
//        }
//
//        ButtonScreen(
//            title = "마커 생성",
//            textcolor = Color.Black,
//            fontSize = 15,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp),
//            backgroundcolor = Color.White
//        ) {
//
//            setcluestring(context, list)
//        }


        AndroidView(
            factory = { map },
            update = { mapview ->
                mapview.getMapAsync { navermap ->
                    navermapyeah = navermap
                    val seoul = LatLng(37.47153836, 127.096582)
                    val camPos = CameraPosition(
                        seoul,
                        13.0
                    )

                    navermapyeah?.cameraPosition = camPos
                    navermapyeah?.uiSettings?.isZoomControlEnabled = false
                    navermapyeah?.uiSettings?.isZoomGesturesEnabled = false

                    val items = mutableListOf<ClusterItem>()
                    for (i in list) {
                        val postion = LatLng(i.XCNTS.toDouble(), i.YDNTS.toDouble())
                        items.add(ClusterItem(postion, "asd", "asdasd"))
                    }

                    tedNaverClustering =
                        TedNaverClustering.with<ClusterItem>(context = context, navermapyeah!!)
                            .items(items)
                            .markerClickListener {

                            }
                            .clusterClickListener {
                                Log.d(TAG, "NaverMapViewScreen: ${it.position}")
                                it.position
                            }
                            .customCluster {
                                val clusterDesginText = ClusterDesginText()
                                if (it.size >= 25) {
                                    clusterDesginText.cluster25(context, it.size, "월계2동")
                                } else if (it.size >= 20) {
                                    clusterDesginText.cluster20(context, it.size, "월계2동")
                                } else if (it.size >= 15) {
                                    clusterDesginText.cluster15(context, it.size, "월계2동")
                                } else if (it.size >= 10) {
                                    clusterDesginText.cluster10(context, it.size, "월계2동")
                                } else {
                                    clusterDesginText.cluster5(context, it.size, "월계2동")
                                }
//                                clusterDesginTextView(context, it.size)
                            }
                            .minClusterSize(1)
//                            .clusterBuckets(IntArray(20))

                            .clusterAnimation(animate = true)
                            .make()

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
                    else -> {

                    }
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


fun clusterDesginTextView(context: Context, size: Int): TextView {
    return TextView(context).apply {
        this.background =
            ContextCompat.getDrawable(context, R.drawable.background_clustering_20_oval)
        this.textSize = 30F
        this.width = 400
        this.height = 400
        this.gravity = Gravity.CENTER
        setTextColor(ContextCompat.getColor(context, R.color.black))
        text = size.toString()
    }
}


class ClusterDesginText() {
    fun cluster25(context: Context, size: Int, location: String): TextView {
        return TextView(context).apply {
            this.background =
                ContextCompat.getDrawable(context, R.drawable.background_clustering_25_oval)

            this.textSize = 30F
            this.width = 1200
            this.height = 1200
            this.gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.black))
            text = "${location}\n${size}"
        }
    }

    fun cluster20(context: Context, size: Int, location: String): TextView {
        return TextView(context).apply {
            this.background =
                ContextCompat.getDrawable(context, R.drawable.background_clustering_20_oval)
            this.textSize = 30F
            this.width = 1000
            this.height = 1000
            this.gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.black))
            text = "${location}\n${size}"
        }
    }


    fun cluster15(context: Context, size: Int, location: String): TextView {
        return TextView(context).apply {
            this.background =
                ContextCompat.getDrawable(context, R.drawable.background_clustering_15_oval)
            this.textSize = 30F
            this.width = 800
            this.height = 800
            this.gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.black))
            text = "${location}\n${size}"
        }
    }


    fun cluster10(context: Context, size: Int, location: String): TextView {
        return TextView(context).apply {
            this.background =
                ContextCompat.getDrawable(context, R.drawable.background_clustering_10_oval)
            this.textSize = 30F
            this.width = 700
            this.height = 700
            this.gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.black))
            text = "${location}\n${size}"
        }
    }


    fun cluster5(context: Context, size: Int, location: String): TextView {
        return TextView(context).apply {
            this.background =
                ContextCompat.getDrawable(context, R.drawable.background_clustering_5_oval)
            this.textSize = 30F
            this.width = 500
            this.height = 500
            this.gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, R.color.black))
            text = "${location}\n${size}"
        }
    }
}


fun cluster5(context: Context, text1: Int, text2: String): TextView {
    return TextView(context).apply {
        this.background =
            ContextCompat.getDrawable(context, R.drawable.background_clustering_5_oval)
        this.width = 500
        this.height = 500
        this.gravity = Gravity.CENTER
        setTextColor(ContextCompat.getColor(context, R.color.black))

        val textView1 = TextView(context).apply {
            this.textSize = 20F
            text = "${text1}"
        }
        val textView2 = TextView(context).apply {
            this.textSize = 50F
            text = "${text2}"
        }


    }
}





//    TextView(context).apply {
//        setBackgroundColor(
//            ContextCompat.getColor(
//                context,
//                R.color.teal_700
//            )
//        )
//        setTextColor(ContextCompat.getColor(context, R.color.black))
//        text = "${it.size}개"
//        if (it.size > 10) setPadding(50, 50, 50, 50) else setPadding(
//            10,
//            10,
//            10,
//            10
//        )
//    }


fun setcluestring(context: Context, list: List<Row>): TedNaverClustering<ClusterItem>? {
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
        .customCluster {

            TextView(context).apply {
                setBackgroundColor(ContextCompat.getColor(context, R.color.teal_700))
                setTextColor(ContextCompat.getColor(context, R.color.black))
                text = "${it.size}개"
                setPadding(20, 20, 20, 20)
            }
        }
        .clusterAnimation(animate = false)
        .make()
    return tedNaverClustering
}


@Composable
private fun NaverItemsSet(list: List<Row>) {
    Log.d(TAG, "NaverItemsSet: $list")
    val items = remember { mutableStateListOf<ClusterItem>() }
    LaunchedEffect(Unit) {
        for (i in list) {
            val postion = LatLng(i.XCNTS.toDouble(), i.YDNTS.toDouble())
            items.add(ClusterItem(postion, "asdasd", "Asdasdsad"))
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
        cameraPositionState = cameraPositionState,
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

