package com.joaobzao.todoish.feature_todo.domain.interactors

import com.joaobzao.todoish.feature_todo.data.entities.Todo
import com.joaobzao.todoish.feature_todo.domain.repositories.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetTodos(
    private val repository: TodoRepository
) {

    operator fun invoke(): Flow<List<Todo>> {
        return repository.getTodos()
    }

}