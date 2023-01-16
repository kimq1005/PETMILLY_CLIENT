package com.llama.petmilly_client.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.domain.repository.TestRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val testRepo: TestRepo) : ViewModel(){

    fun testapi(){
        viewModelScope.launch {
            testRepo.getNewsArticles().let {
                when(it.status){
                    RemoteResult.Status.SUCCESS->{
                        Log.d(TAG, "testapi: ${it.status}-> ${it.data}")
                    }

                    else->{
                        Log.d(TAG, "testapi: ${it.status} ")
                    }

                }
            }
        }
    }
}