package com.joaobzao.todoish.feature_todo.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) override val id: Long = 0,
    override val title: String,
    override val timestamp: Long
): TodoEntity

class InvalidTodoException(message: String): Exception(message)