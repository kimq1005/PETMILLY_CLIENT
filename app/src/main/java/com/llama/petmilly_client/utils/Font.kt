package com.llama.petmilly_client.utils

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Black_Half_Transfer

val notosans_regular = FontFamily(Font(R.font.notosanskr_regular))

val notosans_bold = FontFamily(Font(R.font.notosanskr_bold))


@Composable
fun NotosansKR_Regular_Text(text: String, modifier: Modifier, textsize: Float, color:Int) {
    Text(
        text = text,
        fontFamily = notosans_regular,
        fontSize = textsize.sp,
        color = Color(color),
        modifier = modifier,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        )
    )
}

@Composable
fun NotosansKR_Regular_Bold(text: String, modifier: Modifier, textsize: Float, color:Int) {
    Text(
        text = text,
        fontFamily = notosans_bold,
        fontSize = textsize.sp,
        color = Color(color),
        modifier = modifier,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        ),
    )
}
