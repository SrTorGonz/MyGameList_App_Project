package com.example.mygamelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val profilePicUrl = MutableLiveData<String>()
}