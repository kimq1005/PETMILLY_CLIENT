package com.llama.petmilly_client.presentation.certificationscreen

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.ButtonScreen
import com.naver.maps.map.compose.*
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common.LOCATION_AUTHENTICATION_SCREEN
import llama.test.jetpack_dagger_plz.utils.Common.PERSONALINFOSCREEN

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
                        LocationauthenticationScreen(navController, this@CertificationActivity)
                    }
                    composable(route = PERSONALINFOSCREEN) {
                        PersonalInfoScreen(this@CertificationActivity)
                    }
                }
//                LocationauthenticationScreen(navController, this)
            }


        }
    }
}


@ExperimentalNaverMapApi
@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun LocationauthenticationScreen(navController: NavController, activity: Activity) {
    val context = LocalContext.current
    Column(Modifier.fillMaxSize()) {
        TitleBar(
            title = "?????? ??????",
            ismenu = false,
            clickBack = { activity.finish() },
            clickMenu = {})
//
        Box(
            modifier = Modifier
                .weight(15f)
                .padding(top = 10.dp)
        ) {
            NaverMap(
                locationSource = rememberFusedLocationSource(),
                properties = MapProperties(
                    locationTrackingMode = LocationTrackingMode.Follow
                ),
                uiSettings = MapUiSettings(
                    isLocationButtonEnabled = true,
                ),
            ) {
                Marker(
                    onClick = { it ->
                        true
                    })
            }
        }


        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "??????????????????",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            backgroundcolor = Button_Clicked,
            fontSize = 16,
            textcolor = Color.White,
            onclick = {
                navController.navigate(PERSONALINFOSCREEN)
            }
        )
    }

}


@Composable
fun PersonalInfoScreen(activity: Activity) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        val (value, setvaluse) = rememberSaveable {
            mutableStateOf(" ")
        }

        val (job, setjob) = rememberSaveable {
            mutableStateOf(" ")
        }

        val (location, setlocation) = rememberSaveable {
            mutableStateOf(" ")
        }

        val (animalExperiencee, setanimalExperience) = rememberSaveable {
            mutableStateOf(false)
        }
        Row {
            Text(
                text = "?????????",
                modifier = Modifier.weight(1f),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "???????????? ????????? ????????? ??????\n???????????? ????????? ???????????????.\n?????? ????????? ??????/?????? ?????? ??? ??????????????? ???????????????.",
                modifier = Modifier.weight(3f),
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "??????",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        OutlinedTextField(
            value = job,
            onValueChange = setjob,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "????????????",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        OutlinedTextField(
            value = location,
            onValueChange = setlocation,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "???????????? ??????",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "??????", Modifier.align(Alignment.CenterVertically))
            Checkbox(
                checked = animalExperiencee,
                onCheckedChange = setanimalExperience,
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "??????", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "???????????????.", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)
        }


        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "???????????? ??????",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "??????", Modifier.align(Alignment.CenterVertically))
            Checkbox(
                checked = animalExperiencee,
                onCheckedChange = setanimalExperience,
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "??????", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)

        }


        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "?????? ??????",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )


        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "??????????????? ???????????????",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            OutlinedTextField(
                value = value, onValueChange = setvaluse, modifier = Modifier
                    .weight(8f)
                    .fillMaxHeight()
            )

            Spacer(modifier = Modifier.width(5.dp))
            ButtonScreen(
                title = "??????",
                textcolor = Color.Black,
                fontSize = 14,
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),
                backgroundcolor = Button_NoneClicked
            ) {

            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "?????????",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "??????", Modifier.align(Alignment.CenterVertically))
            Checkbox(
                checked = animalExperiencee,
                onCheckedChange = setanimalExperience,
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "??????", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)

        }


        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "????????????",
            textcolor = Color.White,
            fontSize = 16,
            modifier = Modifier.fillMaxWidth(),
            backgroundcolor = Button_Clicked
        ) {
            activity.finish()
        }


    }
}


@Preview
@Composable
fun FSDF(){
    val navController = rememberNavController()

}

