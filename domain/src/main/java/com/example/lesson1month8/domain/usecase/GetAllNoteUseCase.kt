package com.example.lesson1month8.domain.usecase

import com.example.lesson1month8.domain.repositories.NoteRepository
import javax.inject.Inject

class GetAllNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
        ){
    fun getAllNotes() = noteRepository.getAllNote()
}