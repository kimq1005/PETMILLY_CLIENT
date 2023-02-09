package com.llama.petmilly_client.presentation.shelterscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.homescreen.items.CategoryItems
import com.llama.petmilly_client.presentation.homescreen.items.CategoryShelterItems
import com.llama.petmilly_client.presentation.shelterscreen.items.ShelterCategoryItems
import com.llama.petmilly_client.ui.theme.Purple700
import llama.test.jetpack_dagger_plz.utils.Common.ANIMALINFO_DETAIL
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun SafeShelterListScreen(navController: NavController, viewModel: ShelterViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    Scaffold {

        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

//            TitleBar("임보처 구해요",
//                ismenu = false,
//                clickBack = {
//                   navController.popBackStack()
//                },
//
//                clickMenu = {
//
//                }
//
//            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                viewModel.setcategory()
                items(viewModel.categorytest) { categorylist ->
                    Row {
                        CategoryShelterItems(categoryTest = categorylist) {

                        }

                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }

            }

            Spacer(modifier = Modifier.height(10.dp))

//
            LazyColumn(
            ) {
                viewModel.setcategory()

                items(viewModel.sheltercategory.value) { items ->
                    Column {
                        ShelterCategoryItems(items,
                            onclcik = {
                                navController.navigate(ANIMALINFO_DETAIL)
                            })
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TestPreview() {
    val navController= rememberNavController()
    SafeShelterListScreen(navController)
}