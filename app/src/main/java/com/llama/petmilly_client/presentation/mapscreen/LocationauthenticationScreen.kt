package com.llama.petmilly_client.presentation.mapscreen

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.LocationRequest
import com.llama.petmilly_client.presentation.certificationscreen.CertificationActivity
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.utils.ButtonScreen
import com.naver.maps.map.NaverMap
import com.naver.maps.map.compose.*
import com.naver.maps.map.util.FusedLocationSource



//없는거야 여기는 삭제해 삭제 ㅇㅋ?

//@ExperimentalNaverMapApi
//@OptIn(ExperimentalNaverMapApi::class)
//@Composable
//fun LocationauthenticationScreen(navController: NavController) {
//
//    val context = LocalContext.current
//    Column(Modifier.fillMaxSize()) {
//        TitleBar(
//            title = "동네 인증",
//            ismenu = false,
//            clickBack = { navController.popBackStack() },
//            clickMenu = {})
////
//        Box(modifier = Modifier.weight(15f).padding(top = 10.dp)){
//            NaverMap(
//                locationSource = rememberFusedLocationSource(),
//                properties = MapProperties(
//                    locationTrackingMode = LocationTrackingMode.Follow
//                ),
//                uiSettings = MapUiSettings(
//                    isLocationButtonEnabled = true,
//                ),
//            ){
//                Marker(
//                    onClick = {it->
//                        true
//                    })
//            }
//        }
//
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        ButtonScreen(
//            title = "수정하기",
//            modifier = Modifier.fillMaxWidth().padding(16.dp),
//            backgroundcolor = Button_Clicked,
//            fontSize = 16,
//            textcolor = Color.White,
//            onclick = {
//                Toast.makeText(context,"wow",Toast.LENGTH_SHORT).show()
//                val intent= Intent(/* packageContext = */ context, /* cls = */
//                    CertificationActivity::class.java)
//                context.startActivity(intent)
//            }
//        )
//    }
//
//
//
//}
//
//@ExperimentalNaverMapApi
//@OptIn(ExperimentalNaverMapApi::class)
//@Preview()
//@Composable
//fun Plz() {
//    val navController = rememberNavController()
//    LocationauthenticationScreen(navController)
//}
