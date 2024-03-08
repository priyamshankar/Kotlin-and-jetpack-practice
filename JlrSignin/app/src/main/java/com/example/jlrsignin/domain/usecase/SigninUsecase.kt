package com.example.jlrsignin.domain.usecase

import android.util.Log
import com.example.jlrsignin.data.repository.temp

class SigninUsecase {
  fun invoke():String{
        return temp().invoke()
    }
}