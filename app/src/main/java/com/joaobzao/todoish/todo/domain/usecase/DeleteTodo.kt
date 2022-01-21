package com.joaobzao.todoish.todo.domain.usecase

import com.joaobzao.todoish.todo.data.entities.Todo
import com.joaobzao.todoish.todo.domain.repositories.TodoRepository

class DeleteTodo(
    private val repository: TodoRepository
) {

    suspend operator fun invoke(todo: Todo) {
        repository.deleteTodo(todo)
    }
}