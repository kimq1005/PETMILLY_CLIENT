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

    private val _showProgress = MutableLiveData<Event<Unit>>()
    val showProgress: LiveData<Event<Unit>> = _showProgress

    private val _closeProgress = MutableLiveData<Event<Unit>>()
    val closeProgress: LiveData<Event<Unit>> = _closeProgress


    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _mytestname = MutableLiveData("")
    val mytestname : LiveData<String> = _mytestname

    val selelctedcategory = mutableStateOf("")

    init {
//        setcategory()
//        getlibrary()
    }


    fun setcategory() {

        categorytest.clear()

        val puppy = CategoryTest("강아지")
        val cat = CategoryTest("고양이")
        val entity = CategoryTest("petmily ❤️")
        val saveshelter = CategoryTest("임보처구해요")
        val findmybaby = CategoryTest("우리아이 찾아요")
        val movevolunteer = CategoryTest("이동봉사 찾아요")
        val adoptionnotice = CategoryTest("입양 공고")


        categorytest.add(puppy)
        categorytest.add(cat)
        categorytest.add(entity)
        categorytest.add(saveshelter)
        categorytest.add(findmybaby)
        categorytest.add(movevolunteer)
        categorytest.add(adoptionnotice)
        categorytest.add(adoptionnotice)

    }

    fun checklibrary(){
        _showProgress.postValue(Event(Unit))
        getlibrary()
    }

    fun setlibrary() {
        viewModelScope.launch(Dispatchers.Main) { 
            yeahman.value?.let {
                wowman.clear()
                wowman.addAll(it)
                Log.d(TAG, "setlibrary: ${wowman.size}")
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
                            setlibrary()
                            Log.d(TAG, "getlibrary SUCCESS")
                        }
                    }

                    else -> {
                        Log.d(TAG, "getlibrary ELES $it")
                    }
                }
                _setEvent.postValue(Event(Unit))
                _closeProgress.postValue(Event(Unit))

            }

        }
    }

}


data class CategoryTest(
    var title: String,
)