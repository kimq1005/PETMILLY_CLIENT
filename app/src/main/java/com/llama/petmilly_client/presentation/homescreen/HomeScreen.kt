package com.llama.petmilly_client.presentation.homescreen

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import com.llama.petmilly_client.presentation.TestMapViewScreen
import com.llama.petmilly_client.presentation.homescreen.items.CategoryItems
import com.llama.petmilly_client.presentation.shelterscreen.ShelterActivity
import com.llama.petmilly_client.ui.theme.Purple700
import com.llama.petmilly_client.ui.theme.Search_ButtonColor
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
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
        mutableStateOf("")
    }

    Box() {

        TestMapViewScreen(viewModel.wowman)

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
                    placeholder ={ Text(text = "성함을 입력해주세요. ") },
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


            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),

                ) {
                viewModel.setcategory()

                items(viewModel.categorytest) { categorylist ->

                    CategoryItems(categoryTest = categorylist, onClick = {
                        //여기서 api요청을 하고 마커를 다시 그려줘야함 근데 NaverItesmSet은 Composable 객체여서 불가능함
                    })

                }

            }
        }


    }

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

@Preview
@Composable
fun MAPSCREENPREVIEW() {
    HomeScreen()
}


private val POSITION = LatLng(37.5666102, 126.9783881)

