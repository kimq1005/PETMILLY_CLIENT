package com.llama.petmilly_client.presentation.shelterscreen

import android.util.Log
import android.view.View
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import dagger.hilt.android.lifecycle.HiltViewModel
import llama.test.jetpack_dagger_plz.utils.Common.TAG

class ShelterViewModel() : ViewModel() {

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

    init {
        testsetcategory()
    }

    fun setanimalinfovalue() {
        animalname.value = "박종경"
        animalgenter.value = "혼종"
        animalage.value = 5
        animalspecies.value = "호구"
        animalweight.value = 100

    }

    fun onConfirmClick(){
        isDialogShown = true
    }

    fun onDismissDialog(){
        isDialogShown = false
    }

    fun onAdoptionDialogConfirmClick(){
        isAdoptionApplicationDialogShown = true
    }

    fun onAdoptionDialogDismissDialog(){
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

    fun testsetcategory() {
        _sheltercategory.value = listOf("전체", "강아지", "고양이", "입양/귀가완료", "~7kg", "7~15kg", "15kg~")

    }
}