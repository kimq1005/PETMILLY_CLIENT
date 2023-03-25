package com.llama.petmilly_client.utils

import android.net.Uri
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.chatscreen.ChatTabScreen
import com.llama.petmilly_client.presentation.chatscreen.FavoriteChatScreen
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.ui.theme.Grey_100_CBC4C4
import kotlinx.coroutines.launch
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
        shape = RoundedCornerShape(6.dp)

    ) {
        Text(
            text = title,
            color = textcolor,
            fontSize = fontSize.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )

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
    fontFamily: FontFamily,
    onclick: () -> Unit,

    ) {
    Button(
        onClick = { onclick() },
        modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundcolor),
        shape = shape,
        elevation = null

    ) {
        Text(
            text = title,
            color = textcolor,
            fontSize = fontSize.sp,
            fontFamily = fontFamily,
            textAlign = textAlign,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
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
fun CheckedCheckBox(clickcolor: Color) {
    Box {
        Canvas(
            modifier = Modifier
                .size(size = 18.dp)
                .align(Alignment.Center)

        ) {
            drawCircle(
                color = clickcolor
            )
        }

        Image(
            painter = painterResource(
                id = R.drawable.baseline_check_white
            ),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .height(4.dp)
                .width(6.dp),
            contentScale = ContentScale.Crop
        )
    }//Box
}

@Composable
fun NoneCheckBox(nonecheckcolor: Color) {
    Box {
        Canvas(
            modifier = Modifier
                .size(size = 18.dp)
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
            painter = painterResource(
                id = R.drawable.baseline_check_black_24
            ),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .height(4.dp)
                .width(6.dp),
            contentScale = ContentScale.Crop

        )
    }//Box
}

@Composable
fun IDontKnowCheckBox(
    onclick: (String) -> Unit,
) {
    var check by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.clickable {
        check = !check
        if(check){
            onclick("모르겠어요")
        }else{
            onclick("")
        }

    }) {
        Canvas(
            modifier = if (check) Modifier
                .size(size = 18.dp)
                .align(Alignment.Center)
            else Modifier
                .size(size = 18.dp)
                .align(Alignment.Center)
                .border(
                    border = BorderStroke(1.dp, Color.Black), shape = CircleShape
                )

        ) {
            drawCircle(
                if (check) Category_Cliked else Color.White
//                color = clickcolor
            )
        }

        if (check) {
            Image(
                painter = painterResource(id = R.drawable.baseline_check_white),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(4.dp)
                    .width(6.dp),
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.baseline_check_black_24),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(4.dp)
                    .width(6.dp),
                contentScale = ContentScale.Crop
            )
        }

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
    enabled: Boolean,
    onclick: () -> Unit,
) {

    Button(
        onClick = { onclick() },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundcolor,
            contentColor = Color.White
        ),
        shape = shape,
        elevation = null,
        enabled = enabled

    ) {
        Text(
            text = title,
            color = textcolor,
            fontSize = fontSize.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            textAlign = textAlign,
        )
    }
}


@Composable
fun TextScreen_HOUSE(
    title: String,
    textcolor: Color,
    fontSize: Int,
    modifier: Modifier,
    textAlign: TextAlign,
    onclick: () -> Unit,
) {
    Box(
        modifier = modifier

    ) {
        Text(
            text = title,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    onclick()
                },
            color = textcolor,
            fontSize = fontSize.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            textAlign = textAlign,
        )
    }


}


@Composable
fun Cancle(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.img_cancle),
        contentDescription = null,
        modifier = modifier
            .height(25.dp)
            .width(25.dp),
        contentScale = ContentScale.Crop
    )
}


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState, list: List<String>) {
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color(0xFF99FBE1B0),
        contentColor = Color.Black,
        indicator = { tabPostions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions = tabPostions),
                height = 5.dp,
                color = Color(0xFFF8A405)
            )
        },
        divider = { contentColorFor(backgroundColor = Color.Black) }
    ) {
        list.forEachIndexed { index, _ ->

            val fontWeight =
                if (index == pagerState.currentPage) notosans_bold else notosans_regular
            Tab(
                text = {
                    Text(
                        text = list[index],
                        fontSize = 17.sp,
                        fontFamily = fontWeight
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                selectedContentColor = Color.Black,

                )
        }
    }
}


@Composable
fun CommonNotingScreen(text: String, modifier: Modifier) {

    Text(
        modifier = modifier,
        text = text,
        fontSize = 17.sp,
        fontFamily = notosans_regular,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        ),
        color = Black_30_Transfer,
        textAlign = TextAlign.Center
    )
}

@Composable
fun SpacerWidth(dp: Dp) {
    Spacer(modifier = Modifier.width(dp))
}

@Composable
fun SpacerHeight(dp: Dp) {
    Spacer(modifier = Modifier.height(dp))
}

@Composable
fun PicktureItems(image: Int, modifier: Modifier) {
    Image(
        painter = rememberImagePainter(data = image),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun PicktureUriItems(image: Uri, modifier: Modifier, ondelete: () -> Unit) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray)
    ) {


        Image(
            painter = rememberImagePainter(data = image),
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop,
        )

        Image(
            painter = painterResource(id = R.drawable.img_delete_picture),
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)
                .align(Alignment.TopEnd)
                .padding(top = 4.dp, end = 4.dp)
                .clickable {
                    ondelete()
                },
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

    }

}


@Composable
fun FAFF() {
    var (value, setvalue) = rememberSaveable {
        mutableStateOf("1234555")
    }

    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Row(modifier = Modifier.weight(4f)) {
            TextField(
                value = value,
                onValueChange = {
                    if (it.length <= 4) {
                        value = it
                    }
                },
                modifier = Modifier.weight(3f),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,
                ),
                textStyle = TextStyle(
                    fontSize = 30.sp, fontFamily = notosans_bold,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),

                placeholder = {
                    Text(
                        text = "1990",
                        fontSize = 30.sp,
                        fontFamily = notosans_bold,
                        color = Grey_100_CBC4C4,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
                    )
                }
            )


        }

    }


}




