package com.llama.petmilly_client.presentation.serachscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun SearchItems(
    searchtext: String,
    onclick: () -> Unit,
) {
    Row(Modifier.fillMaxWidth()) {
        Text(
            text = searchtext,
            fontSize = 14.sp,
            color = Color.Black,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.img_cancle),
            contentDescription = null,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp),
            contentScale = ContentScale.Crop
        )
    }
}