package com.joaobzao.todoish.todo.data.repository

import com.joaobzao.todoish.todo.data.daos.TodoDao
import com.joaobzao.todoish.todo.data.entities.Todo
import com.joaobzao.todoish.todo.domain.repositories.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val dao: TodoDao
): TodoRepository {
    override fun getTodos(): Flow<List<Todo>> =
        dao.getTodos()

    override suspend fun getTodoById(id: Long): Todo =
        dao.getTodoById(id)

    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }
}