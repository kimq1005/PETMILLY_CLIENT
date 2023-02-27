package com.llama.petmilly_client.presentation.findanimalscreen.findanimaldetailscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FADetailViewModel @Inject constructor():ViewModel() {
    val missingday = mutableStateOf("")
    val missinglocation = mutableStateOf("")
    val missingclothes = mutableStateOf("")
    val issnood = mutableStateOf("")
    val missingspecies = mutableStateOf("")

    val isopencomment = mutableStateOf(true)
}