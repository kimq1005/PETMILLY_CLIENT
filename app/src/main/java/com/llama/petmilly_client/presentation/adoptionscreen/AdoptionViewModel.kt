package com.llama.petmilly_client.presentation.adoptionscreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import javax.inject.Inject

class AdoptionViewModel @Inject constructor(

) : ViewModel() {
    val categorytest: MutableList<CategoryTest> = arrayListOf()
    val numberofanimal= mutableStateOf(1)


    //comment
    val findlocation = mutableStateOf("")
    val finddeeplocation = mutableStateOf("")

    val findyear = mutableStateOf("")
    val findmonth = mutableStateOf("")
    val findday = mutableStateOf("")
    val findtime = mutableStateOf("")

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