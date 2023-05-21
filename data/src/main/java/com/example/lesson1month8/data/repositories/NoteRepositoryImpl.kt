package com.example.lesson1month8.data.repositories

import com.example.lesson1month8.data.base.BaseRepository
import com.example.lesson1month8.data.local.NoteDao
import com.example.lesson1month8.data.mappers.toEntity
import com.example.lesson1month8.data.mappers.toNote
import com.example.lesson1month8.domain.model.Note
import com.example.lesson1month8.domain.repositories.NoteRepository
import com.example.lesson1month8.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject


class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : BaseRepository(), NoteRepository {
    override fun createNote(note: Note) = doRequest{
        noteDao.createNote(note.toEntity())
    }

    override fun getAllNote() = doRequest{
        noteDao.getAllNotes().map { it.toNote() }
    }

    override fun editNote(note: Note) = doRequest{
        noteDao.editNote(note.toEntity())
    }

    override fun removeNote(note: Note)= doRequest{
        noteDao.removeNote(note.toEntity())
    }


}