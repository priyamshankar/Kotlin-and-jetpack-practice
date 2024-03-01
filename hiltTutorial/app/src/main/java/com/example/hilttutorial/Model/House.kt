package com.example.hilttutorial.Model

import javax.inject.Inject

class House @Inject constructor(
    var alertSystem : AlertSystem
){
//    @Inject lateinit var alertSystem : AlertSystem
    fun alert(){
        alertSystem.alert()

    }
}