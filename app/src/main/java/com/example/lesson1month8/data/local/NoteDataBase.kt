package com.example.lesson1month8.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lesson1month8.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {

    abstract fun noteDao():NoteDao
}