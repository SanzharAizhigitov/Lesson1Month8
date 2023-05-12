package com.example.lesson1month8.presentation.ui.fragments.create_edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson1month8.domain.model.Note
import com.example.lesson1month8.domain.usecase.CreateNoteUseCase
import com.example.lesson1month8.domain.usecase.EditNoteUseCase
import com.example.lesson1month8.domain.utils.Resource
import com.example.lesson1month8.presentation.base.BaseViewModel
import com.example.lesson1month8.presentation.ui.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CreateEditViewModel @Inject constructor(
    private val editNoteUseCase: EditNoteUseCase,
    private val createNoteUseCase: CreateNoteUseCase
) : BaseViewModel() {
    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    fun editNote(note: Note) {
       editNoteUseCase.editNote(note).collectData(_editNoteState)
               }
    fun createNote(note: Note) {
        createNoteUseCase.createNote(note).collectData(_createNoteState)
    }
}