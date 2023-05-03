package com.example.lesson1month8.domain.usecase

import com.example.lesson1month8.domain.repositories.NoteRepository

class GetAllNoteUseCase (
    private val noteRepository: NoteRepository
        ){
    fun getAllNotes() = noteRepository.getAllNote()
}