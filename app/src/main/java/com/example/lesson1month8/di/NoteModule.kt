package com.example.lesson1month8.di

import android.content.Context
import androidx.room.Room
import com.example.lesson1month8.data.local.NoteDao
import com.example.lesson1month8.data.local.NoteDataBase
import com.example.lesson1month8.data.repositories.NoteRepositoryImpl
import com.example.lesson1month8.domain.repositories.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NoteDataBase::class.java,
        "note_db"
    ).build()

    @Provides
    fun provideNoteDao(noteDatabase: NoteDataBase) = noteDatabase.noteDao()

    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }
}