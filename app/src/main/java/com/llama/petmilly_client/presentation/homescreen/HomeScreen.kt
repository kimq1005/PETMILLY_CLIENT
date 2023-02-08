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
//    val viewModel: HomeViewModel = hiltViewModel()
    val context = LocalContext.current
//    viewModel.getlibrary()

    val (search, setsearch) = rememberSaveable {
        mutableStateOf("")
    }



    NaverMapViewScreen()

//        Column(modifier = Modifier.padding(top = 30.dp)) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
//            ) {
//                TextField(
//                    value = search,
//                    onValueChange = setsearch,
//                    modifier = Modifier
//                        .weight(8f)
//                        .height(55.dp),
//                    shape = RoundedCornerShape(10.dp),
//                    colors = TextFieldDefaults.textFieldColors(
//                        backgroundColor = TextField_BackgroudColor,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        focusedLabelColor = Color.White,
//                        cursorColor = Color.Black,
//                    ),
//                    placeholder = { Text(text = "정보를 검색하세요.") },
//                )
//
//                Spacer(modifier = Modifier.width(5.dp))
//
//                Button(
//                    onClick = { },
//                    modifier = Modifier
//                        .weight(1.5f)
//                        .width(55.dp)
//                        .height(55.dp),
//                    colors = ButtonDefaults.buttonColors(backgroundColor = Search_ButtonColor),
//                    shape = RoundedCornerShape(10.dp)
//
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.icon_search),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .width(16.dp)
//                            .height(16.dp)
//                    )
//                }
//            }
//            viewModel.setcategory()
//
//            if (viewModel.categorytest.size > 5) {
//                LazyRow(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 60.dp, top = 10.dp)
//                ) {
//                    items(viewModel.categorytest.subList(0, 3)) { item ->
//                        CategoryItems(categoryTest = item) {
//                            viewModel.testint()
//                        }
//
//                        Spacer(modifier = Modifier.width(8.dp))
//
//                    }
//                }
//
//                LazyRow(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 16.dp, top = 10.dp)
//                ) {
//                    items(
//                        viewModel.categorytest.subList(
//                            3,
//                            viewModel.categorytest.lastIndex
//                        )
//                    ) { item ->
//                        CategoryItems(categoryTest = item) {
//                            viewModel.testint()
//                        }
//                        Spacer(modifier = Modifier.width(8.dp))
//
//                    }
//                }
//            } else {
//                LazyRow(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(12.dp),
//
//                    ) {
//                    viewModel.setcategory()
//
//                    items(viewModel.categorytest) { categorylist ->
//
//                        CategoryItems(categoryTest = categorylist, onClick = {
//                            //여기서 api요청을 하고 마커를 다시 그려줘야함 근데 NaverItesmSet은 Composable 객체여서 불가능함
//                        })
//
//                    }
//                }
//            }
//
//
////
//
//        }


}

@Preview
@Composable
fun MAPSCREENPREVIEW() {
    HomeScreen()
}



