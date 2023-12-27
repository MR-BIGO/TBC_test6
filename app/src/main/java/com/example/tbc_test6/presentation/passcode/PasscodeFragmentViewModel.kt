package com.example.tbc_test6.presentation.passcode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbc_test6.data.common.Constants.Companion.PASSCODE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PasscodeFragmentViewModel: ViewModel() {

    private val _itemFlow = MutableStateFlow<String>("")
    val itemFlow: StateFlow<String> = _itemFlow.asStateFlow()

    fun newSymbol(symbol: String){
        viewModelScope.launch {
            _itemFlow.value.plus(symbol)
            if (_itemFlow.value.length == 4){
                if (_itemFlow.value == PASSCODE){

                }else{
                    _itemFlow.value = ""
                }
            }
        }
    }


}