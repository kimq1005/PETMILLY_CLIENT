package com.llama.petmilly_client

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kakao.auth.KakaoAdapter
import com.kakao.auth.KakaoSDK
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import com.llama.petmilly_client.login.kakao.KaKaoSDKAdapter
import com.llama.petmilly_client.presentation.homescreen.items.ShelterListCategory
import dagger.hilt.android.HiltAndroidApp
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.ACCESSTOKEN
import llama.test.jetpack_dagger_plz.utils.Common.ISLOGIN
import llama.test.jetpack_dagger_plz.utils.Common.REFRESHTOKEN
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@HiltAndroidApp
class MainApplication : Application() {


    companion object {
        private lateinit var sharedPreferences: SharedPreferences
        lateinit var instance: MainApplication

        var kakaoaccesesstoken = ""

        var accessToken = ""

        var refreshToken = ""

        var signupname = ""

        var categorylist = listOf<String>(
            "강아지", "고양이", "petmily ❤️", "~7kg", "7~15kg", "15kg~"
        )

//        fun saveAcceasdasdssToken(accessToken1: String) {
//            val editor = sharedPreferences.edit()
//            editor.putString(Common.ACCESSTOKEN, accessToken1)
//            editor.apply()
//        }

//        fun saveRefreshToken(refreshToken: String) {
//            val editor = sharedPreferences.edit()
//            editor.putString(REFRESHTOKEN, refreshToken)
//            editor.apply()
//        }
//
//
//        fun saveisLogin(refreshToken: Boolean) {
//            val editor = sharedPreferences.edit()
//            editor.putBoolean(ISLOGIN, refreshToken)
//            editor.apply()
//        }


//        fun getAccessToken(): String? {
//            return sharedPreferences.getString(ACCESSTOKEN, "")
//        }
//
//        fun getRefreshToken():String? {
//            return sharedPreferences.getString(REFRESHTOKEN, "")
//        }
//
//        fun getisLogin() : Boolean{
//            return sharedPreferences.getBoolean(ISLOGIN, false)
//        }

//        fun Logout() {
//            saveAccessToken("")
//            saveRefreshToken("")
//            saveisLogin(false)
//        }

    }


    override fun onCreate() {
        super.onCreate()

        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)

//        Log.d(TAG, "로그인 확인 : ${getisLogin()}")
        var keyHash = Utility.getKeyHash(this)
        KakaoSdk.init(this, getString(R.string.kakao_api_key))

    }

}