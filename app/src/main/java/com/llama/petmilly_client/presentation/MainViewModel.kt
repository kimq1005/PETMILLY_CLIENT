package com.llama.petmilly_client.presentation

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.domain.repository.TestRepo
import com.llama.petmilly_client.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val petMillyRepo: PetMillyRepo) : ViewModel() {

    private val _model1 = MutableLiveData<Event<Unit>>()
    val model1: LiveData<Event<Unit>> = _model1

    private val _setHomeIntent = MutableLiveData<Event<Unit>>()
    val setHomeIntent: LiveData<Event<Unit>> = _setHomeIntent

    private val _setsignupIntent = MutableLiveData<Event<Unit>>()
    val setsignupIntent: LiveData<Event<Unit>> = _setsignupIntent

    private val _yeah = mutableStateOf(Event(Unit))
    val yeah: State<Event<Unit>> = _yeah


    fun postkakaotoken() {
        if (MainApplication.kakaoaccesesstoken != "") {
            viewModelScope.launch(Dispatchers.IO) {
                val kaKaoResponse = KaKaoResponse(MainApplication.kakaoaccesesstoken)
                petMillyRepo.postkakaotoken(kaKaoResponse).let {
                    when (it.status) {
                        RemoteResult.Status.SUCCESS -> {
                            it.data?.let { data ->
                                Log.d(TAG, "postkakaotoken: $data")
                                Log.d(TAG, "postkakaotoken: ${data.data.tokenList.accessToken}")
                                Log.d(TAG, "postkakaotoken: ${data.data.isExistAdditionalInfo}")
                                val accessToken = data.data.tokenList.accessToken
                                val refreshToken = data.data.tokenList.refreshToken

                                MainApplication.accessToken = accessToken ?: ""
                                MainApplication.refreshToken = refreshToken ?: ""

                                if (!data.data.isExistAdditionalInfo) {
                                    _setsignupIntent.postValue(Event(Unit))
                                } else {
                                    if (MainApplication.accessToken != "" && MainApplication.refreshToken != "") {
//                                        _setHomeIntent.postValue(Event(Unit))
                                    }
                                }


                            }
                        }
                        RemoteResult.Status.REFRESH -> {
                            Log.d(TAG, "postkakaotoken Refresh: ${it.status}->${it.message}")
                        }

                        RemoteResult.Status.ERROR -> {
                            Log.d(TAG, "postkakaotoken ERROR: ${it.status}->${it.message}")
                        }

                        else -> {
                            Log.d(TAG, "postkakaotoken: ${it}")


                        }
                    }
                }
            }
        }

    }

    var isDialogShown by mutableStateOf(false)
        private set

    fun onBuyClick() {
        isDialogShown = true
    }

    fun onDismissDialog() {
        isDialogShown = false
    }
}