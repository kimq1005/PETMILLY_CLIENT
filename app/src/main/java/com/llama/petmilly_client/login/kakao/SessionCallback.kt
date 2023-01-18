package com.llama.petmilly_client.login.kakao

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeV2ResponseCallback
import com.kakao.usermgmt.response.MeV2Response
import com.kakao.util.exception.KakaoException
import com.llama.petmilly_client.MainApplication
import llama.test.jetpack_dagger_plz.utils.Common.TAG

class SessionCallback(val context :Context): ISessionCallback {
    override fun onSessionOpened() {
        Toast.makeText(MainApplication.instance, "Successfully logged in to Kakao. Now creating or updating a Firebase User",
            Toast.LENGTH_LONG).show()

        UserManagement.getInstance().me(object :MeV2ResponseCallback(){
            override fun onSuccess(result: MeV2Response?) {
               if(result !=null){
                   Log.d(TAG, "onSuccess: 세션 오픈")
                   val accessToken = Session.getCurrentSession().tokenInfo.accessToken


               }
            }

            override fun onSessionClosed(errorResult: ErrorResult?) {
            }

        })
    }

    override fun onSessionOpenFailed(exception: KakaoException?) {
    }
}