package com.llama.petmilly_client.presentation.shelterscreen

import android.util.Log
import android.view.View
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.post.postdto.PostDTO
import com.llama.petmilly_client.data.model.post.postdto.PostData
import com.llama.petmilly_client.data.model.temporary.detail.*
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import com.llama.petmilly_client.presentation.homescreen.items.ShelterListCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject

@HiltViewModel
class ShelterViewModel @Inject constructor(
    private val petMillyRepo: PetMillyRepo,
) : ViewModel() {

    var isDialogShown by mutableStateOf(false)
        private set

    var isAdoptionApplicationDialogShown by mutableStateOf(false)
        private set


    val categorytest: MutableList<CategoryTest> = arrayListOf()
    val shelterListCategory: MutableList<ShelterListCategory> = arrayListOf()
    var isjudge = mutableStateOf(1)

    val cat = mutableStateOf(true)
    val dog = mutableStateOf(true)
    val isComplete = mutableStateOf(false)
    val weight = mutableListOf<String>()
    val categorylist:MutableList<String> = arrayListOf()

    val postDto: MutableLiveData<PostDTO> = MutableLiveData<PostDTO>()
    val postDataList = mutableStateListOf<PostData>()

    //임보처 구해요 상세조회
    val id = mutableStateOf(0)
    val temporarydetailDTO : MutableLiveData<TemporarydetailDTO> = MutableLiveData<TemporarydetailDTO>()
    val temporarydetailList = mutableStateListOf<Data>()

    val charmAppeal_detail = mutableStateOf("")
    val name_detail = mutableStateOf("")
    val gender_detail =  mutableStateOf("")
    val weight_detail =  mutableStateOf("")
    val breed_detail =  mutableStateOf("")
    val age_detail = mutableStateOf("")
    val neutered_detail = mutableStateOf("")
    val inoculation_detail = mutableStateOf("")
    val health_detail = mutableStateOf("")
    val skill_detail = mutableStateOf("")
    val character_detail = mutableStateOf("")
    val pickUp_detail = mutableStateOf("")
    val receptionPeriod_detail = mutableStateOf("")
    val isReceipt_detail = mutableStateOf(false)
    val isCompleted_detail = mutableStateOf(false)
    val shortName_detail = mutableStateOf("")
    val thumbnail_detail = mutableStateOf("")
    val photoUrl_detail = mutableStateListOf<PhotoUrl>()

    val ProtectionCondition = mutableStateListOf<ProtectionCondition>()
    val ProtectionHope = mutableStateListOf<ProtectionHope>()
    val ProtectionNo = mutableStateListOf<ProtectionNo>()




    fun onConfirmClick() {
        isDialogShown = true
    }

    fun onDismissDialog() {
        isDialogShown = false
    }

    fun onAdoptionDialogConfirmClick() {
        isAdoptionApplicationDialogShown = true
    }

    fun onAdoptionDialogDismissDialog() {
        isAdoptionApplicationDialogShown = false
    }

    fun addcategorylist(title: String){
        categorylist.add(title)

        Log.d(TAG, "addcategorylist: $categorylist")
    }

    fun deletecategorylist(title: String){
        categorylist.remove(title)
        Log.d(TAG, "deletecategorylist: $categorylist")
    }

    fun setsheltercategory() {

        val puppy = ShelterListCategory("강아지")
        val cat = ShelterListCategory("고양이")
        val petmily = ShelterListCategory("petmily ❤️")
        val small = ShelterListCategory("~7kg")
        val middle = ShelterListCategory("7~15kg")
        val big = ShelterListCategory("15kg~")

        shelterListCategory.add(puppy)
        shelterListCategory.add(cat)
        shelterListCategory.add(petmily)
        shelterListCategory.add(small)
        shelterListCategory.add(middle)
        shelterListCategory.add(big)
    }



    fun getpost() {
        viewModelScope.launch(Dispatchers.IO) {
            petMillyRepo.getpost(
                MainApplication.accessToken,
                1,
                5,
                cat.value,
                dog.value,
                isComplete.value,
                weight,
                "temporaryProtection"
            ).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        it.data?.let { data ->
                            postDto.postValue(data)
                            Log.d(TAG, "getpost:$it ")
                            setPostData()
                        }
                    }

                    else -> {
                        Log.d(TAG, "getpost ERROR: $it")
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
                Log.d(TAG, "setPostData: ${postDataList.size}")
            }
        }
    }

    fun gettemporarydetail() {
        viewModelScope.launch(Dispatchers.IO) {
            petMillyRepo.gettemporarydetail(MainApplication.accessToken,id.value).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        it.data?.let { item->
                            val data = item.data
                            temporarydetailDTO.postValue(item)
                            charmAppeal_detail.value = data.charmAppeal
                            name_detail.value = data.name
                            gender_detail.value = data.gender
                            weight_detail.value = data.weight.toString()
                            breed_detail.value = data.breed.toString()
                            age_detail.value = if(data.age>1) "${data.age.toInt()}살 추정" else "${data.age * 10}개월 추정"
                            neutered_detail.value = data.neutered
                            inoculation_detail.value = data.inoculation
                            health_detail.value = data.health
                            skill_detail.value = data.skill
                            character_detail.value = data.character
                            pickUp_detail.value = data.pickUp
                            receptionPeriod_detail.value= data.receptionPeriod
                            isReceipt_detail.value = data.isReceipt
                            isCompleted_detail.value = data.isComplete
                            shortName_detail.value = data.addressInfo.shortName
                            thumbnail_detail.value = data.thumbnail?.photoUrl ?: ""
                            photoUrl_detail.addAll(data.photoUrls)

                            Log.d(TAG, "gettemporarydetail: $data")
                        }
//                        setProtectionCondition()
                    }
                    else -> {
                        Log.d(TAG, "gettemporarydetail ERROR: $it ")
                    }
                }
            }
        }
    }

    private fun setProtectionCondition(){
        viewModelScope.launch(Dispatchers.Main) {
            temporarydetailDTO.value?.let {
                ProtectionCondition.addAll(it.data.ProtectionCondition)
                ProtectionHope.addAll(it.data.ProtectionHope)
                ProtectionNo.addAll(it.data.ProtectionNo)
            }
        }
    }


}