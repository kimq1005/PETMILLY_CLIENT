package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.additonal.reponse.CompanionAnimalInfo
import com.llama.petmilly_client.data.model.temporary.TemporaryprotectionResponse
import com.llama.petmilly_client.data.network.PetMillYApiService
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ShelterDetailViewModel @Inject constructor(
    private val petMillyRepo: PetMillyRepo,
) : ViewModel() {

    private val _setHomeIntent = MutableLiveData<Event<Unit>>()
    val setHomeIntent: LiveData<Event<Unit>> = _setHomeIntent

    private val _setanimalDetailspecices= MutableLiveData<Event<Unit>>()
    val setanimalDetailspecices:LiveData<Event<Unit>> = _setanimalDetailspecices

    val myuri = mutableStateOf<Uri?>(null)
    val imageTestUriData = mutableStateListOf<ImageTestUriData>()

    var isAlmostCompletedDialog by mutableStateOf(false)
        private set


    val species = mutableStateOf("")
    val animalname = mutableStateOf("")
    val animalsex = mutableStateOf("")
    val animalkg = mutableStateOf("")
    val animaldetailspecies = mutableStateOf("")
    val animalage = mutableStateOf("")
    val isneutered = mutableStateOf("")
    val isinoculation = mutableStateOf("")
    val animalhealth = mutableStateOf("")
    val animalskill = mutableStateOf("")
    val animalpersonality = mutableStateOf("")

    val pickup = mutableStateOf("")

    val contions = mutableStateOf("")

    val temporaryProtectionCondition: MutableList<String> = arrayListOf()
    val temporaryProtectionHope: MutableList<String> = arrayListOf()
    val temporaryProtectionNo: MutableList<String> = arrayListOf()


    val hopepeople = mutableStateOf("")
    val nopeople = mutableStateOf("")

    val hopeapplicationperiod = mutableStateOf("")



    fun onShownAlmostCompetedDialog() {
        isAlmostCompletedDialog = true
    }

    fun onDismissAlmostCompetedDialog() {
        isAlmostCompletedDialog = false
    }

    fun uploadimage(uri: Uri) {
        imageTestUriData.add(ImageTestUriData(uri))
    }

    fun deleteimage(uri: Uri) {
        imageTestUriData.remove(ImageTestUriData(uri))
    }

    fun posttemporaryprotection() {

        val species = species.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animalname = animalname.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animalsex = animalsex.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animalkg = animalkg.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animaldetailspecies = animaldetailspecies.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animalage = animalage.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val isneutered = isneutered.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val isinoculation = isinoculation.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animalhealth = animalhealth.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animalskill = animalskill.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animalpersonality = animalpersonality.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val pickup = pickup.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val hopeapplicationperiod = hopeapplicationperiod.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val temporaryProtectionCondition = temporaryProtectionCondition.map {
            it.toRequestBody("text/plain".toMediaTypeOrNull())
        }
        val temporaryProtectionHope = temporaryProtectionHope.map {
            it.toRequestBody("text/plain".toMediaTypeOrNull())
        }
        val temporaryProtectionNo = temporaryProtectionNo.map {
            it.toRequestBody("text/plain".toMediaTypeOrNull())
        }

        val temporaryprotectionResponse = TemporaryprotectionResponse(
            null,
            species,
            animalname,
            animalsex,
            animalkg,
            animaldetailspecies,
            animalage,
            isneutered,
            isinoculation,
            animalhealth,
            animalskill,
            animalpersonality,
            pickup,
            hopeapplicationperiod,
            temporaryProtectionCondition,
            temporaryProtectionHope, temporaryProtectionNo
        )

        Log.d(TAG, "posttemporaryprotection: $temporaryprotectionResponse")

        viewModelScope.launch(Dispatchers.IO) {

            petMillyRepo.posttemporaryprotection(
                MainApplication.accessToken,
                temporaryprotectionResponse
            ).let {
                when(it.status){
                    RemoteResult.Status.SUCCESS->{
                        Log.d(TAG, "posttemporaryprotection SUCCESS: $it")
                    }

                    else->{
                        Log.d(TAG, "posttemporaryprotection: $it")
                    }

                }
            }
        }
    }

    fun changeformdata() {

//        val species = mutableStateOf("")
//        val animalname = mutableStateOf("")
//        val animalsex = mutableStateOf("")
//        val animalkg = mutableStateOf("")
//        val animaldetailspecies = mutableStateOf("")
//        val animalage = mutableStateOf("")
//        val isneutered = mutableStateOf("")
//        val isinoculation = mutableStateOf("")
//        val animalhealth = mutableStateOf("")
//        val animalskill = mutableStateOf("")
//        val animalpersonality = mutableStateOf("")
//
//        val pickup = mutableStateOf("")
//        val contions = mutableStateOf("")
//
//        val hopepeople = mutableStateOf("")
//        val nopeople = mutableStateOf("")
    }
}