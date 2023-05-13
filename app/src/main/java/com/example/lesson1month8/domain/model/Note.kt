package com.example.lesson1month8.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

class Note(
    val id: Int = DEFAULT_ID,
    var title: String,
    var desc: String

):Serializable {
    companion object{
        const val DEFAULT_ID = 0
    }
}