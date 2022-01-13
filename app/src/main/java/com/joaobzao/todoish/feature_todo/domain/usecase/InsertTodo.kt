package com.joaobzao.todoish.feature_todo.domain.usecase

import com.joaobzao.todoish.feature_todo.data.entities.Todo
import com.joaobzao.todoish.feature_todo.domain.repositories.TodoRepository

class InsertTodo(
    private val repository: TodoRepository
) {

    suspend operator fun invoke(todo: Todo) {
        repository.insertTodo(todo)
    }
}