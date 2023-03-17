package com.llama.petmilly_client.presentation.homescreen

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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

    NaverMapViewScreen()


}

@Preview
@Composable
fun MAPSCREENPREVIEW() {
    HomeScreen()
}



