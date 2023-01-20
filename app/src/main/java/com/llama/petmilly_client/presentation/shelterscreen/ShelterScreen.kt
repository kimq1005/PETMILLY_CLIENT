package com.llama.petmilly_client.presentation.shelterscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R

@Composable
fun SafeShelterListScreen(viewModel: ShelterViewModel= androidx.lifecycle.viewmodel.compose.viewModel()) {
    Scaffold {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                        .align(Alignment.CenterStart),
                )

                Text(
                    text = "임보처 구해요",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            viewModel.testsetcategory()
//
//            LazyRow(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(12.dp)
//            ){
//                items(viewModel.sheltercategory.value){
//
//                }
//            }
        }
    }
}

@Preview
@Composable
fun TestPreview(){
    SafeShelterListScreen()
}