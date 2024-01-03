package com.llama.petmilly_client.presentation.certificationscreen

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.*
import com.google.android.gms.maps.MapsInitializer
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.MainViewModel
import com.llama.petmilly_client.presentation.homescreen.HomeActivity
import com.llama.petmilly_client.presentation.homescreen.naverMapComposable
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen.ShelterDetailActivity
import com.llama.petmilly_client.presentation.signupscreen.SignUpActivity
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.SpacerHeight
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.NaverMap
import com.naver.maps.map.compose.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.LOCATION_AUTHENTICATION_SCREEN
import llama.test.jetpack_dagger_plz.utils.Common.PERSONALINFOSCREEN
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import java.util.*

private var mynavermap: NaverMap? = null


@OptIn(ExperimentalNaverMapApi::class)
@AndroidEntryPoint
class CertificationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                val navController = rememberNavController()
                val viewModel: CertificationViewModel = hiltViewModel()

                NavHost(
                    navController = navController,
                    startDestination = LOCATION_AUTHENTICATION_SCREEN
                ) {
                    composable(route = LOCATION_AUTHENTICATION_SCREEN) {
                        LocationauthenticationScreen(
                            navController,
                            viewModel,
                            this@CertificationActivity
                        )
                    }
                }
            }


        }
    }
}


@ExperimentalNaverMapApi
@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun LocationauthenticationScreen(
    navController: NavController,
    viewModel: CertificationViewModel,
    activity: Activity,
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    Column(Modifier.fillMaxSize()) {
        TitleBar(
            title = "동네 인증",
            ismenu = false,
            clickBack = {
                        activity.finish()
            },
            clickMenu = {})
//
        Box(
            modifier = Modifier
                .weight(15f)
                .padding(top = 10.dp)
        ) {
            CertificationNaverMap(viewModel)
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
//            viewModel.posttownauth()
            val intent = Intent(context, ShelterDetailActivity::class.java)
            context.startActivity(intent)
            activity.finish()
        }

        SpacerHeight(dp = 100.dp)
    }

    LaunchedEffect(context){
        setObserve(viewModel, context, lifecycleOwner, activity)
    }
}


@Composable
fun CertificationNaverMap(viewModel: CertificationViewModel) {
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


                    // 위치 정보 권한 요청 시작 할때로 바꾸기
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
                        fusedLocationProviderClient.lastLocation
                            .addOnSuccessListener { location ->
                                // 위치 정보를 성공적으로 받아왔을 때 처리

                                val mypostion =
                                    LatLng(location.latitude, location.longitude) ?: LatLng(
                                        37.715,
                                        126.734
                                    )



                                getAddress(
                                    context,
                                    location.latitude,
                                    location.longitude,
                                    viewModel
                                )
                                marker.apply {
                                    position = mypostion
                                    icon = OverlayImage.fromResource(R.drawable.ic_navermarker)
                                    width = 150
                                    height = 180
                                }

                                marker.map = navermap
                                val cameraUpdate = CameraUpdate.scrollTo(mypostion)
                                navermap.moveCamera(cameraUpdate)
                            }
                            .addOnFailureListener { exception ->

                                Log.d(TAG, "CertificationNaverMap2: $exception")

                            }
                    }
                }
            }
        )
    }
}


private fun getAddress(
    context: Context,
    latitude: Double,
    longitude: Double,
    viewModel: CertificationViewModel,
): String {
    val geoCoder = Geocoder(context, Locale.KOREA)
    var address = ArrayList<Address>()
    var addressResult = "주소를 가져 올 수 없습니다."
    try {
        address = geoCoder.getFromLocation(latitude, longitude, 1) as ArrayList<Address>
        if (address.size > 0) {
            val currentLocationAddress = address[0].getAddressLine(0).toString()
            addressResult = currentLocationAddress
            viewModel.townadress.value = addressResult
            Log.d(TAG, "getAddress: $addressResult")
        }
    } catch (e: java.lang.Exception) {
        Log.d(TAG, "getAddress ERROR: $e")
        Toast.makeText(context, "주소를 불러올 수 없습니다. $e", Toast.LENGTH_SHORT).show()
    }

    return addressResult
}


private fun setObserve(
    viewModel: CertificationViewModel,
    context: Context,
    lifecycleOwner: LifecycleOwner,
    activity: Activity,
) {

    viewModel.setshelterIntent.observe(lifecycleOwner, androidx.lifecycle.Observer {
        val intent = Intent(context, ShelterDetailActivity::class.java)
        context.startActivity(intent)
        activity.finish()
    })
}



