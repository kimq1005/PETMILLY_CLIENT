package com.llama.petmilly_client.presentation.signupscreen.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    val name = mutableStateOf<String>("")

    val nickname = mutableStateOf<String>("")

    val birthday = mutableStateOf<String>("")

    val testhi = mutableStateOf<String>("")
}