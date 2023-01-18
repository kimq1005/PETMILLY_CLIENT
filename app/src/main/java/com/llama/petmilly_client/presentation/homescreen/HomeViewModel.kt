package com.llama.petmilly_client.presentation.homescreen

import androidx.lifecycle.ViewModel

class HomeViewModel:ViewModel() {

    val categorytest: MutableList<CategoryTest> = arrayListOf()


    fun setcategory(){

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
}



data class CategoryTest(
    var title:String
)