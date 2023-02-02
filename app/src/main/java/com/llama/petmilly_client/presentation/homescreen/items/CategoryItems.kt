package com.llama.petmilly_client.presentation.homescreen.items

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import com.llama.petmilly_client.presentation.homescreen.HomeViewModel
import com.llama.petmilly_client.ui.theme.Purple200
import com.llama.petmilly_client.ui.theme.Purple700
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun CategoryItems(
    categoryTest: CategoryTest,
    onClick: () -> Unit,
) {

    val itemSelection = remember{
        mutableStateOf(-1)
    }
    var checkBoolean by remember {
        mutableStateOf(false)
    }

    FlowRow(
        modifier = Modifier.padding(4.dp),
        mainAxisAlignment = MainAxisAlignment.Center,
        mainAxisSize = SizeMode.Expand,
    ) {
        Text(
            text = categoryTest.title,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier
                .background(
                    color = if (checkBoolean) Color.Black else Purple200,
                    shape = RoundedCornerShape(4.dp)
                )
                .selectable(selected = checkBoolean, onClick = {
                    checkBoolean = !checkBoolean
                    onClick()
                    Log.d(TAG, "CategoryItems: $checkBoolean")
                })
                .padding(5.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Log.d(TAG, "YeahMANHOW: $checkBoolean ")

    }

}

fun checkBtn(checkBoolean: Boolean) {
    when (checkBoolean) {
        true -> {
            //버튼클릭댐

        }

        else -> {
            //클릭안댐
        }
    }
}