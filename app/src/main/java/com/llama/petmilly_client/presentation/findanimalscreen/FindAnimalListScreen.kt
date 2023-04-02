package com.llama.petmilly_client.presentation.findanimalscreen

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.findanimalscreen.findanimaldetailscreen.FADetailActivity
import com.llama.petmilly_client.presentation.homescreen.items.BorderCategoryItems
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun FindAnimalListScreen(
    navController: NavController,
    viewModel: FindAnimalViewModel,
    activity: Activity,
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)

        ) {

            TitleBar(
                title = "우리아이 찾아요",
                ismenu = false,
                clickBack = { activity.finish() }) {

            }

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                viewModel.setcategory()

                items(viewModel.categorytest) { categorylist ->
                    Row {
                        if (viewModel.categorytest.indexOf(categorylist) == 0) {
                            Spacer(modifier = Modifier.padding(start = 15.dp))
                            BorderCategoryItems(title = categorylist.title) {  title, check->

                            }


                        } else {
                            BorderCategoryItems(title = categorylist.title) {  title, check->

                            }
                        }

                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }

            }//LazyRow
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(Modifier.padding(horizontal = 7.dp)) {

                val missingAnimalInfoData = listOf(
                    MissingAnimalInfoData(
                        image = listOf(
                            R.drawable.img_test_dog_1,
                            R.drawable.img_test_dog_2,
                            R.drawable.img_test_dog_3
                        ),
                        name= "쬬코",
                        "수컷 / 3kg / 시바견 / 겁이 많아요",
                        "23.3.15 10시 - 매탄동 위브하늘채 부근",
                        "방금 전",

                    ),
                    MissingAnimalInfoData(
                        image = listOf(
                            R.drawable.img_test_dog4,
                            R.drawable.img_test_dog5
                        ),
                        "망구",
                        "수컷 / 7kg / 시바견 / 귀 한쪽 접혀 있어요",
                        "23.3.14 10시 - 월계동 새마음 병원 부근",
                        "10시간 전"
                    ),

                    )

                items(missingAnimalInfoData) { item ->
                    FindAnimalItems(
                        name = item.name,
                        animalinfo = item.animalinfo,
                        missinginfo = item.missinginfo,
                        time = item.tiems,
                        image = item.image,
                        onclick = {
                            navController.navigate(Common.FINDANIMAL_DETAIL_SCREEN)
                        }
                    )

                    Spacer(modifier = Modifier.height(13.dp))

                }
            }
        }


        Image(
            painter = painterResource(id = R.drawable.img_write),
            contentDescription = null,

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 40.dp, end = 15.dp)
                .width(50.dp)
                .height(50.dp)
                .clickable {
                    val intent = Intent(context, FADetailActivity::class.java)
                    context.startActivity(intent)
                },
            contentScale = ContentScale.Crop
        )

    }

}


data class MissingAnimalInfoData(
    val image:List<Int>,
    val name: String,
    val animalinfo: String,
    val missinginfo: String,
    val tiems: String,
)