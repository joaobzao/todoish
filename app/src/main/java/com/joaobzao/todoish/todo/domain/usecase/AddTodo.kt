package com.joaobzao.todoish.todo.domain.usecase

import com.joaobzao.todoish.todo.data.entities.InvalidTodoException
import com.joaobzao.todoish.todo.data.entities.Todo
import com.joaobzao.todoish.todo.domain.repositories.TodoRepository

class AddTodo(
    private val repository: TodoRepository
) {

    @Throws(InvalidTodoException::class)
    suspend operator fun invoke(todo: Todo) {
        if (todo.title.isBlank()) {
            throw InvalidTodoException("👻 The todo title can't be empty!")
        }
        repository.insertTodo(todo)
    }
}