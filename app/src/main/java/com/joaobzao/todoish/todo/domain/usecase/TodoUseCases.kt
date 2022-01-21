package com.joaobzao.todoish.todo.domain.usecase

data class TodoUseCases(
    val getTodos: GetTodos,
    val deleteTodo: DeleteTodo,
    val addTodo: AddTodo
)