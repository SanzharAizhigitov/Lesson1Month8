package com.example.lesson1month8.domain.usecase

import com.example.lesson1month8.domain.model.Note
import com.example.lesson1month8.domain.repositories.NoteRepository

class RemoveNoteUseCase (
    private val noteRepository: NoteRepository
){

    fun removeNote(note: Note) = noteRepository.removeNote(note)
}