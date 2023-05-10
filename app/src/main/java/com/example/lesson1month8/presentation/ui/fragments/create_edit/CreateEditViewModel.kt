package com.example.lesson1month8.presentation.ui.fragments.create_edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson1month8.domain.model.Note
import com.example.lesson1month8.domain.usecase.CreateNoteUseCase
import com.example.lesson1month8.domain.usecase.EditNoteUseCase
import com.example.lesson1month8.domain.utils.Resource
import com.example.lesson1month8.presentation.ui.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CreateEditViewModel @Inject constructor(
    private val editNoteUseCase: EditNoteUseCase,
    private val createNoteUseCase: CreateNoteUseCase
) : ViewModel() {
    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    fun editNote(note: Note) {
        viewModelScope.launch {
            editNoteUseCase.editNote(note).collect() { res ->
                when (res) {
                    is Resource.Error -> {
                        _editNoteState.value = UIState.Error(res.message!!)
                    }

                    is Resource.Loading -> {
                        _editNoteState.value = UIState.Loading()
                    }

                    is Resource.Success -> {
                        if (res.data != null)
                            _editNoteState.value = UIState.Success(res.data)
                    }
                }

            }
        }
    }
    fun createNote(note: Note) {
        viewModelScope.launch {
            createNoteUseCase.createNote(note).collect() { res ->
                when (res) {
                    is Resource.Error -> {
                        _createNoteState.value = UIState.Error(res.message!!)
                    }

                    is Resource.Loading -> {
                        _createNoteState.value = UIState.Loading()
                    }

                    is Resource.Success -> {
                        if (res.data != null)
                            _createNoteState.value = UIState.Success(res.data)
                    }
                }

            }
        }
    }
}