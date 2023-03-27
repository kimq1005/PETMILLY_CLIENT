package com.llama.petmilly_client.presentation.moveservicscreen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.moveservice.postmoveservice.MoveServicePostDTO
import com.llama.petmilly_client.data.model.moveservice.postmoveservice.MoveServicePostList
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject


@HiltViewModel
class MoveServiceViewModel  @Inject constructor(
    private val petMillyRepo: PetMillyRepo
) :  ViewModel(){

    val categorytest: MutableList<CategoryTest> = arrayListOf()

    val cat = mutableStateOf(true)
    val dog = mutableStateOf(true)
    val isComplete = mutableStateOf(false)
    val weight = mutableListOf<String>()

    val postDto: MutableLiveData<MoveServicePostDTO> = MutableLiveData<MoveServicePostDTO>()
    val postDataList = mutableStateListOf<MoveServicePostList>()

    fun getmoveservicepost() {
        viewModelScope.launch(Dispatchers.IO) {
            petMillyRepo.getmoveservicepost(
                MainApplication.accessToken,
                1,
                5,
                cat.value,
                dog.value,
                isComplete.value,
                weight,
                "moveVolunteer"
            ).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        it.data?.let { data ->
                            postDto.postValue(data)
                            Log.d(Common.TAG, "getpost:$it ")
                            setPostData()
                        }
                    }

                    else -> {
                        Log.d(Common.TAG, "getpost ERROR: $it")
                    }

                }

            }
        }

    }

    private fun setPostData() {
        viewModelScope.launch(Dispatchers.Main) {
            postDataList.clear()
            postDto.value?.let {
                if(it.data!=null){
                    postDataList.addAll(it.data.list)
                }
                Log.d(Common.TAG, "setPostData: ${postDataList.size}")
            }
        }
    }


}