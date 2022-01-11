package com.joaobzao.todoish.feature_todo.domain.repositories

import com.joaobzao.todoish.feature_todo.data.entities.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getTodos(): Flow<List<Todo>>

    suspend fun getTodoById(id: Long): Todo

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)
}