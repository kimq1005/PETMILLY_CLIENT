package com.llama.petmilly_client.presentation.moveservicscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import coil.compose.rememberImagePainter
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.findanimalscreen.ImageTestData
import com.llama.petmilly_client.presentation.findanimalscreen.MissingAnimalImageItems
import com.llama.petmilly_client.ui.theme.Background_FDFCE1
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.ui.theme.Black_Half_Transfer
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun Moveserviceitems(
    image: String?,
    movelocation: String,
    animalinfo: String,
    moveday: String,
    time: String,
    onclick: () -> Unit,
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color.White, shape = RoundedCornerShape(7.dp))
            .border(width = 1.dp, color = Color(0xFFEFEFEF), shape = RoundedCornerShape(7.dp))
            .clickable {
                onclick()
            }

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {

            Image(
                painter = if (image != null) rememberImagePainter(data = image) else painterResource(
                    id = R.drawable.img_test_puppy
                ),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 15.dp)
                    .height(80.dp)
                    .width(80.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(20.dp))

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "\uD83D\uDE97 $movelocation",
                    fontSize = 15.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black,
                    modifier = Modifier.background(color = Background_FDFCE1)
                )

                Text(
                    text = animalinfo,
                    fontSize = 12.sp,
                    fontFamily = notosans_regular, style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Black_60_Transfer,
                    textAlign = TextAlign.Center
                )


                Text(
                    text = moveday,
                    fontSize = 12.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Black_60_Transfer,
                )

            }//Column

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = time,
                fontSize = 8.sp,
                fontFamily = notosans_regular, style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                modifier = Modifier.padding(top = 5.dp, end = 7.dp),
                color = Black_30_Transfer,
                textAlign = TextAlign.Center
            )


        }

    }
}

