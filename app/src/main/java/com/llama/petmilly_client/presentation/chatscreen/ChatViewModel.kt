package com.llama.petmilly_client.presentation.chatscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.llama.petmilly_client.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ChatViewModel @Inject constructor() : ViewModel() {

    private val _setDialog = MutableLiveData<Event<Unit>>()
    val setDialog: LiveData<Event<Unit>> = _setDialog

    var isChatRoomDialog by mutableStateOf(false)
        private set

    var isAdoptionApplicationDialog by mutableStateOf(false)
        private set

    fun onShowAdoptionApplcationDialog(){
        isAdoptionApplicationDialog = true
    }

    fun onDismissAdoptionApplicationDialog(){
        isAdoptionApplicationDialog = false
    }
    fun onChatRoomDialog(){
        isChatRoomDialog = true
    }

    fun DismissChatRoomDialog(){
        isChatRoomDialog = false
    }

    fun setDialog(){
       _setDialog.value = Event(Unit)
    }


}