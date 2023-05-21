package com.example.lesson1month8.domain.usecase

import com.example.lesson1month8.domain.model.Note
import com.example.lesson1month8.domain.repositories.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {
    fun createNote(note: Note) = noteRepository.createNote(note)
}