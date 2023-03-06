package com.llama.petmilly_client.presentation.apppushscreen

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.widget.SwitchCompat
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat.animate
import androidx.hilt.navigation.compose.hiltViewModel
import com.llama.petmilly_client.presentation.shelterscreen.TitleBar
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular


class AppPushActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel:AppPushViewModel = hiltViewModel()
            AppPushScreen(viewModel)
        }
    }
}

@Composable
fun AppPushScreen(viewModel: AppPushViewModel) {

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)) {
        TitleBar(title = "앱 푸시 알림설정", ismenu = false, clickBack = { }) {

        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "서비스 알림",
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            fontSize = 14.sp,
            color = Black_80_Transfer,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Pink_5_Transfer)
                .height(40.dp)
                .padding(start = 40.dp, top = 9.dp, bottom = 9.dp),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(20.dp))

        AppPushRaw("게시물 댓글", viewModel.commentCheck.value)

        Spacer(modifier = Modifier.height(20.dp))

        Divider(Modifier.padding(horizontal = 29.dp), color = Black_10_Transfer)

        Spacer(modifier = Modifier.height(20.dp))


        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 36.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "채팅메세지",
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontSize = 14.sp,
                    color = Black_80_Transfer
                )

                Text(
                    text = "채팅문의 ,임보/입양 신청서 접수 & 결과 알림 ",
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontSize = 12.sp,
                    color = Black_60_Transfer
                )

            }


            Spacer(modifier = Modifier.weight(1f))

            CustomSwitchButton(
                1.dp,
                44.dp,
                24.dp,
                viewModel.chattingCheck.value
            )


        }

        Spacer(modifier = Modifier.height(20.dp))

        Divider(Modifier.padding(horizontal = 29.dp), color = Black_10_Transfer)

        Spacer(modifier = Modifier.height(20.dp))

        AppPushRaw(text = "관심동물 상태 변경 알림", value = viewModel.favoriteanimalstateCheck.value)

        Spacer(modifier = Modifier.height(20.dp))

        Divider(Modifier.padding(horizontal = 29.dp), color = Black_10_Transfer)

        Spacer(modifier = Modifier.height(20.dp))

        AppPushRaw(text = "임보/입양 완료 근황 업로드 알림", value = viewModel.temporaryCheck.value)

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "마케팅 / 프로모션",
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            fontSize = 14.sp,
            color = Black_80_Transfer,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Pink_5_Transfer)
                .height(40.dp)
                .padding(start = 40.dp, top = 9.dp, bottom = 9.dp),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(20.dp))

        AppPushRaw(text = "펫밀리 마케팅/프로모션 알림", value = viewModel.marketingCheck.value)


    }
}

@Preview
@Composable
fun AppPushPreview() {
    val viewModel: AppPushViewModel = hiltViewModel()
    AppPushScreen(viewModel)
}

@Composable
fun AppPushRaw(text: String, value: Boolean) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp)
    ) {
        Text(
            text = text,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            fontSize = 14.sp,
            color = Black_80_Transfer
        )


        Spacer(modifier = Modifier.weight(1f))

        CustomSwitchButton(
            1.dp,
            44.dp,
            24.dp,
            value
        )


    }
}


@Composable
fun CustomSwitchButton(
    switchPadding: Dp,
    buttonWidth: Dp,
    buttonHeight: Dp,
    value: Boolean,
) {

    val switchSize by remember {
        mutableStateOf(buttonHeight - switchPadding * 2)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    var switchClicked by remember {
        mutableStateOf(value)
    }

    var padding by remember {
        mutableStateOf(0.dp)
    }

    padding = if (switchClicked) buttonWidth - switchSize - switchPadding * 2 else 0.dp

    val animateSize by animateDpAsState(
        targetValue = if (switchClicked) padding else 0.dp,
        tween(
            durationMillis = 100,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    Box(
        modifier = Modifier
            .width(buttonWidth)
            .height(buttonHeight)
            .clip(CircleShape)
            .background(if (switchClicked) Category_Cliked else Color.LightGray)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {

                switchClicked = !switchClicked

            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(switchPadding)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(animateSize)
                    .background(Color.Transparent)
            )

            Box(
                modifier = Modifier
                    .size(switchSize)
                    .clip(CircleShape)
                    .background(Color.White)
            )

        }
    }

}