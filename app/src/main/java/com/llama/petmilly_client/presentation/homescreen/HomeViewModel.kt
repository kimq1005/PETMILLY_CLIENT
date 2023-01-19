package com.llama.petmilly_client.presentation.homescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.data.model.LibraryDTO.LibraryDTO
import com.llama.petmilly_client.data.model.LibraryDTO.Row
import com.llama.petmilly_client.domain.repository.GetLibraryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getLibraryRepo: GetLibraryRepo) : ViewModel() {

    val categorytest: MutableList<CategoryTest> = arrayListOf()

    val APIKEY = "6b684a65456b696d3333794b66704f"

    val libraryEntitylist :MutableList<LibraryDTO> = arrayListOf()
    val row :MutableList<Row> = arrayListOf()

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

    fun getlibrary() {
        viewModelScope.launch {
            getLibraryRepo.getLibrary(APIKEY, 1, 5).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        it.data?.let {data->

                            row.addAll(data.SeoulPublicLibraryInfo.row)
                            Log.d(TAG, "SUCCESS : ${data.SeoulPublicLibraryInfo.list_total_count}")
                        }
                    }

                    else -> {
                        Log.d(TAG, "getlibrary: ${it.status}-->${it.message}")
                    }
                }
            }

        }
    }
}


data class CategoryTest(
    var title: String,
)