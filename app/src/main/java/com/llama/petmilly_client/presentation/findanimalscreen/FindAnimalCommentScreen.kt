package com.llama.petmilly_client.presentation.findanimalscreen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common


class FindAnimalCommentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }

    }
}

@Composable
fun CommentTitlebar(
    clickBack: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
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

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 10.dp)
        ) {
            Text(
                text = "??????",
                fontSize = 17.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Text(
                text = "???????????? ?????????",
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )


        }

    }
}

@Composable
fun FindAnimalCommentScreen(navController: NavController, viewModel: FindAnimalViewModel) {


    val (value, setvaluse) = rememberSaveable {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        CommentTitlebar {
            navController.popBackStack()
        }


        Text(
            text = "?????? ?????? ?????? (??????)",
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 35.dp),
            fontFamily = notosans_bold,
            color = Black_60_Transfer
        )
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            TextField(
                value = value,
                onValueChange = setvaluse,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(53.dp)
                    .weight(8f)
                    .clickable {

                    },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = {
//                    focusManager.moveFocus(FocusDirection.Down)
                }),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,

                    ),
                placeholder = { Text(text = "??????????????? ????????? ???????????????.") }
            )

            Image(
                painter = painterResource(id = R.drawable.img_comment_location),
                contentDescription = null,
                modifier = Modifier
                    .height(45.dp)
                    .width(45.dp)
                    .weight(2f)
                    .align(Alignment.CenterVertically),
            )

        }

        Spacer(modifier = Modifier.height(7.dp))

        TextField(
            value = value,
            onValueChange = setvaluse,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .height(53.dp)
                .clickable {

                },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
//                    focusManager.moveFocus(FocusDirection.Down)
            }),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,

                ),
            placeholder = { Text(text = "??????????????? ????????? ??????????????????.") }
        )

        Spacer(modifier = Modifier.height(55.dp))

        Text(
            text = "?????? ??????/?????? (??????)",
            fontSize = 14.sp,
            fontFamily = notosans_bold,
            modifier = Modifier.padding(start = 35.dp),
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Black_60_Transfer
        )

        TextField(
            value = viewModel.findyear.value,
            onValueChange = { viewModel.findyear.value = it },
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
            modifier = Modifier.padding(start = 20.dp),

            placeholder = {
                Text(
                    text = "23??? 02??? 04??? 10???",
                    fontSize = 30.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.LightGray
                )
            }
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "???????????? (??????)",
            fontSize = 14.sp,
            fontFamily = notosans_bold,
            modifier = Modifier.padding(start = 35.dp),
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Black_60_Transfer
        )

        Spacer(modifier = Modifier.height(7.dp))
        Image(
            painter = painterResource(id = R.drawable.img_comment_camera),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 40.dp)
                .height(47.dp)
                .width(47.dp)

        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "* ??????????????? ?????? ?????? ?????????  ????????????,\n" +
                    "??????????????? ????????? ????????? ?????????????????? ???????????????.",
            modifier = Modifier.padding(horizontal = 35.dp),
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            fontSize = 13.sp,
            color = Black_60_Transfer
        )

        Spacer(modifier = Modifier.height(22.dp))


        ButtonScreen(
            title = "?????? ??????",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(horizontal = 35.dp),
            backgroundcolor = Button_Clicked
        ) {


        }

        Spacer(modifier = Modifier.height(25.dp))
    }//Box

}

@Composable
fun CommentDate(viewModel: FindAnimalViewModel, modifier: Modifier, text: String, hint: String) {

}

@Preview
@Composable
fun CommentPreview() {
    val viewmodel: FindAnimalViewModel = hiltViewModel()
    val navController = rememberNavController()
    FindAnimalCommentScreen(navController, viewmodel)
}