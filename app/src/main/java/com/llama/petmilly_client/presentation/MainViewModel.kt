package com.llama.petmilly_client.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.domain.repository.TestRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val petMillyRepo: PetMillyRepo) : ViewModel(){

    fun postkakaotoken(){
        viewModelScope.launch(Dispatchers.IO) {
            val kaKaoResponse = KaKaoResponse(MainApplication.kakaoaccesesstoken)
            petMillyRepo.postkakaotoken(kaKaoResponse).let {
                when(it.status){
                    RemoteResult.Status.SUCCESS->{
                        it.data.let {data->
                            Log.d(TAG, "postkakaotoken: $data")
                        }
                    }

                    else->{
                        Log.d(TAG, "postkakaotoken: ${it.status}->${it.message}")
                    }
                }
            }
        }
    }
    var isDialogShown by mutableStateOf(false)
        private set

    fun onBuyClick(){
        isDialogShown = true
    }

    fun onDismissDialog(){
        isDialogShown = false
    }
}