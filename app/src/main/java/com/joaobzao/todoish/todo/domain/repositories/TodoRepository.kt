package com.joaobzao.todoish.todo.domain.repositories

import com.joaobzao.todoish.todo.data.entities.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getTodos(): Flow<List<Todo>>

    suspend fun getTodoById(id: Long): Todo

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)
}