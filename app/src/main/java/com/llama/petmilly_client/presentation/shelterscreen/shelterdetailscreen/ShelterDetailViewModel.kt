package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.llama.petmilly_client.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShelterDetailViewModel @Inject constructor() : ViewModel() {

    private val _setHomeIntent = MutableLiveData<Event<Unit>>()
    val setHomeIntent: LiveData<Event<Unit>> = _setHomeIntent

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

    val hopepeople = mutableStateOf("")
    val nopeople = mutableStateOf("")

    val hopeapplicationperiod = mutableStateOf("")


    fun onShownAlmostCompetedDialog() {
        isAlmostCompletedDialog = true
    }

    fun onDismissAlmostCompetedDialog() {
        isAlmostCompletedDialog = false
    }

    fun uploadimage(uri:Uri){
        imageTestUriData.add(ImageTestUriData(uri))
    }

    fun deleteimage(uri:Uri){
        imageTestUriData.remove(ImageTestUriData(uri))
    }
}