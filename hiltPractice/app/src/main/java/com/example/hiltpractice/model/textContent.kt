package com.example.hiltpractice.model

import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

//@HiltAndroidApp

class textContent @Inject constructor() {
    fun addTextContent():String{
        return "this message is trvelled through hilt android"
    }
}