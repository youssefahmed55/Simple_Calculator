package com.calculatooor.simple_calculator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.calculatooor.simple_calculator.util.CalcUtil

class CalcViewModel : ViewModel() {

    val expression = mutableStateOf("")
    val error = mutableStateOf("")



    fun getResult(txt: String){
        try {
            expression.value = CalcUtil.eval(txt).toString()
        }catch (e: Exception){
            error.value = e.message.toString()
        }
    }

    fun parseText(char:String){
        expression.value += char
        error.value = ""
    }

    fun clear(){
        expression.value = expression.value.substring(0,expression.value.length-1)
        error.value = ""
    }

    fun clearAll(){
        expression.value = ""
        error.value = ""
    }


}

