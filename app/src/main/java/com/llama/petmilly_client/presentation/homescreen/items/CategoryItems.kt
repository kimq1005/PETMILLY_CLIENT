package com.llama.petmilly_client.presentation.homescreen.items

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import com.llama.petmilly_client.presentation.homescreen.HomeViewModel
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.ui.theme.Purple200
import com.llama.petmilly_client.ui.theme.Purple700
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun CategoryItems(
    categoryTest: CategoryTest,
    onClick: () -> Unit,
) {

    val itemSelection = remember {
        mutableStateOf(-1)
    }
    var checkBoolean by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(20.dp))
            .background(
                color = if (checkBoolean) Category_Cliked else Color.White,
                shape = RoundedCornerShape(16.5.dp),
            )

    ) {
        Text(
            text = categoryTest.title,
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            color = if (checkBoolean) Color.White else Color.Black,
            modifier = Modifier

//                .background(
//                    color = if (checkBoolean) Category_Cliked else Color.White,
//                    shape = RoundedCornerShape(16.5.dp),
//
//                )
                .selectable(selected = checkBoolean, onClick = {
                    checkBoolean = !checkBoolean
                    onClick()
                })
                .padding(top = 7.dp, bottom = 7.dp, start = 12.dp, end = 12.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )


    }

}


@Composable
fun CategoryShelterItems(
    categoryTest: CategoryTest,
    onClick: () -> Unit,
) {

    val itemSelection = remember {
        mutableStateOf(-1)
    }
    var checkBoolean by remember {
        mutableStateOf(false)
    }

    FlowRow(
        modifier = Modifier
            .border(0.5.dp, color = Color.Black, shape = RoundedCornerShape(16.5.dp)),
        mainAxisAlignment = MainAxisAlignment.Center,
        mainAxisSize = SizeMode.Expand,
    ) {
        Text(
            text = categoryTest.title,
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            color = if (checkBoolean) Color.White else Color.Black,
            modifier = Modifier
                .background(
                    color = if (checkBoolean) Category_Cliked else Color.White,
                    shape = RoundedCornerShape(16.5.dp),
                )
                .selectable(selected = checkBoolean, onClick = {
                    checkBoolean = !checkBoolean
                    onClick()
                })
                .padding(top = 7.dp, bottom = 7.dp, start = 12.dp, end = 12.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

    }

}


@Composable
fun BorderCategoryItems(
    title: String,
    onClick: () -> Unit,
) {

    val itemSelection = remember {
        mutableStateOf(-1)
    }
    var checkBoolean by remember {
        mutableStateOf(false)
    }

    FlowRow(
        modifier = if (!checkBoolean) Modifier
            .border(
                0.5.dp,
                color = Color.Black,
                shape = RoundedCornerShape(16.5.dp)
            ) else Modifier,

        mainAxisAlignment = MainAxisAlignment.Center,
        mainAxisSize = SizeMode.Expand,
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            color = if (checkBoolean) Color.White else Color.Black,
            modifier = Modifier
                .background(
                    color = if (checkBoolean) Category_Cliked else Color.White,
                    shape = RoundedCornerShape(16.5.dp),
                )
                .selectable(selected = checkBoolean, onClick = {
                    checkBoolean = !checkBoolean
                    onClick()
                })
                .padding(top = 7.dp, bottom = 7.dp, start = 12.dp, end = 12.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

    }

}