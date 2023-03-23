package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.internal.format
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ShelterDetailViewModel @Inject constructor(
    private val petMillyRepo: PetMillyRepo,
) : ViewModel() {

    private val _setcompleted = MutableLiveData<Event<Unit>>()
    val setcompleted: LiveData<Event<Unit>> = _setcompleted

    private val _setnotcompleted = MutableLiveData<String>()
    val setnotcompleted: LiveData<String> = _setnotcompleted

    val myuri = mutableStateOf<Uri?>(null)
    val imageTestUriData = mutableStateListOf<ImageTestUriData>()

    var isAlmostCompletedDialog by mutableStateOf(false)
        private set


    val files = mutableStateListOf<MultipartBody.Part>()
    val charmAppeal = mutableStateOf("")
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

    val apstartyear = mutableStateOf("")


    val apendyear = mutableStateOf("")


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
        Log.d(TAG, "addtemporaryProtectionCondition: $temporaryProtectionConditionList")

    }

    fun deletetemporaryProtectionCondition(text: String) {
        temporaryProtectionCondition.remove(text)
        temporaryProtectionConditionList.remove(text)
    }


    fun addtemporaryProtectionHope(text: String) {
        temporaryProtectionHope.add(text)
        temporaryProtectionHopeList.add(text)

        Log.d(TAG, "addtemporaryProtectionHope: $temporaryProtectionHopeList")
    }

    fun deletetemporaryProtectionHope(text: String) {
        temporaryProtectionHope.remove(text)
        temporaryProtectionHopeList.remove(text)


    }

    fun addtemporaryProtectionNo(text: String) {
        temporaryProtectionNo.add(text)
        temporaryProtectionNoList.add(text)
        Log.d(TAG, "addtemporaryProtectionNo: $temporaryProtectionNoList")
    }

    fun deletetemporaryProtectionNo(text: String) {
        temporaryProtectionNo.remove(text)
        temporaryProtectionNoList.remove(text)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun posttemporaryprotection() {


//        val dateString = hopeapplicationperiod.value

        val charmAppeal = charmAppeal.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val species = species.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animalname = animalname.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animalsex = animalsex.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animalkg = animalkg.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animaldetailspecies =
            animaldetailspecies.value.toRequestBody("text/plain".toMediaTypeOrNull())
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
        val temporaryProtectionNo: List<RequestBody> =
            temporaryProtectionNoList.map {
                RequestBody.create("text/plain".toMediaTypeOrNull(), it)
            }
        val now = LocalTime.now()

        viewModelScope.launch(Dispatchers.IO) {
            petMillyRepo.posttemporaryprotection(
                MainApplication.accessToken,
                files ?: null,
                charmAppeal,
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
                startReceptionPeriod = if (apstartyear.value != "") {
                    val formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")
                    val dateString = "${apstartyear.value} 10:00:00"
                    val date = LocalDateTime.parse(dateString, formatter)
                    val hopeapplicationperiod = RequestBody.create("text/plain".toMediaTypeOrNull(), date.toString())
                    hopeapplicationperiod
                } else null,
                endReceptionPeriod = if (apendyear.value != "") {
                    val formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")
                    val dateString = "${apendyear.value} 10:00:00"
                    val date = LocalDateTime.parse(dateString, formatter)
                    val hopeapplicationperiod = RequestBody.create("text/plain".toMediaTypeOrNull(), date.toString())
                    hopeapplicationperiod
                } else null,
                temporaryProtectionCondition ?: null,
                temporaryProtectionHope ?: null,
                temporaryProtectionNo ?: null
            ).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        Log.d(TAG, "posttemporaryprotection SUCCESS: $it")
                        _setcompleted.postValue(Event(Unit))
                    }
                    else -> {
                        Log.d(TAG, "posttemporaryprotection ERROR: $it")
                        _setnotcompleted.postValue(it.message)
                    }

                }
            }
        }
    }

}