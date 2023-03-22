package com.llama.petmilly_client.presentation.certificationscreen

import android.util.Log
import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.locationauthenticationResponse.LocationauthenticationResponse
import com.llama.petmilly_client.domain.repository.GetLibraryRepo
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject


@HiltViewModel
class CertificationViewModel @Inject constructor(private val petMillyRepo: PetMillyRepo) :
    ViewModel() {


    private val _setshelterIntent = MutableLiveData<Event<Unit>>()
    val setshelterIntent: LiveData<Event<Unit>> = _setshelterIntent

    val townadress = mutableStateOf("")


    fun posttownauth(){
        if(townadress.value != ""){
            viewModelScope.launch(Dispatchers.IO) {
                petMillyRepo.posttownauth(MainApplication.accessToken, LocationauthenticationResponse(townadress.value)).let {
                    when(it.status){
                        RemoteResult.Status.SUCCESS->{
                            Log.d(TAG, "posttownauth SUCCESS: $it ")
                            _setshelterIntent.postValue(Event(Unit))
                        }

                        else-> {
                            Log.d(TAG, "posttownauth ERROR: $it")
                        }
                    }
                }
            }
        }
    }

}