package com.llama.petmilly_client.presentation.apppushscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppPushViewModel @Inject constructor() : ViewModel() {

    val commentCheck = mutableStateOf(false)
    val chattingCheck = mutableStateOf<Boolean>(false)
    val favoriteanimalstateCheck = mutableStateOf<Boolean>(false)
    val temporaryCheck = mutableStateOf<Boolean>(false)
    val marketingCheck = mutableStateOf<Boolean>(false)


}