package com.llama.petmilly_client.presentation.certificationscreen

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.*
import com.google.android.gms.maps.MapsInitializer
import com.llama.petmilly_client.presentation.homescreen.naverMapComposable
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.SpacerHeight
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.NaverMap
import com.naver.maps.map.compose.*
import com.naver.maps.map.overlay.Marker
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.LOCATION_AUTHENTICATION_SCREEN
import llama.test.jetpack_dagger_plz.utils.Common.PERSONALINFOSCREEN
import llama.test.jetpack_dagger_plz.utils.Common.TAG

private var mynavermap: NaverMap? = null


@OptIn(ExperimentalNaverMapApi::class)
@AndroidEntryPoint
class CertificationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface() {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = LOCATION_AUTHENTICATION_SCREEN
                ) {
                    composable(route = LOCATION_AUTHENTICATION_SCREEN) {
                        LocationauthenticationScreen(navController)
                    }
                }
            }


        }
    }
}


@ExperimentalNaverMapApi
@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun LocationauthenticationScreen(navController: NavController) {
    val context = LocalContext.current
    Column(Modifier.fillMaxSize()) {
        TitleBar(
            title = "동네 인증",
            ismenu = false,
            clickBack = { },
            clickMenu = {})
//
        Box(
            modifier = Modifier
                .weight(15f)
                .padding(top = 10.dp)
        ) {
//            NaverMap(
//                locationSource = rememberFusedLocationSource(),
//                properties = MapProperties(
//                    locationTrackingMode = LocationTrackingMode.Follow
//                ),
//                uiSettings = MapUiSettings(
//                    isLocationButtonEnabled = true,
//                ),
//            ) {
//                Marker(
//                    onClick = { it ->
//                        true
//                    })
//            }
            CertificationNaverMap2()
        }

        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "동네인증완료",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(horizontal = 50.dp),
            backgroundcolor = Color.Black

        ) {

        }

        SpacerHeight(dp = 100.dp)
    }

}


@OptIn(ExperimentalNaverMapApi::class)
@Preview
@Composable
fun FSDF() {
    val navController = rememberNavController()
    LocationauthenticationScreen(navController)
}


@SuppressLint("MissingPermission")
@Composable
fun CertificationNaverMap() {
    val map = naverMapComposable()
    val context = LocalContext.current
    val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
    Box {
        Log.d(TAG, "CertificationNaverMap: fdsfdsf")
        AndroidView(
            factory = { map },
            update = { mapview ->
                mapview.getMapAsync { navermap ->
                    mynavermap  = navermap


                }
            }

        )
    }
}

@Composable
fun CertificationNaverMap2() {
    val map = naverMapComposable()
    val context = LocalContext.current
    val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
    Box {
        AndroidView(
            factory = { map },
            update = { mapview ->
                mapview.getMapAsync { navermap ->
                    mynavermap = navermap
                    val marker = Marker()


                    // 위치 정보 권한 요청
                    val permissionRequestCode = 123
                    if (ActivityCompat.checkSelfPermission(
                            context,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(
                            context as Activity,
                            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                            permissionRequestCode
                        )
                    } else {
                        // 위치 정보 권한이 허용되었을 때 처리
                        fusedLocationProviderClient.lastLocation
                            .addOnSuccessListener { location ->
                                // 위치 정보를 성공적으로 받아왔을 때 처리
                                Log.d(TAG, "CertificationNaverMap2: ${location.latitude}")
                                val mypostion = LatLng(location.latitude, location.longitude)
                                marker.position =mypostion
                                marker.map = navermap
                                val cameraUpdate = CameraUpdate.scrollTo(mypostion)
                                navermap.moveCamera(cameraUpdate)
                            }
                            .addOnFailureListener { exception ->
                                // 위치 정보를 받아오는 데 실패한 경우 처리
                                Log.d(TAG, "CertificationNaverMap2: ERROR")
                                // ...
                            }
                    }
                }
            }
        )
    }
}


// 위치권한 관련 요청



