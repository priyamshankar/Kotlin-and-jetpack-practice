package com.example.hiltpractice.viewModel

import androidx.lifecycle.ViewModel
import com.example.hiltpractice.model.textContent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//class MainViewModel
@HiltViewModel
class MainViewModel @Inject constructor(
//    private val contextTextObj : textContent
)
    :ViewModel()
{
    @Inject lateinit var contextTextObj : textContent
    fun getContextText ():String{
        return contextTextObj.addTextContent()
    }
}