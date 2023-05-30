package com.llama.petmilly_client.presentation.loginscreen

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.R
import com.llama.petmilly_client.fcm.NotificationActivity
import com.llama.petmilly_client.mqtt.MqttActivity
import com.llama.petmilly_client.presentation.MainViewModel
import com.llama.petmilly_client.presentation.homescreen.BottomNavItem
import com.llama.petmilly_client.presentation.homescreen.HomeActivity
import com.llama.petmilly_client.presentation.homescreen.HomeViewModel
import com.llama.petmilly_client.presentation.signupscreen.SignUpActivity
import com.llama.petmilly_client.ui.theme.*
import com.llama.petmilly_client.utils.SpacerHeight
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun LoginScreen(navController: NavController, viewModel: MainViewModel) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MainBackgroundColor)
            .padding(top = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.pet_milly_title),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        SpacerHeight(dp = 18.dp)

        Image(
            painter = painterResource(id = R.drawable.mainicon_png),
            contentDescription = null,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
        )

        SpacerHeight(dp = 18.dp)

        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.title_Description),
            fontSize = 13.sp,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        //
        Spacer(modifier = Modifier.weight(1f))


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, bottom = 70.dp)
                .height(60.dp)
                .background(color = KaKao_BackgroundColor, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .clickable { viewModel.onBuyClick() },
        ) {
            Text(
                text = stringResource(id = R.string.kakao_login_text),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 18.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),

                )

        }

        if (viewModel.isDialogShown) {
            CustomDialog(
                onDismiss = {
                    viewModel.onDismissDialog()

                    val intent = Intent(context, NotificationActivity::class.java)
                    context.startActivity(intent)

//                    val intent = Intent(context, MqttActivity::class.java)
//                    context.startActivity(intent)
                },
                onConfirm = {
                    viewModel.onDismissDialog()
                    val intent = Intent(context, HomeActivity::class.java)
                    context.startActivity(intent)
//                    if(MainApplication.getisLogin()){
//                        val intent = Intent(context, HomeActivity::class.java)
//                        context.startActivity(intent)
//                    }else{
//                        kakaoLogin(context,viewModel)
//
//                    }


                }
            )
        }
    }

    LaunchedEffect(context){
        setObserve(viewModel,context,lifecycleOwner)
    }

}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .fillMaxHeight(0.20f)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = stringResource(id = R.string.kakao_login_dialog_text),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {
                    Button(
                        onClick = { onDismiss() },
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp, end = 5.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Button_NoneClicked)


                    ) {
                        Text(
                            text = "취소",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Button(
                        onClick = { onConfirm() },
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 5.dp, end = 20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Button_Clicked)

                    ) {
                        Text(
                            text = "열기",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

fun kakaoLogin(context: Context,viewModel: MainViewModel) {
//    Log.d(TAG, "kakaoLogin: siba")
    viewModel.postkakaotoken()


    val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.d(TAG, "로그인 실패 -> $error ")
            Toast.makeText(context, "카카오톡 로그인 실패", Toast.LENGTH_SHORT).show()
        } else if (token != null) {
            Log.d(TAG, "로그인 성공: ${token.accessToken}")
            viewModel.postkakaotoken()

//            val intent = Intent(context, HomeActivity::class.java)
//            context.startActivity(intent)

        }
    }

    if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            if (error != null) {
                // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우
                Log.d(TAG, "로그인 실패 두번째 -> $error")
                if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                    return@loginWithKakaoTalk
                }
                // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)

            } else if (token != null) {
                MainApplication.kakaoaccesesstoken = token.accessToken
                Log.d(TAG, "카카오 로그인 성공! 두번째 : ${MainApplication.kakaoaccesesstoken} ")
                viewModel.postkakaotoken()


                UserApiClient.instance.me { user, error ->
                    if (error != null) {
                        Log.d(TAG, "사용자 정보 요청 실패", error)
                    } else if (user != null) {

                    }
                }

            } else {
                UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
                Log.d(TAG, "넌 뭐니? : ")
            }

        }
    }
}

private fun setObserve(viewModel: MainViewModel, context: Context, lifecycleOwner: LifecycleOwner) {
    viewModel.setHomeIntent.observe(lifecycleOwner, Observer {
//        MainApplication.saveisLogin(true)
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)
    })

    viewModel.setsignupIntent.observe(lifecycleOwner, Observer {

        val intent = Intent(context, SignUpActivity::class.java)
        context.startActivity(intent)

    })
}