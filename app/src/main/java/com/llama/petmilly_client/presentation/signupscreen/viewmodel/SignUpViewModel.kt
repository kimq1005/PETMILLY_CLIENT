package com.llama.petmilly_client.presentation.signupscreen.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import llama.test.jetpack_dagger_plz.utils.Common.TAG

class SignUpViewModel : ViewModel() {
    val name = mutableStateOf<String>("")

    val nickname = mutableStateOf<String>("")

    val birthday = mutableStateOf<String>("")


    val gender = mutableStateOf<String>("")
    val job = mutableStateOf<String>("")

    val livewithanimal= mutableStateOf("")


    //call your animal
    val callyouranimalcheck= mutableStateOf(false)
    val animalgender = mutableStateOf<String>("")
    val isneuteringsurgery = mutableStateOf<Boolean>(false)
    val animalkind = mutableStateOf<String>("")
    val animalage = mutableStateOf("")

    //istemporarycare
    val istemporarycare = mutableStateOf(false)

    //isallergy
    val isallery = mutableStateOf(0)

    //housekind
    val housekind = mutableStateOf("")

    fun checkCallYourAnimal(){
        callyouranimalcheck.value =  animalkind.value!="" && animalage.value !="" && animalgender.value !=""
        Log.d(TAG, "checkCallYourAnimal:${animalkind.value} ${animalage.value} ${animalgender.value} =>  ${callyouranimalcheck.value}")
    }

}