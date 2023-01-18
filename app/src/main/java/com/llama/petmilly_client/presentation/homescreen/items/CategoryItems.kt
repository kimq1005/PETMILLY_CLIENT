package com.llama.petmilly_client.presentation.homescreen.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

@Composable
fun CategoryItems(
    categoryTest: CategoryTest,
    onClick:()->Unit,
) {

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
                .clickable { onClick() }
                .background(color = Purple700, shape = RoundedCornerShape(4.dp))
                .padding(5.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

    }



}