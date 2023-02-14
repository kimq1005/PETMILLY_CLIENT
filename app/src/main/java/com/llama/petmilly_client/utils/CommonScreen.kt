package com.llama.petmilly_client.utils

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Category_Cliked
import llama.test.jetpack_dagger_plz.utils.Common.TAG


@Composable
fun ButtonScreen(
    title: String,
    textcolor: Color,
    fontSize: Int,
    modifier: Modifier,
    backgroundcolor: Color,
    onclick: () -> Unit,
) {
    Button(
        onClick = { onclick() },
        modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundcolor),
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
fun ButtonShapeScreen(
    title: String,
    textcolor: Color,
    fontSize: Int,
    modifier: Modifier,
    backgroundcolor: Color,
    textAlign: TextAlign,
    shape: Shape,
    onclick: () -> Unit,
) {
    Button(
        onClick = { onclick() },
        modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundcolor),
        shape = shape

    ) {
        Text(
            text = title,
            color = textcolor,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = textAlign,
            modifier = Modifier.fillMaxWidth()

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




@Composable
fun CheckedCheckBox(clickcolor: Color){
    Box {
        Canvas(
            modifier = Modifier
                .size(size = 30.dp)
                .align(Alignment.Center)

        ) {
            drawCircle(
                color = clickcolor
            )
        }

        Image(
            painter =  painterResource(id = R.drawable.baseline_check_white
            ),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
    }//Box
}
@Composable
fun NoneCheckBox(nonecheckcolor: Color){
    Box {
        Canvas(
            modifier = Modifier
                .size(size = 30.dp)
                .align(Alignment.Center)
                .border(
                    border = BorderStroke(1.dp, Color.Black), shape = CircleShape
                )

        ) {
            drawCircle(
                color = nonecheckcolor
            )
        }

        Image(
            painter =  painterResource(id = R.drawable.baseline_check_black_24
            ),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
    }//Box
}

@Composable
fun ButtonScreen_HOUSE(
    title: String,
    textcolor: Color,
    fontSize: Int,
    modifier: Modifier,
    backgroundcolor: Color,
    textAlign: TextAlign,
    shape: Shape,
    onclick: () -> Unit,
) {
    Button(
        onClick = { onclick() },
        modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundcolor),
        shape = shape

    ) {
        Text(
            text = title,
            color = textcolor,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = textAlign,
        )
    }
}




