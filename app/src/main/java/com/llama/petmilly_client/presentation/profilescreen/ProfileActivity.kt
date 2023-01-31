package com.llama.petmilly_client.presentation.profilescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TitleBar(title = "", ismenu = true, clickBack = { finish() }, clickMenu = {})
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current


    Column(modifier = Modifier.padding(16.dp)) {

        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = null,
                modifier = Modifier
                    .height(85.dp)
                    .width(85.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(text = "김승현짱", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "인증완료여부", fontSize = 12.sp, color = Color.Black)
                Text(text = "인증완료여부", fontSize = 12.sp, color = Color.Black)
            }

        }//Row

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Text(text = "입양 0건", fontSize = 16.sp, color = Color.Black)
            Text(text = "임보 0건", fontSize = 16.sp, color = Color.Black)
            Text(text = "봉사 0건", fontSize = 16.sp, color = Color.Black)
        }//Row

    }

}

@Preview
@Composable
fun HEY(){
    ProfileScreen()
}
