package com.llama.petmilly_client.presentation.mapscreen

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.google.android.gms.location.LocationRequest
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.naver.maps.map.NaverMap
import com.naver.maps.map.compose.*
import com.naver.maps.map.util.FusedLocationSource

@ExperimentalNaverMapApi
@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun LocationauthenticationScreen() {
    NaverMap(
        locationSource = rememberFusedLocationSource(),
        properties = MapProperties(
            locationTrackingMode = LocationTrackingMode.Follow
        ),
        uiSettings = MapUiSettings(
            isLocationButtonEnabled = true,
        )
    )
}

@ExperimentalNaverMapApi
@OptIn(ExperimentalNaverMapApi::class)
@Preview()
@Composable
fun Plz(){
    LocationauthenticationScreen()
}

@SuppressLint("VisibleForTests")
fun setUpdateLocationListener(){
    val locationRequest = LocationRequest.create()
    locationRequest.run {
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        interval=1000
    }


}