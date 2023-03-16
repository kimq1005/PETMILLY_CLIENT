package com.llama.petmilly_client.presentation.signupscreen.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.additonal.reponse.AdditionalResponse
import com.llama.petmilly_client.data.model.additonal.reponse.CompanionAnimalInfo
import com.llama.petmilly_client.data.model.additonal.reponse.FamilyInfo
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import java.util.Collections.list
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val petMillyRepo: PetMillyRepo) : ViewModel() {

    private val _setIntent = MutableLiveData<Event<Unit>>()
    val setIntent:LiveData<Event<Unit>> = _setIntent


    val name = mutableStateOf<String>("")

    val nickname = mutableStateOf<String>("")

    val birthday = mutableStateOf<String>("")
    val birthday_year = mutableStateOf("")
    val birthday_month = mutableStateOf("")
    val birthday_day = mutableStateOf("")


    val gender = mutableStateOf<String>("")
    val job = mutableStateOf<String>("")

    //companionAnimal
    val livewithanimal = mutableStateOf("")


    //companionAnimalCount
    val numberofanimal = mutableStateOf("")

    val callyouranimalcheck = mutableStateOf(false)

    val breed_animal = mutableStateOf("")
    val age_animal = mutableStateOf("")
    val gender_animal = mutableStateOf("")
    val neutered_animal = mutableStateOf("")


    val companionAnimalInfo: MutableList<CompanionAnimalInfo> = arrayListOf()

    //temporaryProtection
    val istemporarycare = mutableStateOf("")

    //allergy
    val isallery = mutableStateOf("")

    @SuppressLint("MutableCollectionMutableState")
    val familyInfo = mutableStateOf(mutableListOf<FamilyInfo>())


    //typeOfResidence
    val housekind = mutableStateOf("")

    val additionalResponse = AdditionalResponse(
        gender = gender.value,
        name = name.value,
        nickname = nickname.value,
        birthday = birthday.value,
        job = job.value,
        companionAnimal = livewithanimal.value,
        companionAnimalCount = numberofanimal.value,
        companionAnimalInfo = companionAnimalInfo,
        temporaryProtection = istemporarycare.value,
        familyInfo = familyInfo.value,
        allergy = isallery.value,
        typeOfResidence = housekind.value
    )


    fun addFamilyInfo(newFamilyInfo: FamilyInfo) {
        familyInfo.value.add(newFamilyInfo)
    }

    fun deletefamilyInfo(newFamilyInfo:FamilyInfo){
        familyInfo.value.remove(newFamilyInfo)
    }


    fun updateFamilyInfo(familyInfo: FamilyInfo) {
        val index = this.familyInfo.value.indexOfFirst { it.role == familyInfo.role }
        if (index >= 0) {
            this.familyInfo.value[index] = familyInfo
        }
    }

    fun clearanimalcheck() {
        breed_animal.value = ""
        age_animal.value = ""
        gender_animal.value = ""
        neutered_animal.value = ""
        callyouranimalcheck.value = !callyouranimalcheck.value
    }


    fun postadditionalinfo() {
        viewModelScope.launch(Dispatchers.IO) {
            val additionalResponse = AdditionalResponse(
                gender = gender.value,
                name = name.value,
                nickname = nickname.value,
                birthday = birthday.value,
                job = job.value,
                companionAnimal = livewithanimal.value,
                companionAnimalCount = numberofanimal.value,
                companionAnimalInfo = companionAnimalInfo,
                temporaryProtection = istemporarycare.value,
                familyInfo = familyInfo.value,
                allergy = isallery.value,
                typeOfResidence = housekind.value
            )

            Log.d(TAG, "postadditionalinfo: ${MainApplication.accessToken}")
            Log.d(TAG, "postadditionalinfo: $additionalResponse")
            

            petMillyRepo.postadditonalinfo(MainApplication.accessToken, additionalResponse).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        Log.d(TAG, "postadditionalinfo SUCCRESS: ${it}")
                        _setIntent.postValue(Event(Unit))

                    }

                    else -> {
                        Log.d(TAG, "postadditionalinfo ELSE: $it")
                    }
                }
            }
        }
    }

}