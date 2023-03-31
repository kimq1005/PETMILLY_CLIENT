package com.llama.petmilly_client.presentation.moveservicscreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.moveservice.moveservicedetail.Data
import com.llama.petmilly_client.data.model.moveservice.postmoveservice.MoveServicePostDTO
import com.llama.petmilly_client.data.model.moveservice.postmoveservice.MoveServicePostList
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject


@HiltViewModel
class MoveServiceViewModel @Inject constructor(
    private val petMillyRepo: PetMillyRepo,
) : ViewModel() {

    val categorytest: MutableList<CategoryTest> = arrayListOf()

    var ismenudialog by mutableStateOf(false)
        private set


    val cat = mutableStateOf<Boolean?>(null)
    val dog = mutableStateOf<Boolean?>(null)
    val isComplete = mutableStateOf<Boolean?>(null)

    //    val weight = mutableListOf<String>()
    val weight = mutableStateOf<String?>(null)

    val postDto: MutableLiveData<MoveServicePostDTO> = MutableLiveData<MoveServicePostDTO>()
    val postDataList = mutableStateListOf<MoveServicePostList>()

    val moveservicedetaildata: MutableLiveData<Data> = MutableLiveData<Data>()
    val startAddress_detail = mutableStateOf("")
    val endAddress_detail = mutableStateOf("")
    val moveday_detail = mutableStateOf("")
    val name_detail = mutableStateOf("")
    val gender_detail = mutableStateOf("")
    val age_detail = mutableStateOf("")
    val weight_detail = mutableStateOf("")
    val etc_detail = mutableStateOf("")

    val categorylist: MutableList<String> = arrayListOf()

    fun onMenuDialog(){
        ismenudialog = true
    }

    fun onDissmissMenuDialog(){
        ismenudialog = false
    }
    fun addcategorylist(title: String) {
        categorylist.add(title)

        Log.d(TAG, "addcategorylist: $categorylist")
    }

    fun deletecategorylist(title: String) {
        categorylist.remove(title)
        Log.d(TAG, "deletecategorylist: $categorylist")
    }

    fun getmoveservicepost() {

        viewModelScope.launch(Dispatchers.IO) {
            petMillyRepo.getmoveservicepost(
                MainApplication.accessToken,
                1,
                10,
                cat.value,
                dog.value,
                isComplete.value,
                weight.value,
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

    fun getmoveservicepostdetail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            petMillyRepo.getmoveservicepostdetail(MainApplication.accessToken, id).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        it.data?.let { item ->
                            Log.d(TAG, "sibal: $it")
                            val data = item.data
                            if (item.data.hopeDate.isNotEmpty()) {
                                Log.d(
                                    TAG,
                                    "getmoveservicepostdetail: ${item.data.hopeDate[0].hopeDate}"
                                )

                            }

                            startAddress_detail.value = data.startAddress
                            endAddress_detail.value = data.endAddress
                            moveday_detail.value =
                                if (data.hopeDate.isNotEmpty()) item.data.hopeDate[0].hopeDate else ""
                            name_detail.value = data.name
                            gender_detail.value = data.gender
                            age_detail.value =
                                if (data.age > 0) "${data.age}살" else "${data.age * 10}개월"
                            weight_detail.value = "${data.weight}kg"
                            etc_detail.value = data.etc
                        }

                        Log.d(TAG, "getmoveservicepostdetail SUCCESS: $it")
                    }

                    else -> {
                        Log.d(TAG, "getmoveservicepostdetail ERROR: $it")
                    }
                }
            }
        }
    }

    private fun setPostData() {
        viewModelScope.launch(Dispatchers.Main) {
            postDataList.clear()
            postDto.value?.let {
                if (it.data != null) {
                    postDataList.addAll(it.data.list)
                }
                Log.d(Common.TAG, "setPostData: ${postDataList.size}")
            }
        }
    }


}