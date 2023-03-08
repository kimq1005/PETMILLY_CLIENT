package com.llama.petmilly_client.presentation.signupscreen.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.additonal.reponse.AdditionalResponse
import com.llama.petmilly_client.data.model.additonal.reponse.CompanionAnimalInfo
import com.llama.petmilly_client.data.model.additonal.reponse.FamilyInfo
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
class SignUpViewModel @Inject constructor(private val petMillyRepo: PetMillyRepo) : ViewModel() {
    val name = mutableStateOf<String>("")

    val nickname = mutableStateOf<String>("")

    val birthday = mutableStateOf<String>("")
    val birthday_year = mutableStateOf("")
    val birthday_month = mutableStateOf("")
    val birthday_day = mutableStateOf("")


    val gender = mutableStateOf<String>("")
    val job = mutableStateOf<String>("")

    val livewithanimal = mutableStateOf("")


    //call your animal
    val numberofanimal = mutableStateOf("")
    val callyouranimalcheck = mutableStateOf(false)
    val animalgender = mutableStateOf<String>("수컷")
    val isneuteringsurgery = mutableStateOf<Boolean>(true)
    val animalkind = mutableStateOf<String>("")
    val animalage = mutableStateOf("")

    val gender_first = mutableStateOf("")
    val breed_first = mutableStateOf("")
    val age_first = mutableStateOf(0)
    val neutered_first = mutableStateOf("")

    val checkwithanimal = mutableStateOf(0)

    val companionAnimalInfo_first = CompanionAnimalInfo(
        breed_first.value,
        age_first.value,
        gender_first.value,
        neutered_first.value
    )
    val companionAnimalInfo_second = CompanionAnimalInfo(
        breed_first.value,
        age_first.value,
        gender_first.value,
        neutered_first.value
    )
    val companionAnimalInfo_third = CompanionAnimalInfo(
        breed_first.value,
        age_first.value,
        gender_first.value,
        neutered_first.value
    )

    val companionAnimalInfo: MutableList<CompanionAnimalInfo> = arrayListOf()
    val familyInfo: MutableList<FamilyInfo> = arrayListOf()

    //istemporarycare
    val istemporarycare = mutableStateOf("")

    //isallergy
    val isallery = mutableStateOf("")

    //housekind
    val housekind = mutableStateOf("")

    val famillylist = mutableStateListOf<String>(

    )

    @SuppressLint("SuspiciousIndentation")

    fun setbirthday(){

    }
    fun checkCallYourAnimal() {
        callyouranimalcheck.value =
            animalkind.value != "" && animalage.value != "" && animalgender.value != ""
        Log.d(
            TAG,
            "checkCallYourAnimal:${animalkind.value} ${animalage.value} ${animalgender.value} =>  ${callyouranimalcheck.value}"
        )
    }


    fun postadditionalinfo() {
        viewModelScope.launch(Dispatchers.IO) {
            val additionalResponse = AdditionalResponse(
                name = name.value,
                nickname = nickname.value,
                birthday = birthday.value,
                job = job.value,
                companionAnimal = livewithanimal.value,
                companionAnimalCount = numberofanimal.value,
                companionAnimalInfo = companionAnimalInfo,
                temporaryProtection = istemporarycare.value,
                familyInfo = familyInfo,
                allergy = isallery.value,
                typeOfResidence = housekind.value
            )


            petMillyRepo.postadditonalinfo(MainApplication.accessToken, additionalResponse).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        Log.d(TAG, "postadditionalinfo: ${it.message}->${it.message}")

                    }

                    else -> {
                        Log.d(TAG, "postadditionalinfo: ${it.message}->${it.message}")
                    }
                }
            }
        }
    }

    fun checkanimalwithlive() {
        when (checkwithanimal.value) {
            1 -> {
                companionAnimalInfo.add(companionAnimalInfo_first)
            }

            2 -> {
                companionAnimalInfo.add(companionAnimalInfo_first)
                companionAnimalInfo.add(companionAnimalInfo_second)

            }

            3 -> {
                companionAnimalInfo.add(companionAnimalInfo_first)
                companionAnimalInfo.add(companionAnimalInfo_second)
                companionAnimalInfo.add(companionAnimalInfo_third)

            }
        }
    }

}

