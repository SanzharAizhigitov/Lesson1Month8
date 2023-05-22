package com.example.lesson1month8.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson1month8.presentation.ui.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    protected fun <T> Flow<com.example.lesson1month8.domain.utils.Resource<T>>.collectData(
        _state: MutableStateFlow<UIState<T>>
    ) {
        viewModelScope.launch {
            viewModelScope.launch {
                this@collectData.collect() { res ->
                    when (res) {
                        is com.example.lesson1month8.domain.utils.Resource.Error -> {
                            _state.value = UIState.Error(res.message!!)
                        }

                        is com.example.lesson1month8.domain.utils.Resource.Loading -> {
                            _state.value = UIState.Loading()
                        }

                        is com.example.lesson1month8.domain.utils.Resource.Success -> {
                            if (res.data != null)
                                _state.value = UIState.Success(res.data!!)
                        }
                    }

                }
            }
        }
    }
}