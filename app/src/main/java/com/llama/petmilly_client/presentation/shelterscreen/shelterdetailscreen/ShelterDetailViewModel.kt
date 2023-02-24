package com.llama.petmilly_client.presentation.shelterscreen.shelterdetailscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShelterDetailViewModel @Inject constructor() : ViewModel() {
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
}