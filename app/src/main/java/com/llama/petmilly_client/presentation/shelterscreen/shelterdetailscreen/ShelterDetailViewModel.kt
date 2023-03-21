package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
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
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ShelterDetailViewModel @Inject constructor(
    private val petMillyRepo: PetMillyRepo,
) : ViewModel() {

    private val _setHomeIntent = MutableLiveData<Event<Unit>>()
    val setHomeIntent: LiveData<Event<Unit>> = _setHomeIntent

    private val _setanimalDetailspecices = MutableLiveData<Event<Unit>>()
    val setanimalDetailspecices: LiveData<Event<Unit>> = _setanimalDetailspecices

    val myuri = mutableStateOf<Uri?>(null)
    val imageTestUriData = mutableStateListOf<ImageTestUriData>()

    var isAlmostCompletedDialog by mutableStateOf(false)
        private set


    val files = mutableStateListOf<MultipartBody.Part>()

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


    //    var temporaryProtectionCondition: MutableList<String> = arrayListOf()
    val temporaryProtectionCondition = mutableStateListOf<String>()
    val temporaryProtectionConditionList: MutableList<String> = arrayListOf()

    val temporaryProtectionHope = mutableStateListOf<String>()
    val temporaryProtectionHopeList: MutableList<String> = arrayListOf()

    val temporaryProtectionNo = mutableStateListOf<String>()
    val temporaryProtectionNoList: MutableList<String> = arrayListOf()

    val hopepeople = mutableStateOf("")
    val nopeople = mutableStateOf("")

    val apyear = mutableStateOf("")


    val aptime = mutableStateOf("")


    fun updateFiles(newFiles: MultipartBody.Part) {
        files.add(newFiles)
    }

    fun deleteFiles(newFiles: MultipartBody.Part) {
        files.remove(newFiles)
    }

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


    fun addtemporaryProtectionCondition(text: String) {
        temporaryProtectionCondition.add(text)
        temporaryProtectionConditionList.add(text)
        Log.d(TAG, "addtemporaryProtectionCondition: ${temporaryProtectionCondition}")

    }

    fun deletetemporaryProtectionCondition(text: String) {
        temporaryProtectionCondition.remove(text)
        temporaryProtectionConditionList.remove(text)
        Log.d(TAG, "addtemporaryProtectionCondition: $temporaryProtectionCondition")
    }


    fun addtemporaryProtectionHope(text: String) {
        temporaryProtectionHope.add(text)
        temporaryProtectionHopeList.add(text)
    }

    fun deletetemporaryProtectionHope(text: String) {
        temporaryProtectionHope.remove(text)
        temporaryProtectionHopeList.remove(text)
    }

    fun addtemporaryProtectionNo(text: String) {
        temporaryProtectionNo.add(text)
        temporaryProtectionNoList.add(text)
    }

    fun deletetemporaryProtectionNo(text: String) {
        temporaryProtectionNo.remove(text)
        temporaryProtectionNoList.remove(text)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun posttemporaryprotection() {

        val foratter = DateTimeFormatter.ofPattern("yy-MM-dd HH.mm.ss")
//        val dateString = hopeapplicationperiod.value
        val dateString = "${apyear.value} ${aptime.value}"
        val date = LocalDateTime.parse(dateString, foratter)
        val hopeapplicationperiod =
            RequestBody.create("text/plain".toMediaTypeOrNull(), date.toString())

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
        val animalpersonality =
            animalpersonality.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val pickup = pickup.value.toRequestBody("text/plain".toMediaTypeOrNull())

        val temporaryProtectionCondition: List<RequestBody> = temporaryProtectionConditionList.map {
            RequestBody.create("text/plain".toMediaTypeOrNull(), it)
        }
        val temporaryProtectionHope: List<RequestBody> = temporaryProtectionHopeList.map {
            RequestBody.create("text/plain".toMediaTypeOrNull(), it)
        }
        val temporaryProtectionNo: kotlin.collections.List<RequestBody> =
            temporaryProtectionNoList.map {
                RequestBody.create("text/plain".toMediaTypeOrNull(), it)
            }

        viewModelScope.launch(Dispatchers.IO) {
            petMillyRepo.posttemporaryprotection(
                MainApplication.accessToken,
                files ?: null,
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
                temporaryProtectionHope,
                temporaryProtectionNo
            ).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        Log.d(TAG, "posttemporaryprotection SUCCESS: $it")
                    }
                    else -> {
                        Log.d(TAG, "posttemporaryprotection ERROR: $it")
                    }

                }
            }
        }
    }

//        viewModelScope.launch(Dispatchers.IO) {
//
//            petMillyRepo.posttemporaryprotection(
//                MainApplication.accessToken,
//                temporaryprotectionResponse
//            ).let {
//                when (it.status) {
//                    RemoteResult.Status.SUCCESS -> {
//                        Log.d(TAG, "posttemporaryprotection SUCCESS: $it")
//                    }
//
//                    else -> {
//                        Log.d(TAG, "posttemporaryprotection: $it")
//                    }
//
//                }
//            }
//        }
//    }

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