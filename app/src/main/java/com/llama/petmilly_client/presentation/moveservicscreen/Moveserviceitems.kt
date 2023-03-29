package com.llama.petmilly_client.presentation.moveservicscreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.llama.petmilly_client.R
import com.llama.petmilly_client.data.model.moveservice.postmoveservice.HopeDate
import com.llama.petmilly_client.ui.theme.Background_FDFCE1
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.utils.CommonObject.convertmoveservicetime
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Moveserviceitems(
    image: String?,
    startAddress: String,
    endAddress: String,
    animalinfo: String,
    moveday: List<HopeDate>,
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

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.background(color = Background_FDFCE1)
                ) {
                    Text(
                        text = "\uD83D\uDE97 $startAddress ",
                        fontSize = 15.sp,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Color.Black,
                    )

                    Image(
                        painter = painterResource(id = R.drawable.img_arrow_go),
                        contentDescription = null,
                        modifier = Modifier
                            .width(14.dp)
                            .height(14.dp)
                    )

                    Text(
                        text = " $endAddress",
                        fontSize = 15.sp,
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Color.Black,
                    )

                }


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

                LazyColumn() {
                   items(moveday){ item->
                       Hopedateitesm(moveday = item.hopeDate)
                   }
                }

//                Text(
//                    text = moveday,
//                    fontSize = 12.sp,
//                    fontFamily = notosans_bold,
//                    style = TextStyle(
//                        platformStyle = PlatformTextStyle(
//                            includeFontPadding = false
//                        )
//                    ),
//                    color = Black_60_Transfer,
//                )

            }//Column

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "",
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Hopedateitesm(
    moveday: String,
) {
   Column {
       Text(
           text = convertmoveservicetime(moveday),
           fontSize = 12.sp,
           fontFamily = notosans_bold,
           style = TextStyle(
               platformStyle = PlatformTextStyle(
                   includeFontPadding = false
               )
           ),
           color = Black_60_Transfer,
       )
   }

}
//
//@Composable
//fun MainMainScreen() {
//    LazyColumn() {
//        val testdata = listOf(
//            testdataman(
//                "대한민국 어딘가",
//                moveday = listOf(
//                    "하루뒤",
//                    "이틀뒤"
//                ),
//
//                ),
//            testdataman(
//                "대한민국 여기다",
//                moveday = listOf(
//                    "하루뒤", "이틀뒤"
//                ),
//
//                )
//
//            )
//        items(testdata){items->
//            Moveserviceitem123s(items.startaddress, moveday = items.moveday)
//        }
//    }
//
//}
//
//data class testdataman(
//    val startaddress: String,
//    val moveday: List<String>,
//)