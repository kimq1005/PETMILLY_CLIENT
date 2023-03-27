package com.llama.petmilly_client

import android.app.Application
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
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@HiltAndroidApp
class MainApplication : Application() {


    companion object {
        lateinit var instance: MainApplication

        var kakaoaccesesstoken = ""

        var accessToken= ""

        var refreshToken = ""

        var signupname = ""

        var categorylist = listOf<String>(
            "강아지","고양이","petmily ❤️","~7kg","7~15kg","15kg~"
        )

    }



    override fun onCreate() {
        super.onCreate()

        var keyHash = Utility.getKeyHash(this)

        KakaoSdk.init(this, getString(R.string.kakao_api_key))

    }

}