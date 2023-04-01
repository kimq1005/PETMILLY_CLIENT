package com.llama.petmilly_client.presentation.findanimalscreen.findanimaldetailscreen

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
import com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen.ImageTestUriData
import com.llama.petmilly_client.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class FADetailViewModel @Inject constructor(
    private val petMillyRepo: PetMillyRepo
):ViewModel() {

    private val _setfinsh = MutableLiveData<Event<Unit>>()
    val setfinsh: LiveData<Event<Unit>> = _setfinsh

    private val _showProgress = MutableLiveData<Event<Unit>>()
    val showProgress: LiveData<Event<Unit>> = _showProgress

    private val _closeProgress = MutableLiveData<Event<Unit>>()
    val closeProgress: LiveData<Event<Unit>> = _closeProgress


    val files = mutableStateListOf<MultipartBody.Part>()
    val animalTypes = mutableStateOf("")
    val name = mutableStateOf("")
    val gender = mutableStateOf("")
    val weight = mutableStateOf("")
    val breed = mutableStateOf("")
    val age = mutableStateOf("")
    val missingDate = mutableStateOf("")
    val missingAddress = mutableStateOf("")
    val clothes = mutableStateOf("")
    val lead = mutableStateOf("")
    val etc = mutableStateOf("")
    val isPublic = mutableStateOf(false)

    val imageTestUriData = mutableStateListOf<ImageTestUriData>()

    val missing_year = mutableStateOf("")
    val missing_month = mutableStateOf("")
    val missing_day = mutableStateOf("")


    var isAlmostCompletedDialog by mutableStateOf(false)
        private set

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

    fun updateFiles(newFiles: MultipartBody.Part) {
        files.add(newFiles)
    }

    fun deleteFiles(newFiles: MultipartBody.Part) {
        files.remove(newFiles)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun postfindmypet(){
        val animalTypes = animalTypes.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val name = name.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val gender = gender.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val weight = weight.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val breed = breed.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val age = age.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val missingAddress = missingAddress.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val clothes = clothes.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val lead = lead.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val etc = etc.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val isPublic = isPublic.value.toString().toRequestBody("text/plain".toMediaTypeOrNull())


        val formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")
        val dateString = "${missingDate.value} 10:00:00"
        val date = LocalDateTime.parse(dateString, formatter)
        val hopeapplicationperiod = RequestBody.create("text/plain".toMediaTypeOrNull(), date.toString())

        viewModelScope.launch(Dispatchers.IO) {

            petMillyRepo.postfindmypet(
                MainApplication.accessToken,
                files,
                animalTypes,
                name,
                gender,
                weight,
                breed,
                age,
                hopeapplicationperiod,
                missingAddress,
                clothes,
                lead,
                etc,
                isPublic
            ).let {
                when(it.status){
                    RemoteResult.Status.SUCCESS->{
                        Log.d(TAG, "postfind SUCCESS: $it")


                        _setfinsh.postValue(Event(Unit))
                    }

                    else->{
                        Log.d(TAG, "postfind ERROR: $it")
                    }
                }
            }
        }
    }
}