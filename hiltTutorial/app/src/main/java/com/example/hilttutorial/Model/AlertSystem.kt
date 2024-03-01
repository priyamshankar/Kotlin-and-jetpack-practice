package com.example.hilttutorial.Model

import javax.inject.Inject

class AlertSystem @Inject constructor() {
    fun alert(){
        println("Alerted the system By me")
    }
}