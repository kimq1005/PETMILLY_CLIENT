package com.llama.petmilly_client.presentation.findanimalscreen

import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import coil.compose.rememberImagePainter
import com.llama.petmilly_client.ui.theme.Background_FDFCE1
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Black_Half_Transfer
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun FindAnimalItems(
    name: String,
    animalinfo: String,
    missinginfo: String,
    time: String,
    image:List<Int>,
    onclick: () -> Unit,
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(182.dp)
            .background(Color(0xFFEFEFEF), shape = RoundedCornerShape(7.dp))
            .padding(start = 20.dp, end = 8.dp, top = 16.dp, bottom = 16.dp)
            .clickable {
                onclick()
            }

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = name,
                fontSize = 15.sp,
                fontFamily = notosans_regular, style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Black_Half_Transfer,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = time,
                fontSize = 8.sp,
                fontFamily = notosans_regular, style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Black_30_Transfer,
                textAlign = TextAlign.Center
            )


        }

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = animalinfo,
            fontSize = 12.sp,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black
        )

        Text(
            text = "실종일 $missinginfo",
            fontSize = 13.sp,
            modifier = Modifier.background(color = Background_FDFCE1),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(3.dp))

        val mylmage =
            ContextCompat.getDrawable(context, com.llama.petmilly_client.R.drawable.img_test_puppy)
        val myImageId = mylmage?.let { rememberImagePainter(data = it) } ?: 0

        LazyRow(modifier = Modifier.fillMaxWidth()) {


            items(image) { image ->
                MissingAnimalImageItems(animalimage = image)
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

@Composable
fun MissingAnimalImageItems(
    animalimage: Int,
) {
    Image(
        painter = rememberImagePainter(animalimage),
        contentDescription = null,
        modifier = Modifier
            .height(80.dp)
            .width(80.dp),
        contentScale = ContentScale.Crop
    )
}

data class ImageTestData(
    val image: Int,
)
