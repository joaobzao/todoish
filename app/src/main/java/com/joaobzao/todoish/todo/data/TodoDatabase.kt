package com.joaobzao.todoish.todo.data

import androidx.room.*
import com.joaobzao.todoish.todo.data.daos.TodoDao
import com.joaobzao.todoish.todo.data.entities.Todo

@Database(
    entities = [
        Todo::class
    ],
    version = 1
)
abstract class TodoDatabase: RoomDatabase() {

    abstract val todoDao: TodoDao

    companion object {
        const val DATABASE_NAME = "todos_db"
    }
}