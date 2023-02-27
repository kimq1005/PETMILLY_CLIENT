package com.llama.petmilly_client.presentation.myprofilescreen

import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor():ViewModel() {
    val changenickname = mutableStateOf("")
}