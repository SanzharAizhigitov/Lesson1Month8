package com.example.lesson1month8.data.mappers

import com.example.lesson1month8.data.model.NoteEntity
import com.example.lesson1month8.domain.model.Note

fun Note.toEntity() = NoteEntity(id, title, desc)

fun NoteEntity.toNote() = Note(id, title, desc)