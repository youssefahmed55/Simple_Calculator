package com.calculatooor.simple_calculator.viewmodel


import androidx.lifecycle.ViewModel
import com.calculatooor.simple_calculator.util.CalcUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



class CalcViewModel : ViewModel() {

    private val _expressionState = MutableStateFlow("")
    val expressionState = _expressionState.asStateFlow()

    private val _errorState = MutableStateFlow("")
    val errorState = _errorState.asStateFlow()



    fun getResult(txt: String){
        try {
            _expressionState.update { CalcUtil.eval(txt).toString() }
        }catch (e: Exception){
            _errorState.update { e.message.toString() }
        }
    }

    fun parseText(char:String){
        _expressionState.update { expressionState.value + char }
        _errorState.update {""}
    }

    fun clear(){
        _expressionState.update { _expressionState.value.substring(0,_expressionState.value.length-1)}
        _errorState.update {""}
    }

    fun clearAll(){
        _expressionState.update {""}
        _errorState.update {""}
    }


}

