package com.example.lesson1month8.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

class Note(
    val id: Int = DEFAULT_ID,
    val title: String,
    val desc: String

) {
    companion object{
        const val DEFAULT_ID = 0
    }
}