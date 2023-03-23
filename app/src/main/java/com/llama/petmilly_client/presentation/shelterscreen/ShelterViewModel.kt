package com.llama.petmilly_client.presentation.shelterscreen

import android.util.Log
import android.view.View
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.post.postdto.PostDTO
import com.llama.petmilly_client.data.model.post.postdto.PostData
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import com.llama.petmilly_client.presentation.homescreen.items.ShelterListCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    val animalname = mutableStateOf<String>("")
    val animalgenter = mutableStateOf<String>("")
    val animalage = mutableStateOf(0)
    val animalspecies = mutableStateOf<String>("")
    val animalweight = mutableStateOf<Int>(0)

    private val _sheltercategory = mutableStateOf(emptyList<String>())
    val sheltercategory: State<List<String>> = _sheltercategory


    val categorytest: MutableList<CategoryTest> = arrayListOf()
    val shelterListCategory: MutableList<ShelterListCategory> = arrayListOf()
    var testBoolean = mutableStateOf<Boolean>(true)
    var isjudge = mutableStateOf(1)

    val cat = mutableStateOf(true)
    val dog = mutableStateOf(true)
    val isComplete = mutableStateOf(false)
    val weight = mutableStateOf("")
    val type = mutableStateOf("temporaryProtection")

    val postDto: MutableLiveData<PostDTO> = MutableLiveData<PostDTO>()
    val postDataList = mutableStateListOf<PostData>()


    init {
        testsetcategory()
        setsheltercategory()
    }

    fun setanimalinfovalue() {
        animalname.value = "박종경"
        animalgenter.value = "혼종"
        animalage.value = 5
        animalspecies.value = "바부"
        animalweight.value = 100

    }

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


    fun setcategory() {

        val entity = CategoryTest("전체")
        val puppy = CategoryTest("강아지")
        val cat = CategoryTest("고양이")
        val adoptcomplete = CategoryTest("입양/귀가완료")
        val saveshelter = CategoryTest("임보처구해요")
        val findmybaby = CategoryTest("우리아이 찾아요")
        val movevolunteer = CategoryTest("이동봉사 찾아요")
        val adoptionnotice = CategoryTest("입양 공고")


        categorytest.add(entity)
        categorytest.add(puppy)
        categorytest.add(cat)
        categorytest.add(adoptcomplete)
        categorytest.add(saveshelter)
        categorytest.add(findmybaby)
        categorytest.add(movevolunteer)
        categorytest.add(adoptionnotice)
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

    fun testsetcategory() {
        _sheltercategory.value = listOf("전체", "강아지", "고양이", "입양/귀가완료", "~7kg", "7~15kg", "15kg~")
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
                if(weight.value!="") weight.value else null,
                "temporaryProtection"
            ).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        it.data?.let {data->
                            postDto.postValue(data)
                            Log.d(TAG, "getpost:$it ")
                        }

                        setPostData()
//
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
            postDto.value?.let {
                postDataList.addAll(it.data.list)
                Log.d(TAG, "setPostData: ${postDataList.size}")
            }
        }
    }


}