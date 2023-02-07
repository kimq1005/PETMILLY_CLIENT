package com.llama.petmilly_client.presentation.homescreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.data.model.LibraryDTO.LibraryDTO
import com.llama.petmilly_client.data.model.LibraryDTO.Row
import com.llama.petmilly_client.domain.repository.GetLibraryRepo
import com.llama.petmilly_client.presentation.ClusterItem
import com.llama.petmilly_client.utils.Event
import com.naver.maps.geometry.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getLibraryRepo: GetLibraryRepo) : ViewModel() {

    val categorytest: MutableList<CategoryTest> = arrayListOf()

    val APIKEY = "6b684a65456b696d3333794b66704f"

    val libraryEntitylist: MutableLiveData<LibraryDTO> = MutableLiveData<LibraryDTO>()
    val row: MutableList<Row> = arrayListOf()

//    val items: MutableList<ClusterItem> = arrayListOf()

    private val _yeahman = MutableLiveData<List<Row>>()
    val yeahman: LiveData<List<Row>> = _yeahman
    
    val wowman:MutableList<Row> = arrayListOf()
    private val _setEvent = MutableLiveData<Event<Unit>>()
    val setEvent:LiveData<Event<Unit>> = _setEvent


    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _mytestname = MutableLiveData("")
    val mytestname : LiveData<String> = _mytestname

    init {
//        setcategory()
//        getlibrary()
    }


    fun setcategory() {

        categorytest.clear()

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

    fun setTest() {
        viewModelScope.launch(Dispatchers.Main) { 
            yeahman.value?.let {
                wowman.clear()
                wowman.addAll(it)
                Log.d(TAG, "setTest: ${wowman.size}")
            }
        }
    }

    fun getlibrary() {
        viewModelScope.launch(Dispatchers.IO) {
            getLibraryRepo.getLibrary(APIKEY, 1, 20).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        it.data?.let { data ->
                            _yeahman.postValue(data.SeoulPublicLibraryInfo.row)
                            setTest()
                        }
                    }

                    else -> {
                        Log.d(TAG, "getlibrary: ${it.status}->${it.message}")
                    }
                }

            }

        }
    }

}


data class CategoryTest(
    var title: String,
)