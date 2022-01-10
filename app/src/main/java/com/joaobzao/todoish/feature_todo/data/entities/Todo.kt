package com.joaobzao.todoish.feature_todo.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val timestamp: Long
)