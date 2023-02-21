package com.llama.petmilly_client.presentation.findanimalscreen

import androidx.lifecycle.ViewModel
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FindAnimalViewModel @Inject constructor() : ViewModel() {


    val categorytest: MutableList<CategoryTest> = arrayListOf()

    fun setcategory() {

        val puppy = CategoryTest("강아지")
        val cat = CategoryTest("고양이")
        val adoptcomplete = CategoryTest("petmily ❤️")
        val saveshelter = CategoryTest("~7kg")
        val findmybaby = CategoryTest("7~15kg")
        val movevolunteer = CategoryTest("15kg~")


        categorytest.add(puppy)
        categorytest.add(cat)
        categorytest.add(adoptcomplete)
        categorytest.add(saveshelter)
        categorytest.add(findmybaby)
        categorytest.add(movevolunteer)

    }

}