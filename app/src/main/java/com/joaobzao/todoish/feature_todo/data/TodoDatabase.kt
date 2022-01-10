package com.joaobzao.todoish.feature_todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joaobzao.todoish.feature_todo.data.daos.TodoDao
import com.joaobzao.todoish.feature_todo.data.entities.Todo

@Database(
    entities = [
        Todo::class
    ],
    version = 1
)
abstract class TodoDatabase: RoomDatabase() {

    abstract val todoDao: TodoDao
}