package com.llama.petmilly_client.presentation.homescreen

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.llama.petmilly_client.R
import com.llama.petmilly_client.data.model.LibraryDTO.Row
import com.llama.petmilly_client.presentation.adoptionscreen.AdoptionActivity
import com.llama.petmilly_client.presentation.findanimalscreen.FindAnimalActivity
import com.llama.petmilly_client.presentation.homescreen.items.CategoryItems
import com.llama.petmilly_client.presentation.moveservicscreen.MoveServiceActivity
import com.llama.petmilly_client.presentation.shelterscreen.ShelterActivity
import com.llama.petmilly_client.ui.theme.Search_ButtonColor
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
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

private lateinit var progressDialog: ProgressDialog

@Composable
fun NaverMapViewScreen(viewModel: HomeViewModel = hiltViewModel()) {


    val map = naverMapComposable()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val (search, setsearch) = rememberSaveable {
        mutableStateOf("")
    }

    var checkBoolean by remember {
        mutableStateOf(false)
    }


    progressDialog = ProgressDialog(context, R.style.ProgressBarDialog)
    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
    progressDialog.setCanceledOnTouchOutside(false)
    progressDialog.setCancelable(false)



    Box() {
        AndroidView(
            factory = { map },
            update = { mapview ->
                mapview.getMapAsync { navermap ->
                    navermapyeah = navermap
                    val seoul = LatLng(37.47153836, 127.096582)
                    val camPos = CameraPosition(
                        seoul,
                        20.0
                    )

                    navermapyeah?.cameraPosition = camPos
                    navermapyeah?.uiSettings?.isZoomControlEnabled = false
                    navermapyeah?.uiSettings?.isZoomGesturesEnabled = false

                    setcluestring(context, viewModel.wowman, viewModel)
                }
            }
        )

        //여기에 내가 풀리퀘스트 한다
        //1월 16일 풀리퀘스트 테스트


        Column(modifier = Modifier.padding(top = 30.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {
                TextField(
                    value = search,
                    onValueChange = setsearch,
                    modifier = Modifier
                        .weight(8f)
                        .height(55.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = TextField_BackgroudColor,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color.White,
                        cursorColor = Color.Black,
                    ),
                    placeholder = { Text(text = "정보를 검색해보세요.") },
                )

                Spacer(modifier = Modifier.width(5.dp))

                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(1.5f)
                        .width(55.dp)
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Search_ButtonColor),
                    shape = RoundedCornerShape(10.dp)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_search),
                        contentDescription = null,
                        modifier = Modifier
                            .width(16.dp)
                            .height(16.dp)
                    )
                }
            }
            viewModel.setcategory()

            if (viewModel.categorytest.size > 5) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 10.dp)
                ) {
                    items(viewModel.categorytest.subList(0, 3)) { item ->
                        CategoryItems(categoryTest = item, selected = checkBoolean) {
//                           viewModel.checklibrary()
                            tedNaverClustering?.clearItems()
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                    }
                }

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 10.dp)
                ) {
                    items(
                        viewModel.categorytest.subList(
                            3,
                            viewModel.categorytest.lastIndex
                        )
                    ) { item ->
                        CategoryItems(categoryTest = item, selected = viewModel.selelctedcategory.value==item.title) {
                            viewModel.selelctedcategory.value = ""
                            viewModel.getlibrary()
                            viewModel.selelctedcategory.value = item.title
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                                //커밋테스트
                    }
                    //
                    //
                }
            } else {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    ) {
                    viewModel.setcategory()

                    items(viewModel.categorytest) { categorylist ->

                        CategoryItems(categoryTest = categorylist, selected = checkBoolean,onClick = {
                            //여기서 api요청을 하고 마커를 다시 그려줘야함 근데 NaverItesmSet은 Composable 객체여서 불가능함
                        })

                    }
                }
            }
        }

    }

    LaunchedEffect(context){
        setObserve(viewModel, context, lifecycleOwner)
    }


}
//
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


private fun setObserve(viewModel: HomeViewModel, context: Context, lifecycleOwner: LifecycleOwner) {

    viewModel.showProgress.observe(lifecycleOwner, Observer {
        progressDialog.show()
    })

    viewModel.closeProgress.observe(lifecycleOwner, Observer {
        progressDialog.dismiss()
    })

    viewModel.setEvent.observe(lifecycleOwner, Observer {
        setcluestring(context, viewModel.wowman, viewModel)

        //맵을 움직여야 클러스터링 결과가 호출이 돼서 해놓은 포지션
        val seoul = LatLng(37.47153836, 127.096582)
        val camPos = CameraPosition(
            seoul,
            9.0
        )
        navermapyeah?.moveCamera(CameraUpdate.toCameraPosition(camPos))

    })


}


fun setcluestring(
    context: Context,
    list: List<Row>,
    viewModel: HomeViewModel,
): TedNaverClustering<ClusterItem>? {

    tedNaverClustering?.clearItems()


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
            val categorytitle = viewModel.selelctedcategory.value
            when(categorytitle) {

                "임보처구해요" -> {
                    val intent = Intent(context, ShelterActivity::class.java)
                    context.startActivity(intent)
                }

                "우리아이 찾아요" -> {
                    val intent = Intent(context, FindAnimalActivity::class.java)
                    context.startActivity(intent)
                }

                "이동봉사 찾아요" -> {
                    val intent = Intent(context, MoveServiceActivity::class.java)
                    context.startActivity(intent)
                }

                "입양 공고" -> {
                    val intent = Intent(context, AdoptionActivity::class.java)
                    context.startActivity(intent)
                }

                else ->{
                    Toast.makeText(context, "카테고리를 선택해주세요",Toast.LENGTH_SHORT).show()
                }


            }

        }
        .customCluster {
            val clusterDesginText = ClusterDesginText()
            if (it.size >= 25) {
                clusterDesginText.cluster25(context, it.size, "매탄동")
            } else if (it.size >= 20) {
                clusterDesginText.cluster20(context, it.size, "원천동")
            } else if (it.size >= 15) {
                clusterDesginText.cluster15(context, it.size, "망포동")
            } else if (it.size >= 5) {
                clusterDesginText.cluster10(context, it.size, "인계동")
            } else {
                clusterDesginText.cluster5(context, it.size, "월계2동")
            }
//                                clusterDesginTextView(context, it.size)
        }
        .minClusterSize(0)
//                            .clusterBuckets(IntArray(20))
        .clusterAnimation(animate = true)
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
            val spannable = SpannableString("$location\n$size")
            val boldSpan = StyleSpan(Typeface.BOLD)
            spannable.setSpan(
                boldSpan,
                location.length + 1,
                location.length + 1 + size.toString().length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            text = spannable
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
            val spannable = SpannableString("$location\n$size")
            val boldSpan = StyleSpan(Typeface.BOLD)
            spannable.setSpan(
                boldSpan,
                location.length + 1,
                location.length + 1 + size.toString().length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            text = spannable
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
            val spannable = SpannableString("$location\n$size")
            val boldSpan = StyleSpan(Typeface.BOLD)
            spannable.setSpan(
                boldSpan,
                location.length + 1,
                location.length + 1 + size.toString().length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            text = spannable
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
            val spannable = SpannableString("$location\n$size")
            val boldSpan = StyleSpan(Typeface.BOLD)
            spannable.setSpan(
                boldSpan,
                location.length + 1,
                location.length + 1 + size.toString().length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            text = spannable
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
//            text = "${location}\n${size}"

            val spannable = SpannableString("$location\n$size")
            val boldSpan = StyleSpan(Typeface.BOLD)
            spannable.setSpan(
                boldSpan,
                location.length + 1,
                location.length + 1 + size.toString().length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            text = spannable
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
        this.setTypeface(null, Typeface.BOLD)
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

