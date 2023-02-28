package com.llama.petmilly_client.presentation.signupscreen.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import java.util.Collections.list
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel  @Inject constructor(private val petMillyRepo: PetMillyRepo) : ViewModel() {
    val name = mutableStateOf<String>("")

    val nickname = mutableStateOf<String>("")

    val birthday = mutableStateOf<String>("")


    val gender = mutableStateOf<String>("")
    val job = mutableStateOf<String>("")

    val livewithanimal= mutableStateOf("")



    //call your animal
    val numberofanimal= mutableStateOf(1)
    val callyouranimalcheck= mutableStateOf(false)
    val animalgender = mutableStateOf<String>("수컷")
    val isneuteringsurgery = mutableStateOf<Boolean>(true)
    val animalkind = mutableStateOf<String>("")
    val animalage = mutableStateOf("")


    //istemporarycare
    val istemporarycare = mutableStateOf(true)

    //isallergy
    val isallery = mutableStateOf(0)

    //housekind
    val housekind = mutableStateOf("")

    val famillylist = mutableStateListOf<String>(

    )
    @SuppressLint("SuspiciousIndentation")


    fun checkCallYourAnimal(){
        callyouranimalcheck.value =  animalkind.value!="" && animalage.value !="" && animalgender.value !=""
        Log.d(TAG, "checkCallYourAnimal:${animalkind.value} ${animalage.value} ${animalgender.value} =>  ${callyouranimalcheck.value}")
    }

}