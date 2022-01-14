package com.joaobzao.todoish.feature_todo.domain.usecase

data class TodoUseCases(
    val getTodos: GetTodos,
    val deleteTodo: DeleteTodo,
    val addTodo: AddTodo
)