package com.llama.petmilly_client.presentation.moveservicscreen.moveservicedetail

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen.ImageTestUriData
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class MoveServiceDetailViewModel @Inject constructor(
    private val petMillyRepo: PetMillyRepo,
) : ViewModel() {
    private val _setfinsh = MutableLiveData<Event<Unit>>()
    val setfinsh: LiveData<Event<Unit>> = _setfinsh


    val startAddress = mutableStateOf("")
    val endAddress = mutableStateOf("")
    val animalTypes = mutableStateOf("")
    val name = mutableStateOf("")
    val gender = mutableStateOf("")
    val weight = mutableStateOf("")
    val breed = mutableStateOf("")
    val age = mutableStateOf("")
    val etc = mutableStateOf("")
    val hopeDate = mutableStateOf("")
    val files = mutableStateListOf<MultipartBody.Part>()

    val move_year = mutableStateOf("")
    val move_month = mutableStateOf("")
    val move_day = mutableStateOf("")

    val imageTestUriData = mutableStateListOf<ImageTestUriData>()


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
    fun postmoveservicepost() {

        val startAddress = startAddress.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val endAddress = endAddress.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val animalTypes = animalTypes.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val name = name.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val gender = gender.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val weight = weight.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val breed = breed.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val age = age.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val etc = etc.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")
        val dateString = "${hopeDate.value} 10:00:00"
        val date = LocalDateTime.parse(dateString, formatter)
        val hopeapplicationperiod =
            RequestBody.create("text/plain".toMediaTypeOrNull(), date.toString())
        Log.d(TAG, "postmoveservicepost: $dateString")

        viewModelScope.launch(Dispatchers.IO) {
            petMillyRepo.postmoveservicepost(
                MainApplication.accessToken,
                startAddress,
                endAddress,
                animalTypes,
                name,
                gender,
                weight,
                breed,
                age,
                etc,
                hopeapplicationperiod,
                files
            ).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        Log.d(TAG, "postmoveservicepost SUCCESS: $it")
                        _setfinsh.postValue(Event(Unit))
                    }
                    else -> {
                        Log.d(TAG, "postmoveservicepost: $it")
                    }
                }
            }
        }
    }

}