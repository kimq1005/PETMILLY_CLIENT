package com.llama.petmilly_client.presentation.findanimalscreen

import android.net.Uri
import android.os.Build
import android.util.Log
import android.widget.ExpandableListView
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.findmypet.findmypetdetail.Comment
import com.llama.petmilly_client.data.model.temporary.detail.PhotoUrl
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
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
import okio.utf8Size
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class FindAnimalViewModel @Inject constructor(
    private val petMillyRepo: PetMillyRepo,
) : ViewModel() {

    private val _showProgress = MutableLiveData<Event<Unit>>()
    val showProgress: LiveData<Event<Unit>> = _showProgress

    private val _closeProgress = MutableLiveData<Event<Unit>>()
    val closeProgress: LiveData<Event<Unit>> = _closeProgress

    private val _setIntent = MutableLiveData<Event<Unit>>()
    val setIntent: LiveData<Event<Unit>> = _setIntent


    val categorytest: MutableList<CategoryTest> = arrayListOf()
    val numberofanimal = mutableStateOf(1)
    val id = mutableStateOf(3)
    val commentid = mutableStateOf(3)
    val animalTypes = mutableStateOf("")
    val name = mutableStateOf("")
    val gender = mutableStateOf("")
    val weight = mutableStateOf("")
    val breed = mutableStateOf("")
    val age = mutableStateOf("")
    val etc = mutableStateOf("")
    val missingDate = mutableStateOf("")
    val missingAddress = mutableStateOf("")
    val clothes = mutableStateOf("")
    val lead = mutableStateOf("")
    val isPublic = mutableStateOf(false)
    val isComplete = mutableStateOf(false)
    val isDeleted = mutableStateOf(false)
    val createdAt = mutableStateOf(false)
    val updatedAt = mutableStateOf("")
    val photoUrl =
        mutableListOf<com.llama.petmilly_client.data.model.findmypet.findmypetdetail.PhotoUrl>()
    val commentnumber = mutableStateOf("0")
    val commentlist = mutableStateListOf<Comment>()

    //comment
    val missing_year = mutableStateOf("")
    val missing_month = mutableStateOf("")
    val missing_day = mutableStateOf("")

    val imageTestUriData = mutableStateListOf<ImageTestUriData>()
    val files = mutableStateListOf<MultipartBody.Part>()
    val sightingAddress = mutableStateOf("")
    val comment = mutableStateOf("")
    val sightingDate = mutableStateOf("")
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

    fun setcategory() {

        val puppy = CategoryTest("강아지")
        val cat = CategoryTest("고양이")
        val adoptcomplete = CategoryTest("petmily ❤️")
        val saveshelter = CategoryTest("~7kg")
        val findmybaby = CategoryTest("7~15kg")
        val movevolunteer = CategoryTest("15kg~")


        categorytest.add(puppy)
        categorytest.add(cat)
        categorytest.add(adoptcomplete)
        categorytest.add(saveshelter)
        categorytest.add(findmybaby)
        categorytest.add(movevolunteer)

    }

    fun getfindmypetdetail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {

            petMillyRepo.getfindmypetdetail(MainApplication.accessToken, id).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        it.data?.let { it ->

                            commentlist.clear()
                            photoUrl.clear()
                            val item = it.data
                            animalTypes.value = item.animalTypes
                            name.value = item.name
                            gender.value = item.gender
                            weight.value = item.weight.toString()
                            breed.value = item.breed
                            age.value =
                                if (item.age > 0) "${item.age}살 추정" else "${item.age * 10}개월 추정"
                            etc.value = item.etc
                            clothes.value = item.clothes
                            lead.value = item.lead
                            missingAddress.value = item.missingAddress
                            photoUrl.addAll(item.photoUrls)

                            if (item.comment.isNotEmpty()) {
                                commentnumber.value = "${item.comment.size}"
                                commentlist.addAll(item.comment)
                            }

                        }
                        Log.d(TAG, "getfindmypetdetail SUCCESS: $it")
                    }

                    else -> {
                        Log.d(TAG, "getfindmypetdetail ERROR: $it")
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun postfindmypetcomment() {

        val sightingAddress = sightingAddress.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val comment = comment.value.toRequestBody("text/plain".toMediaTypeOrNull())
        val formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")
        val dateString = "${sightingDate.value} 10:00:00"
        val date = LocalDateTime.parse(dateString, formatter)
        val hopeapplicationperiod =
            RequestBody.create("text/plain".toMediaTypeOrNull(), date.toString())
        viewModelScope.launch(Dispatchers.IO) {
            _showProgress.postValue(Event(Unit))
            petMillyRepo.postfindmypetcomment(
                token = MainApplication.accessToken,
                id = id.value,
                files,
                sightingAddress = sightingAddress,
                comment = comment,
                sightingDate = hopeapplicationperiod
            ).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        Log.d(TAG, "postfindmypetcomment SUCCESS: $it")
                        delay(3000)
                        _closeProgress.postValue(Event(Unit))
                        _setIntent.postValue(Event(Unit))
                    }
                    else -> {
                        Log.d(TAG, "postfindmypetcomment ERROR: $it")
                    }
                }

            }
        }
    }

    fun deletefindmypetcomment(){
        viewModelScope.launch(){
            _showProgress.postValue(Event(Unit))
            petMillyRepo.deletefindmypetcomment(
                MainApplication.accessToken,
                id.value,
                commentid.value
            ).let {
                when(it.status){
                    RemoteResult.Status.SUCCESS->{
                        Log.d(TAG, "deletefindmypetcomment SUCCESS : $it")
                        delay(3000)
                        getfindmypetdetail(id.value)
                        _closeProgress.postValue(Event(Unit))
                    }

                    else->{
                        Log.d(TAG, "deletefindmypetcomment ERROR: $it")
                    }
                }
            }
        }
    }

}