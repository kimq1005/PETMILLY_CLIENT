package com.llama.petmilly_client.presentation.moveservicscreen.moveservicedetail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoveServiceDetailViewModel @Inject constructor() : ViewModel() {
    val movestartplace = mutableStateOf("")
    val movearriveplace = mutableStateOf("")
    val moveserviceday = mutableStateOf("")
    val movesiginificant = mutableStateOf("")

}