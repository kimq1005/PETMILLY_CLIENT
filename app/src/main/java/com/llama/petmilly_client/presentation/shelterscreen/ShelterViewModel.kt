package com.llama.petmilly_client.presentation.shelterscreen

import android.util.Log
import android.view.View
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import llama.test.jetpack_dagger_plz.utils.Common.TAG

class ShelterViewModel(): ViewModel() {

    private val _sheltercategory = mutableStateOf(emptyList<String>())
    val sheltercategory:State<List<String>> = _sheltercategory



    fun testsetcategory(){
        _sheltercategory.value = listOf("전체","강아지","고양이","입양/귀가완료", "~7kg" , "7~15kg", "15kg~")
        Log.d(TAG, "testsetcategory: ${sheltercategory.value} ")
    }
}