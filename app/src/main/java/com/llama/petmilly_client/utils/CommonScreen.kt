package com.llama.petmilly_client.utils

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.ui.theme.Button_Clicked


@Composable
fun ButtonScreen(
    title:String,
    textcolor: Color,
    fontSize: Int,
    modifier: Modifier,
    backgroundcolor: Color,
    onclick: () -> Unit,
) {
    Button(
        onClick = { onclick() },
        modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundcolor)

    ) {
        Text(
            text = title,
            color = textcolor,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun CommonTitleBar(
    title: String,
    ismenu: Boolean,
    clickBack: () -> Unit,
    clickMenu: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .align(Alignment.CenterStart)
                .clickable {
                    clickBack()
                }
        )

        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center)
        )

        AnimatedVisibility(visible = ismenu, modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)

                    .clickable {
                        clickMenu()
                    },

                )
        }


    }
}