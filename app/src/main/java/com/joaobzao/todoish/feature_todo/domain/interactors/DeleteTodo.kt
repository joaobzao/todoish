package com.joaobzao.todoish.feature_todo.domain.interactors

import com.joaobzao.todoish.feature_todo.data.entities.Todo
import com.joaobzao.todoish.feature_todo.domain.repositories.TodoRepository

class DeleteTodo(
    private val repository: TodoRepository
) {

    suspend operator fun invoke(todo: Todo) {
        repository.deleteTodo(todo)
    }
}