package com.llama.petmilly_client.presentation.findanimalscreen

import android.net.Uri
import android.util.Log
import android.view.SurfaceControlViewHost.SurfacePackage
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.SpacerHeight
import com.llama.petmilly_client.utils.SpacerWidth
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import retrofit2.http.Url

@Composable
fun FindAnimalDetailScreen(navController: NavController, viewModel: FindAnimalViewModel) {


    val (value, setvaluse) = rememberSaveable {
        mutableStateOf("")
    }


    Column {
        TitleBar(
            title = "우리아이 찾아요",
            ismenu = false,
            clickBack = { navController.popBackStack() }) {
        }

        val context = LocalContext.current

        LaunchedEffect(context) {
            Log.d(TAG, "FindAnimalDetailScreen: hello")
            viewModel.getfindmypetdetail(3)
        }

        LazyRow(modifier = Modifier.padding(horizontal = 10.dp)) {

            items(viewModel.photoUrl) { item ->
                FindAnimalDetailImage2(image = item.photoUrl)
                Spacer(modifier = Modifier.width(9.dp))

            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "소중한 제보를 기다립니다.",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .background(Color(0xFFFFF2DA)),
                fontSize = 16.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f))

        }

        Spacer(modifier = Modifier.height(10.dp))

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = "이름/성별",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = "${viewModel.name.value} / ${viewModel.gender.value}",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                color = Black_30_Transfer
            )



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = "몸무게",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = viewModel.weight.value.toString(),
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp), color = Black_30_Transfer
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = "품종",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = viewModel.breed.value,
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp), color = Black_30_Transfer
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = "목줄여부&색",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = viewModel.lead.value,
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp), color = Black_30_Transfer
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = "실종당시 옷",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = viewModel.clothes.value,
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth(), color = Black_30_Transfer
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Pink_5_Transfer)
                    .padding(top = 5.dp, start = 10.dp, bottom = 10.dp, end = 10.dp)

            ) {
                Text(
                    text = "실종일자/지역",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text = viewModel.missingAddress.value,
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp), color = Color.LightGray
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = "특징",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.width(80.dp)
                )

                Text(
                    text ="아직 애기여서 큰소리를 내면 도망가요",
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

        }//Column

        Spacer(modifier = Modifier.height(20.dp))

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "${viewModel.commentnumber.value}개의 제보가 작성되었습니다.",
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            fontSize = 15.sp,
            color = Black_40_Transfer,
            modifier = Modifier.padding(start = 22.dp)
        )



        if (viewModel.commentnumber.value == "0") {

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "소중한 가족을 찾아주세요.\n" +
                        "허위제보 시 이용에 제한을 받을 수 있습니다.",
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 14.sp,
                color = Black_40_Transfer,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
        }else{
            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(modifier = Modifier.height(150.dp)){
                items(viewModel.commentlist){ item->
                    CommentItem(
                        onModifiy = { /*TODO*/ },
                        onDelete = { viewModel.deletefindmypetcomment() },
                        comment = item.comment,
                        photo = if(item.photoUrls.isEmpty()) null else item.photoUrls[0].photoUrl ,
                        name = item.comment,
                        createtime = item.id.toString(),
                        ismycomment = true
                    )
                    
                    SpacerHeight(dp = 10.dp)
                }
            }
        }



        Spacer(modifier = Modifier.weight(1f))


        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 15.dp)
        ) {

            TextField(
                value = value,
                onValueChange = setvaluse,
                enabled = false,
                modifier = Modifier
                    .weight(8f)
                    .height(45.dp)
                    .clickable {
                        navController.navigate(Common.FINDANIMAL_COMMENT_SCREEN)
                    },
                shape = RoundedCornerShape(20.5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,
                ),
                placeholder = {
                    Text(
                        text = "제보를 입력해주세요.",
                        fontSize = 11.sp,
                        modifier = Modifier.fillMaxHeight()
                    )
                },
            )

            Image(
                painter = painterResource(id = R.drawable.img_send),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .height(25.dp)
                    .width(25.dp)
            )

        }

    }

}

@Composable
fun FindAnimalDetailImage(image: Int) {
    Image(
        painter = rememberImagePainter(data = image),
        contentDescription = null,
        modifier = Modifier
            .height(165.dp)
            .width(165.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun FindAnimalDetailImage2(image: String) {
    Image(
        painter = rememberImagePainter(data = image),
        contentDescription = null,
        modifier = Modifier
            .height(165.dp)
            .width(165.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun CommentItem(
    onModifiy: () -> Unit,
    onDelete: () -> Unit,
    comment: String,
    photo: String?,
    name: String,
    createtime: String,
    ismycomment: Boolean,
) {
    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "라마짱",
                fontFamily = notosans_bold,
                color = Black_60_Transfer,
                fontSize = 13.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )//Text


            SpacerWidth(dp = 20.dp)
            Text(
                text = "방금 전",
                fontFamily = notosans_regular,
                color = Black_30_Transfer,
                fontSize = 10.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            if (ismycomment) {
                Text(
                    text = "수정",
                    fontFamily = notosans_regular,
                    color = Black_30_Transfer,
                    fontSize = 13.sp,
                    modifier = Modifier.clickable {
                        onModifiy()
                    },
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )


                SpacerWidth(dp = 15.dp)


                Text(
                    text = "삭제",
                    fontFamily = notosans_regular,
                    color = Black_30_Transfer,
                    fontSize = 13.sp,
                    modifier = Modifier.clickable {
                        onDelete()
                    },
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

            }


        }

        SpacerHeight(dp = 10.dp)

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = comment,
                fontFamily = notosans_regular,
                color = Black_60_Transfer,
                fontSize = 13.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )//Text

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = rememberImagePainter(data = photo),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop

            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.2.dp),
            color = Black_30_Transfer
        )
    }//Column

}

