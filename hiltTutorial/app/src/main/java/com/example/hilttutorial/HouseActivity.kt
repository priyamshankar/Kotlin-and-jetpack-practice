package com.example.hilttutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.hilttutorial.Model.House
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HouseActivity : ComponentActivity(){
    @Inject
    lateinit var house : House
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        house.alert()
    }

}