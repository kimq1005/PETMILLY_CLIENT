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
import dagger.hilt.android.HiltAndroidApp
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@HiltAndroidApp
class MainApplication : Application() {


    companion object {
        lateinit var instance: MainApplication

        var kakaoaccesesstoken = ""

        var accessToken= ""

        var refreshToken = ""
    }


    override fun onCreate() {
        super.onCreate()

        var keyHash = Utility.getKeyHash(this)

        KakaoSdk.init(this, getString(R.string.kakao_api_key))
//        Log.d(TAG, "onCreate: $")
//        if(KakaoSDK.getAdapter() == null){
//            KakaoSDK.init(KaKaoSDKAdapter(getAppContext()))
//        }
    }
//    override fun onTerminate() {
//        super.onTerminate()
//        instance = null
//    }

//    fun getAppContext() : MainApplication{
//        checkNotNull(instance){
//            "This Application does not inherit com.example.App"
//        }
//        return instance!!
//    }
}